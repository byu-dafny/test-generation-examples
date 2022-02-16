module extern {
  class {:extern} SatelliteDataCache {
    constructor() {}
    function method getBarometricPressure() : real
    function method getHumidityLevel() : real
    function method getWindSpeed() : real
    function method getTemperature() : real
  }

  class {:extern} SatConn {
    constructor() {}
    method retrieveCurrentData() returns (cache : SatelliteDataCache)
    
    method retrievePreviousData() returns (cache : SatelliteDataCache)
    
    method otherStationsStormWarning() returns (warning : bool)
    method otherStationsTornadoWarning() returns (warning : bool)
  }
}