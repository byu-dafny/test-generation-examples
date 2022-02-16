import instruments.Anemometer;
import instruments.Barometer;
import instruments.Hygrometer;
import instruments.Thermometer;
import instruments.satellite.SatelliteUplink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherStationTests {

    // WeatherStation test object
    private WeatherStation testSubject;

    // Classes needed for weather station
    Anemometer anemometer;
    Barometer barometer;
    Hygrometer hygrometer;
    Thermometer thermometer;
    SatelliteUplink uplinkSpy;

    @BeforeEach
    public void setup() {
        // Mock out weather station tools
        anemometer = Mockito.mock(Anemometer.class);
        barometer = Mockito.mock(Barometer.class);
        hygrometer = Mockito.mock(Hygrometer.class);
        thermometer = Mockito.mock(Thermometer.class);

        // Create an instance of uplink and spy on it
        uplinkSpy = Mockito.spy(new SatelliteUplink());

        // Initialize testSubject and give it everything
        testSubject = new WeatherStation();

        testSubject.setAnemometer(anemometer);
        testSubject.setBarometer(barometer);
        testSubject.setHygrometer(hygrometer);
        testSubject.setThermometer(thermometer);
        testSubject.setSatelliteUplink(uplinkSpy);
    }

    // This test does not involve the satellite uplink made by dafny
    @Test
    @DisplayName("Test for anemometer calibration check")
    public void testForAnemometerCalibrationCheck() {
        // Mockito when statements
        Mockito.when(anemometer.getWindSpeed()).thenReturn(10.2, 12.0);
        Mockito.when(anemometer.getWindDirInDegrees()).thenReturn(30.4, 40.68);

        Assertions.assertFalse(testSubject.anemometerCalibrationCheck());
    }

    // The rest of the tests will involve the satellite uplink made by dafny
    @Test
    @DisplayName("Test for running storm warning check")
    public void testForRunningStormWarningCheck() {
        // Mockito when statements
        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(40.43, 30.6);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(800.45, 900.68, 1200.9);
        Mockito.when(thermometer.getCurrentTemperature()).thenReturn(75.80, 60.67);
        Mockito.when(uplinkSpy.checkNearbyAreaStorms()).thenReturn(false);

        Assertions.assertTrue(testSubject.runStormWarningCheck());
        Assertions.assertTrue(testSubject.runStormWarningCheck());
        Assertions.assertFalse(testSubject.runStormWarningCheck());

        // Check that checkNearbyAreaStorms was called ONCE during this test
        Mockito.verify(uplinkSpy, Mockito.times(1)).checkNearbyAreaStorms();
    }

    @Test
    @DisplayName("Test tornado warning is suggested")
    public void testTornadoWarningIsSuggested() {
        // Mockito setup
        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(29.45);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(640.58, 967.3);
        Mockito.when(anemometer.getWindSpeed()).thenReturn(14.58, 15.65);
        Mockito.when(uplinkSpy.checkNearbyAreaTornadoes()).thenReturn(false);

        Assertions.assertTrue(testSubject.runTornadoWarningCheck());
        Assertions.assertFalse(testSubject.runTornadoWarningCheck());

        // Check that checkNearbyAreaTornadoes was called ONCE during this test
        Mockito.verify(uplinkSpy, Mockito.times(1)).checkNearbyAreaTornadoes();
    }

}
