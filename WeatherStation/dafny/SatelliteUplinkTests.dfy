include "SatelliteUplink.dfy"
include "Utils.dfy"
include "Extern.dfy"

module SatelliteUplinkTests {
    import opened SatelliteUplink
    import opened Extern
    import opened Utils

    class SatelliteUplinkTests {

        // Needed Constants
        const MAX_HUMIDITY := 100 as Int;
        const MAX_WINDSPEED := 200 as Int;
        const MAX_AIR_PRESSURE := 1100 as Int;
        const MAX_TEMPERATURE := 175 as Int;

        const MIN_HUMIDITY := 0 as Int;
        const MIN_WINDSPEED := 0 as Int;
        const MIN_AIR_PRESSURE := 800 as Int;
        const MIN_TEMPERATURE := -175 as Int;

        // Mocks for the SatelliteUplink
        method {:extern} {:mock} getCurrentDataMock() returns (cache: Extern.SatelliteDataCache)
        ensures fresh(cache)
        ensures cache.getBarometricPressure() == 800
        ensures cache.getHumidityLevel() == 30
        ensures cache.getWindSpeed() == 15
        ensures cache.getTemperature() == 75

        method {:extern} {:mock} getPreviousDataMock() returns (cache: Extern.SatelliteDataCache)
        ensures fresh(cache)
        ensures cache.getBarometricPressure() == 1000
        ensures cache.getHumidityLevel() == 30
        ensures cache.getWindSpeed() == 15
        ensures cache.getTemperature() == 75

        // Setup Method
        method getNewInstance() returns (uplink : SatelliteUplink.SatelliteUplink)
        ensures fresh(uplink)
        ensures uplink.validSatelliteUplink()
        {
            uplink := new SatelliteUplink.SatelliteUplink.init();

            // Add mocks to the uplink
            var currentData := getCurrentDataMock();
            var previousData := getPreviousDataMock();

            uplink.setCurrentData(currentData);
            uplink.setPreviousData(previousData);
        }

        static method Parameterized_ShouldReturnStormWarning_Provider() returns (testInputs : seq<(Int, Int, Int)>)
        {
            testInputs := [
                (40, 800, 75),
                (35, 900, 60)
            ];
        }

        method {:test "MethodSource", "Parameterized_ShouldReturnStormWarning_Provider"} test_ShouldReturnStormWarning(humidity: Int, airPressure: Int, temperature: Int)
        requires MIN_HUMIDITY <= humidity < MAX_HUMIDITY
        requires MIN_AIR_PRESSURE <= airPressure < MAX_AIR_PRESSURE
        requires MIN_TEMPERATURE <= temperature < MAX_TEMPERATURE
        {
            // setup
            var uplink := getNewInstance();

            var stormWarning := uplink.runStormCheckForArea(humidity, airPressure, temperature);

            Assertions<bool>.expectTrue(stormWarning);
        }

        static method Parameterized_ShouldReturn_No_StormWarning_Provider() returns (testInputs : seq<(Int, Int, Int)>)
        {
            testInputs := [
                (35, 1090, 60),
                (38, 1050, 30),
                (20, 1050, 30)
            ];
        }

        method {:test "MethodSource", "Parameterized_ShouldReturn_No_StormWarning_Provider"} test_shouldReturn_No_StormWarning(humidity: Int, airPressure: Int, temperature: Int)
        requires MIN_HUMIDITY <= humidity < MAX_HUMIDITY
        requires MIN_AIR_PRESSURE <= airPressure < MAX_AIR_PRESSURE
        requires MIN_TEMPERATURE <= temperature < MAX_TEMPERATURE
        {
            // setup
            var uplink := getNewInstance();

            var stormWarning := uplink.runStormCheckForArea(humidity, airPressure, temperature);

            Assertions<bool>.expectFalse(stormWarning);
        }

        static method Parameterized_ShouldReturnTornadoWarning_Provider() returns (testInputs : seq<(Int, Int, Int)>)
        {
            testInputs := [
                (45, 967, 17),
                (32, 800, 14)
            ];
        }

        method {:test "MethodSource", "Parameterized_ShouldReturnTornadoWarning_Provider"} test_shouldReturnTornadoWarning(humidity: Int, airPressure: Int, windSpeed: Int)
        requires MIN_HUMIDITY <= humidity < MAX_HUMIDITY
        requires MIN_AIR_PRESSURE <= airPressure < MAX_AIR_PRESSURE
        requires MIN_WINDSPEED <= windSpeed < MAX_WINDSPEED
        {
            // setup
            var uplink := getNewInstance();

            var tornadoWarning := uplink.runTornadoCheckForArea(humidity, airPressure, windSpeed);
            // assert(tornadoWarning == true);
            Assertions<bool>.expectTrue(tornadoWarning);
        }

        static method Parameterized_ShouldReturn_No_TornadoWarning_Provider() returns (testInputs : seq<(Int, Int, Int)>)
        {
            testInputs := [
                (29, 950, 17),
                (31, 900, 14),
                (45, 900, 14)
            ];
        }

        method {:test "MethodSource", "Parameterized_ShouldReturn_No_TornadoWarning_Provider"} test_shouldReturn_No_TornadoWarning(humidity: Int, airPressure: Int, windSpeed: Int)
        requires MIN_HUMIDITY <= humidity < MAX_HUMIDITY
        requires MIN_AIR_PRESSURE <= airPressure < MAX_AIR_PRESSURE
        requires MIN_WINDSPEED <= windSpeed < MAX_WINDSPEED
        {
            // setup
            var uplink := getNewInstance();

            var tornadoWarning := uplink.runTornadoCheckForArea(humidity, airPressure, windSpeed);

            Assertions<bool>.expectFalse(tornadoWarning);
        }

    }
}