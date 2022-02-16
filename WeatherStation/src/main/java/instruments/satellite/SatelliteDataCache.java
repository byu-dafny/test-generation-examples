package instruments.satellite;

/**
 * POJO (Plain Old Java Object) which only purpose is to contain satellite
 * readings
 */
public class SatelliteDataCache {

  // Composite data from other stations and satellite readings
  private double barometricPressure;
  private double humidityLevel;
  private double windSpeed;
  private double temperature;

  public SatelliteDataCache(double barometricPressure, double humidityLevel, double windSpeed, double temperature) {
    this.barometricPressure = barometricPressure;
    this.humidityLevel = humidityLevel;
    this.windSpeed = windSpeed;
    this.temperature = temperature;
  }

  public double getBarometricPressure() {
    return barometricPressure;
  }

  public void setBarometricPressure(double barometricPressure) {
    this.barometricPressure = barometricPressure;
  }

  public double getHumidityLevel() {
    return humidityLevel;
  }

  public void setHumidityLevel(double humidityLevel) {
    this.humidityLevel = humidityLevel;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(double windSpeed) {
    this.windSpeed = windSpeed;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }
}
