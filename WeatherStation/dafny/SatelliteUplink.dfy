include "Extern.dfy"
include "Utils.dfy"

module SatelliteUplink {

    import opened Extern
    import opened Utils

    class SatelliteUplink {

        var satConn : SatConn?;
        var currentData : SatelliteDataCache?;
        var previousData : SatelliteDataCache?;

        // Maximum allowed value for this system
        const MAX_VALUE := 100000 as Int;

        // Constants for instrument readings
        const MAX_HUMIDITY := 100 as Int;
        const MAX_WINDSPEED := 200 as Int;
        const MAX_AIR_PRESSURE := 1100 as Int;
        const MAX_TEMPERATURE := 175 as Int;

        const MIN_HUMIDITY := 0 as Int;
        const MIN_WINDSPEED := 0 as Int;
        const MIN_AIR_PRESSURE := 800 as Int;
        const MIN_TEMPERATURE := -175 as Int;

        // Current Data Ghosts
        ghost var ghostCurrentHumidityLevel : Int;
        ghost var ghostCurrentAirPressure : Int;
        ghost var ghostCurrentTemperature : Int;
        ghost var ghostCurrentWindSpeed : Int;

        // Previous Data Ghosts
        ghost var ghostPreviousHumidityLevel : Int;
        ghost var ghostPreviousAirPressure : Int;

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

        function method abs(val : Int) : Int
        requires -MAX_VALUE <= val < MAX_VALUE
        {
            if val < 0 then -val else val
        }

        function method average(valOne: Int, valTwo: Int) : Int
        requires -MAX_VALUE <= valOne < MAX_VALUE
        requires -MAX_VALUE <= valTwo < MAX_VALUE
        {
            (valOne + valTwo) / 2
        }

        constructor init()
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

        method setCurrentData(data: SatelliteDataCache)
        modifies this`currentData
        ensures this.currentData == data
        {
            this.currentData := data;
        }

        method setPreviousData(data: SatelliteDataCache)
        modifies this`previousData
        ensures this.previousData == data
        {
            this.previousData := data;
        }

        // External Dafny Wrappers
        method getBarometricPressure'(cache: SatelliteDataCache) returns (bp : Int)
        ensures MIN_AIR_PRESSURE <= bp < MAX_AIR_PRESSURE
        {
        bp := cache.getBarometricPressure();
        expect MIN_AIR_PRESSURE <= bp < MAX_AIR_PRESSURE;
        } 

        method getHumidityLevel'(cache: SatelliteDataCache) returns (h : Int)
        ensures MIN_HUMIDITY <= h < MAX_HUMIDITY
        {
        h := cache.getHumidityLevel();
        expect MIN_HUMIDITY <= h < MAX_HUMIDITY;
        }

        method getWindSpeed'(cache: SatelliteDataCache) returns (w : Int)
        ensures MIN_WINDSPEED <= w < MAX_WINDSPEED
        {
        w := cache.getWindSpeed();
        expect MIN_WINDSPEED <= w < MAX_WINDSPEED;
        }

        method getTemperature'(cache: SatelliteDataCache) returns (t : Int)
        ensures MIN_TEMPERATURE <= t < MAX_TEMPERATURE
        {
        t := cache.getTemperature();
        expect MIN_WINDSPEED <= t < MAX_TEMPERATURE;
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

        method runStormCheckForArea(localHumidity : Int, localAirPressure : Int, localTemperature : Int) returns (warningSuggested : bool)
        requires validSatelliteUplink()
        requires MIN_HUMIDITY <= localHumidity < MAX_HUMIDITY
        requires MIN_AIR_PRESSURE <= localAirPressure < MAX_AIR_PRESSURE
        requires MIN_TEMPERATURE <= localTemperature < MAX_TEMPERATURE
        modifies this`ghostCurrentHumidityLevel
        modifies this`ghostCurrentAirPressure
        modifies this`ghostCurrentTemperature
        ensures MIN_HUMIDITY <= ghostCurrentHumidityLevel < MAX_HUMIDITY
        ensures MIN_AIR_PRESSURE <= ghostCurrentAirPressure < MAX_AIR_PRESSURE
        ensures MIN_TEMPERATURE <= ghostCurrentTemperature < MAX_TEMPERATURE
        ensures average(localHumidity, ghostCurrentHumidityLevel) > 30 && average(localTemperature, ghostCurrentTemperature) > 70 ==> warningSuggested == true
        ensures average(localHumidity, ghostCurrentHumidityLevel) > 30 && average(localAirPressure, ghostCurrentAirPressure) < 900 ==> warningSuggested == true
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

            if ((avgHumidityLevel > 30 && avgTemperature > 70) || (avgHumidityLevel > 30 && avgAirPressure < 900)) {
                warningSuggested := true;
            } else {
                warningSuggested := checkNearbyAreaStorms();
            }
        }

        method runTornadoCheckForArea(localHumidity : Int, localAirPressure : Int, localWindSpeed : Int) returns (warningSuggested : bool)
        requires validSatelliteUplink()
        requires MIN_HUMIDITY <= localHumidity < MAX_HUMIDITY
        requires MIN_AIR_PRESSURE <= localAirPressure < MAX_AIR_PRESSURE
        requires MIN_WINDSPEED <= localWindSpeed < MAX_WINDSPEED
        modifies this`ghostCurrentHumidityLevel
        modifies this`ghostCurrentAirPressure
        modifies this`ghostCurrentWindSpeed
        modifies this`ghostPreviousHumidityLevel
        modifies this`ghostPreviousAirPressure
        ensures MIN_HUMIDITY <= this.ghostCurrentHumidityLevel < MAX_HUMIDITY
        ensures MIN_AIR_PRESSURE <= this.ghostCurrentAirPressure < MAX_AIR_PRESSURE
        ensures MIN_WINDSPEED <= this.ghostCurrentWindSpeed < MAX_WINDSPEED
        ensures MIN_HUMIDITY <= this.ghostPreviousHumidityLevel < MAX_HUMIDITY
        ensures MIN_AIR_PRESSURE <= this.ghostPreviousAirPressure < MAX_AIR_PRESSURE
        ensures abs(average(localAirPressure, ghostCurrentAirPressure) - ghostPreviousAirPressure) > 150 ==> warningSuggested == true
        ensures abs(average(localHumidity, ghostCurrentHumidityLevel) - ghostPreviousHumidityLevel) > 5
                    && average(localWindSpeed, ghostCurrentWindSpeed) > 15
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
            if (airPressureDiff > 150 || (humidityDiff > 5 && windSpeedAvg > 15)) {
                warningSuggested := true;
            } else {
                warningSuggested := checkNearbyAreaTornadoes();
            }
        }
    }
}
