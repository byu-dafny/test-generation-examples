package instruments.satellite;

public class SatelliteUplinkOld {

  private final SatConn satConn;
  private final SatelliteDataCache currentData;
  private final SatelliteDataCache previousData;

  /**
   * Default Constructor instantiates the SatelliteUplink class with
   * {@link SatConnDummy} which returns dummy data.
   */
  public SatelliteUplinkOld() {
    satConn = new SatConn();
    previousData = satConn.retrievePreviousData();
    currentData = satConn.retrieveCurrentData();
  }

  /**
   * Averages all parameters passed with the corresponding satellite datum value.
   * A storm warning will be suggested based on one of the following criterion:
   * <ul>
   * <li>Humidity average exceeds 30 and temperature average exceeds 70</li>
   * <li>Humidity average exceeds 30 and air pressure is less than 900</li>
   * </ul>
   *
   * If none of these conditions are met, {@link #checkNearbyAreaStorms()} is
   * called to check if nearby
   * areas (via satellite) have issued a storm warning. If so, a storm warning
   * will be suggested.
   *
   * <p>
   * <b>Dummy Data</b>
   * <p>
   * currentData returns the following:
   * <ul>
   * <li>Humidity: 30</li>
   * <li>Barometric (Air) Pressure: 800</li>
   * <li>Temperature: 75</li>
   * </ul>
   * 
   * @param localHumidity    The humidity reading
   * @param localAirPressure The air pressure reading
   * @param localTemperature The temperature reading
   * @return True if a storm warning is suggested. False otherwise.
   */
  public boolean runStormCheckForArea(int localHumidity, int localAirPressure, int localTemperature) {
    boolean stormWarningSuggested;
    int currHumidityAvg = (currentData.getHumidityLevel() + localHumidity) / 2;
    int currAirPressureAvg = (currentData.getBarometricPressure() + localAirPressure) / 2;
    int currTempAvg = (currentData.getTemperature() + localTemperature) / 2;

    if ((currHumidityAvg > 30 && currTempAvg > 70) || (currHumidityAvg > 30 && currAirPressureAvg < 900)) {
      stormWarningSuggested = true;
    } else {
      stormWarningSuggested = checkNearbyAreaStorms();
    }

    return stormWarningSuggested;
  }

  /**
   * <p>
   * Averages all parameters passed with the corresponding satellite datum value.
   * Also checks the difference in air pressure against earlier readings (earlier
   * reading will be 800)
   * and do the same for humidity (earlier reading will be 30, same as current).
   * A tornado warning will be suggested based on one of the following criterion:
   * <ul>
   * <li>Difference in air pressure is above 150</li>
   * <li>Humidity difference exceeds 5 AND wind speed average is greater than
   * 15</li>
   * </ul>
   *
   * <p>
   * If none of these conditions are met, {@link #checkNearbyAreaTornadoes()} is
   * called to check if nearby
   * areas (via satellite) have issued a tornado warning. If so, a tornado warning
   * will be suggested.
   *
   * <p>
   * <b>Dummy Data</b>
   * <p>
   * currentData returns the following:
   * <ul>
   * <li>Humidity: 30</li>
   * <li>Barometric (Air) Pressure: 800</li>
   * <li>Wind Speed: 15</li>
   * </ul>
   * <p>
   * previousData returns the following:
   * <ul>
   * <li>Barometric (Air) Pressure: 1000</li>
   * <li>Wind Speed: 15</li>
   * </ul>
   * 
   * @param localHumidity    The humidity reading
   * @param localAirPressure The air pressure reading
   * @param localWindSpeed   The wind speed reading
   * @return True if a tornado warning is suggested. False otherwise.
   */
  public boolean runTornadoCheckForArea(int localHumidity, int localAirPressure, int localWindSpeed) {
    boolean tornadoWarningSuggested;
    int currHumidityAvg = (currentData.getHumidityLevel() + localHumidity) / 2;
    int currAirPressureAvg = (currentData.getBarometricPressure() + localAirPressure) / 2;
    int currWindSpeedAvg = (currentData.getWindSpeed() + localWindSpeed) / 2;
    int airPressureDiff = Math.abs(currAirPressureAvg - previousData.getBarometricPressure());
    int humidityDiff = Math.abs(currHumidityAvg - previousData.getHumidityLevel());

    if (airPressureDiff > 150 || (humidityDiff > 5 && currWindSpeedAvg > 15)) {
      tornadoWarningSuggested = true;
    } else {
      tornadoWarningSuggested = checkNearbyAreaTornadoes();
    }

    return tornadoWarningSuggested;
  }

  /**
   * Calls the satellite to check if other nearby weather stations issued a
   * tornado warning.
   *
   * <p>
   * <b>Dummy data always return true.</b>
   *
   * @return True if other nearby weather stations issued a tornado warning.
   */
  public boolean checkNearbyAreaTornadoes() {
    return satConn.otherStationsTornadoWarning();
  }

  /**
   * Calls the satellite to check if other nearby weather stations issued a storm
   * warning.
   *
   * <p>
   * <b>Dummy data always return true.</b>
   *
   * @return True if other nearby weather stations issued a storm warning.
   */
  public boolean checkNearbyAreaStorms() {
    return satConn.otherStationsStormWarning();
  }
}
