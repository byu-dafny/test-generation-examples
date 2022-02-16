include "Extern.dfy"

import opened extern

// newtype double = d: real | -128.0 <= d < 128.0

class SatelliteUplink {

    var satConn : SatConn?;
    var currentData : SatelliteDataCache?;
    var previousData : SatelliteDataCache?;

    // Current Data Ghosts
    ghost var ghostCurrentHumidityLevel : real;
    ghost var ghostCurrentAirPressure : real;
    ghost var ghostCurrentTemperature : real;
    ghost var ghostCurrentWindSpeed : real;

    // Previous Data Ghosts
    ghost var ghostPreviousHumidityLevel : real;
    ghost var ghostPreviousAirPressure : real;

    // Validity predicate
    predicate validSatelliteUplink()
    reads this`satConn
    reads this`currentData
    reads this`previousData
    {
        satConn != null
        && currentData != null
        && previousData != null
    }

    function method abs(val : real) : real
    {
        if val < 0.0 then -val else val
    }

    function method average(valOne: real, valTwo: real) : real
    {
        (valOne + valTwo) / 2.0
    }

    constructor()
    ensures validSatelliteUplink()
    {
        satConn := null;
        currentData := null;
        previousData := null;
        new;
        satConn := new SatConn();
        currentData := satConn.retrieveCurrentData();
        previousData := satConn.retrievePreviousData();
    }

    // External Dafny Wrappers
    method getBarometricPressure'(cache: SatelliteDataCache) returns (bp : real)
    ensures bp > 0.0
    {
      bp := cache.getBarometricPressure();
      expect bp > 0.0;
    } 

    method getHumidityLevel'(cache: SatelliteDataCache) returns (h : real)
    ensures h > 0.0
    {
      h := cache.getHumidityLevel();
      expect h > 0.0;
    }

    method getWindSpeed'(cache: SatelliteDataCache) returns (w : real)
    ensures w > 0.0
    {
      w := cache.getWindSpeed();
      expect w > 0.0;
    }

    method getTemperature'(cache: SatelliteDataCache) returns (t : real)
    ensures t > 0.0
    {
      t := cache.getTemperature();
      expect t > 0.0;
    }

    method checkNearbyAreaStorms() returns (warningSuggested : bool)
    requires validSatelliteUplink()
    {
        warningSuggested := satConn.otherStationsStormWarning();
    }

    method checkNearbyAreaTornadoes() returns (warningSuggested : bool)
    requires validSatelliteUplink()
    {
        warningSuggested := satConn.otherStationsTornadoWarning();
    }

    method runStormCheckForArea'(localHumidity : real, localAirPressure : real, localTemperature : real) returns (warningSuggested : bool)
    requires validSatelliteUplink()
    requires localHumidity > 0.0
    requires localAirPressure > 0.0
    requires localTemperature > 0.0
    modifies this`ghostCurrentHumidityLevel
    modifies this`ghostCurrentAirPressure
    modifies this`ghostCurrentTemperature
    ensures average(localHumidity, ghostCurrentHumidityLevel) > 30.0 && average(localTemperature, ghostCurrentTemperature) > 70.0 ==> warningSuggested == true
    ensures average(localHumidity, ghostCurrentHumidityLevel) > 30.0 && average(localAirPressure, ghostCurrentAirPressure) < 900.0 ==> warningSuggested == true
    {
        var currHumidityLevel := getHumidityLevel'(currentData);
        var currAirPressure := getBarometricPressure'(currentData);
        var currTemperature := getTemperature'(currentData);

        // Assign Ghost variables for Verification
        ghostCurrentHumidityLevel := currHumidityLevel;
        ghostCurrentAirPressure := currAirPressure;
        ghostCurrentTemperature := currTemperature;

        var avgHumidityLevel := average(localHumidity, currHumidityLevel);
        var avgAirPressure := average(localAirPressure, currAirPressure);
        var avgTemperature := average(localTemperature, currTemperature);

        if ((avgHumidityLevel > 30.0 && avgTemperature > 70.0) || (avgHumidityLevel > 30.0 && avgAirPressure < 900.0)) {
            warningSuggested := true;
        } else {
            warningSuggested := checkNearbyAreaStorms();
        }
    }

    method runTornadoCheckForArea'(localHumidity : real, localAirPressure : real, localWindSpeed : real) returns (warningSuggested : bool)
    requires validSatelliteUplink()
    requires localHumidity > 0.0
    requires localAirPressure > 0.0
    requires localWindSpeed > 0.0
    modifies this`ghostCurrentHumidityLevel
    modifies this`ghostCurrentAirPressure
    modifies this`ghostCurrentWindSpeed
    modifies this`ghostPreviousHumidityLevel
    modifies this`ghostPreviousAirPressure
    ensures abs(average(localAirPressure, ghostCurrentAirPressure) - ghostPreviousAirPressure) > 150.0 ==> warningSuggested == true
    ensures abs(average(localHumidity, ghostCurrentHumidityLevel) - ghostPreviousHumidityLevel) > 5.0
                && average(localWindSpeed, ghostCurrentWindSpeed) > 15.0
                ==> warningSuggested == true
    {
        // Air Pressure Calculations
        var currAirPressure := getBarometricPressure'(currentData);
        var prevAirPressure := getBarometricPressure'(previousData);

        ghostCurrentAirPressure := currAirPressure;
        ghostPreviousAirPressure := prevAirPressure;

        var airPressureAvg := average(localAirPressure, currAirPressure);
        var airPressureDiff := abs(airPressureAvg - prevAirPressure);

        // Humidity Calculations
        var currHumidityLevel := getHumidityLevel'(currentData);
        var prevHumidityLevel := getHumidityLevel'(previousData);

        ghostCurrentHumidityLevel := currHumidityLevel;
        ghostPreviousHumidityLevel := prevHumidityLevel;

        var humidityAvg := average(localHumidity, currHumidityLevel);
        var humidityDiff := abs(humidityAvg - prevHumidityLevel);

        // Wind Speed Calculations
        var currWindSpeed := getWindSpeed'(currentData);

        ghostCurrentWindSpeed := currWindSpeed;

        var windSpeedAvg := average(localWindSpeed, currWindSpeed);

        // Suggest Tornado Warning based off of calculations
        if (airPressureDiff > 150.0 || (humidityDiff > 5.0 && windSpeedAvg > 15.0)) {
            warningSuggested := true;
        } else {
            warningSuggested := checkNearbyAreaTornadoes();
        }
    }
}
