package instruments.satellite;

public class SatConn {

  private final SatelliteDataCache dummyDataMorning;
  private final SatelliteDataCache dummyDataEvening;

  public SatConn() {
    dummyDataMorning = new SatelliteDataCache(1000, 30, 15, 75);
    dummyDataEvening = new SatelliteDataCache(800, 30, 15, 75);
  }

  public SatelliteDataCache retrieveCurrentData() {
    return dummyDataEvening;
  }

  public SatelliteDataCache retrievePreviousData() {
    return dummyDataMorning;
  }

  public boolean otherStationsStormWarning() {
    return false;
  }

  public boolean otherStationsTornadoWarning() {
    return false;
  }
}
