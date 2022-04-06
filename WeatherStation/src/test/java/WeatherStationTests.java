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
    SatelliteUplink uplink;

    @BeforeEach
    public void setup() {
        // Mock out weather station tools
        anemometer = Mockito.mock(Anemometer.class);
        barometer = Mockito.mock(Barometer.class);
        hygrometer = Mockito.mock(Hygrometer.class);
        thermometer = Mockito.mock(Thermometer.class);

        // Create an instance of uplink and spy on it
        uplink = new SatelliteUplink();
        uplink.init();

        // Initialize testSubject and give it everything
        testSubject = new WeatherStation();

        testSubject.setAnemometer(anemometer);
        testSubject.setBarometer(barometer);
        testSubject.setHygrometer(hygrometer);
        testSubject.setThermometer(thermometer);
        testSubject.setSatelliteUplink(uplink);
    }

    // This test does not involve the satellite uplink made by dafny
    @Test
    @DisplayName("Test for anemometer calibration check")
    public void testForAnemometerCalibrationCheck() {
        // Mockito when statements
        Mockito.when(anemometer.getWindSpeed()).thenReturn(10, 12);
        Mockito.when(anemometer.getWindDirInDegrees()).thenReturn(30, 40);

        Assertions.assertFalse(testSubject.anemometerCalibrationCheck());
    }

    // The rest of the tests will involve the satellite uplink made by dafny
    @Test
    @DisplayName("Test for running storm warning check")
    public void testForRunningStormWarningCheck() {
        // Mockito when statements
        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(40, 35, 35, 38);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(800, 900, 1090, 1050);
        Mockito.when(thermometer.getCurrentTemperature()).thenReturn(75, 60, 60, 30);

        Assertions.assertTrue(testSubject.runStormWarningCheck());
        Assertions.assertTrue(testSubject.runStormWarningCheck());
        Assertions.assertFalse(testSubject.runStormWarningCheck());
        Assertions.assertFalse(testSubject.runStormWarningCheck());
    }

    @Test
    @DisplayName("Test tornado warning is suggested")
    public void testTornadoWarningIsSuggested() {
        // Mockito setup
        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(29, 45, 31);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(800, 967, 900);
        Mockito.when(anemometer.getWindSpeed()).thenReturn(14, 17, 14);

        Assertions.assertFalse(testSubject.runTornadoWarningCheck());
        Assertions.assertTrue(testSubject.runTornadoWarningCheck());
        Assertions.assertFalse(testSubject.runTornadoWarningCheck());
    }

}
