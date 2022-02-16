package instruments.satellite;

public class SatConnDummy implements SatConn {

  private final SatelliteDataCache dummyDataMorning;
  private final SatelliteDataCache dummyDataEvening;

  public SatConnDummy() {
    dummyDataMorning = new SatelliteDataCache(1000, 30, 15, 75);
    dummyDataEvening = new SatelliteDataCache(800, 30, 15, 75);
  }

  @Override
  public SatelliteDataCache retrieveCurrentData() {
    return dummyDataEvening;
  }

  @Override
  public SatelliteDataCache retrievePreviousData() {
    return dummyDataMorning;
  }

  @Override
  public boolean otherStationsStormWarning() {
    return true;
  }

  @Override
  public boolean otherStationsTornadoWarning() {
    return true;
  }
}
