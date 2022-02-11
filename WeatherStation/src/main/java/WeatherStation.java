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
        double humidity = hygrometer.getCurrentHumidity();
        double airPressure = barometer.getAtmosphericPressure();
        double temperature = thermometer.getCurrentTemperature();
        boolean stormWarning = false;

        System.out.println("Humidity: " + humidity + " AirPressure: " + airPressure + " Temp: " + temperature);

        if (humidity > 30 || airPressure < 800 || temperature > 70) {
            stormWarning = satelliteUplink.runStormCheckForArea(humidity, airPressure, temperature);
        }

        return stormWarning;
    }

    public boolean runTornadoWarningCheck() {
        double humidity = hygrometer.getCurrentHumidity();
        double windSpeed = anemometer.getWindSpeed();
        double airPressure = barometer.getAtmosphericPressure();
        boolean tornadoWarning = false;


        if (humidity > 30 || airPressure < 800 || windSpeed > 15) {
            tornadoWarning = satelliteUplink.runTornadoCheckForArea(humidity, airPressure, windSpeed);
        }

        return tornadoWarning;
    }

    public boolean anemometerCalibrationCheck() {
        boolean isAnemometerWorking = true;
        double windSpeedAlpha = anemometer.getWindSpeed();
        double windSpeedBeta = anemometer.getWindSpeed();
        double windDirAlpha = anemometer.getWindDirInDegrees();
        double windDirBeta = anemometer.getWindDirInDegrees();

        double windSpeedDiff = Math.abs(windSpeedAlpha - windSpeedBeta);
        double windDirDiff = Math.abs(windDirAlpha - windDirBeta);

        if (windSpeedDiff > 1 || windDirDiff > 20) {
            isAnemometerWorking = false;
        }

        return isAnemometerWorking;
    }

    public boolean temperatureCalibrationTest() {
        boolean isWorking = true;
        double thermAlpha = thermometer.getCurrentTemperature();
        double thermBeta = thermometer.getCurrentTemperature();
        double thermDiff = Math.abs(thermAlpha - thermBeta);

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
