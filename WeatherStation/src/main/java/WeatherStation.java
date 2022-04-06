import instruments.Anemometer;
import instruments.Barometer;
import instruments.Hygrometer;
import instruments.Thermometer;
import instruments.satellite.SatelliteUplink;

public class WeatherStation {
    private Anemometer anemometer;
    private Barometer barometer;
    private Hygrometer hygrometer;
    private Thermometer thermometer;
    private SatelliteUplink satelliteUplink;

    public boolean runStormWarningCheck() {
        int humidity = hygrometer.getCurrentHumidity();
        int airPressure = barometer.getAtmosphericPressure();
        int temperature = thermometer.getCurrentTemperature();
        boolean stormWarning = false;

        System.out.println("Humidity: " + humidity + " AirPressure: " + airPressure + " Temp: " + temperature);

        if (humidity > 30 || airPressure < 800 || temperature > 70) {
            stormWarning = satelliteUplink.runStormCheckForArea(humidity, airPressure, temperature);
        }

        return stormWarning;
    }

    public boolean runTornadoWarningCheck() {
        int humidity = hygrometer.getCurrentHumidity();
        int windSpeed = anemometer.getWindSpeed();
        int airPressure = barometer.getAtmosphericPressure();
        boolean tornadoWarning = false;


        if (humidity > 30 || airPressure < 800 || windSpeed > 15) {
            tornadoWarning = satelliteUplink.runTornadoCheckForArea(humidity, airPressure, windSpeed);
        }

        return tornadoWarning;
    }

    public boolean anemometerCalibrationCheck() {
        boolean isAnemometerWorking = true;
        int windSpeedAlpha = anemometer.getWindSpeed();
        int windSpeedBeta = anemometer.getWindSpeed();
        int windDirAlpha = anemometer.getWindDirInDegrees();
        int windDirBeta = anemometer.getWindDirInDegrees();

        int windSpeedDiff = Math.abs(windSpeedAlpha - windSpeedBeta);
        int windDirDiff = Math.abs(windDirAlpha - windDirBeta);

        if (windSpeedDiff > 1 || windDirDiff > 20) {
            isAnemometerWorking = false;
        }

        return isAnemometerWorking;
    }

    public boolean temperatureCalibrationTest() {
        boolean isWorking = true;
        int thermAlpha = thermometer.getCurrentTemperature();
        int thermBeta = thermometer.getCurrentTemperature();
        int thermDiff = Math.abs(thermAlpha - thermBeta);

        System.out.println("Alpha: " + thermAlpha + " Beta: " + thermBeta + " Diff: " + thermDiff);

        if (thermDiff > 1) {
            isWorking = false;
        }

        return isWorking;
    }

    public void setAnemometer(Anemometer anemometer) {
        this.anemometer = anemometer;
    }

    public void setBarometer(Barometer barometer) {
        this.barometer = barometer;
    }

    public void setHygrometer(Hygrometer hygrometer) {
        this.hygrometer = hygrometer;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void setSatelliteUplink(SatelliteUplink satelliteUplink) {
        this.satelliteUplink = satelliteUplink;
    }
}
