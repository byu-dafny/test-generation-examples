package instruments.satellite;

/**
 * POJO (Plain Old Java Object) which only purpose is to contain satellite
 * readings
 */
public class SatelliteDataCache {

  // Composite data from other stations and satellite readings
  private int barometricPressure;
  private int humidityLevel;
  private int windSpeed;
  private int temperature;

  public SatelliteDataCache(int barometricPressure, int humidityLevel, int windSpeed, int temperature) {
    this.barometricPressure = barometricPressure;
    this.humidityLevel = humidityLevel;
    this.windSpeed = windSpeed;
    this.temperature = temperature;
  }

  public int getBarometricPressure() {
    return barometricPressure;
  }

  public void setBarometricPressure(int barometricPressure) {
    this.barometricPressure = barometricPressure;
  }

  public int getHumidityLevel() {
    return humidityLevel;
  }

  public void setHumidityLevel(int humidityLevel) {
    this.humidityLevel = humidityLevel;
  }

  public int getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(int windSpeed) {
    this.windSpeed = windSpeed;
  }

  public int getTemperature() {
    return temperature;
  }

  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }
}
