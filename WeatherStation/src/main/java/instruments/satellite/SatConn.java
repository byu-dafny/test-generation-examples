package instruments.satellite;

public interface SatConn {

  SatelliteDataCache retrieveCurrentData();

  SatelliteDataCache retrievePreviousData();

  boolean otherStationsStormWarning();

  boolean otherStationsTornadoWarning();
}
