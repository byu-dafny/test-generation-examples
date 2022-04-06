module Extern {

  newtype {:nativeType "int"} Int = x | -2147483648 <= x < 2147483648

  class SatelliteDataCache {
    constructor() {}
    function method {:extern} getBarometricPressure() : Int
    function method {:extern} getHumidityLevel() : Int
    function method {:extern} getWindSpeed() : Int
    function method {:extern} getTemperature() : Int
  }

  class SatConn {
    constructor() {}
    method {:extern} retrieveCurrentData() returns (cache : SatelliteDataCache)
    method {:extern} retrievePreviousData() returns (cache : SatelliteDataCache)
    method {:extern} otherStationsStormWarning() returns (warning : bool)
    method {:extern} otherStationsTornadoWarning() returns (warning : bool)
  }
}