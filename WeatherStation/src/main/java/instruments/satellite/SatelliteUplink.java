// Class SatelliteUplink
// Dafny class SatelliteUplink compiled into Java
package instruments.satellite;

@SuppressWarnings({"unchecked", "deprecation"})
public class SatelliteUplink {
  public SatelliteUplink() {
    this.satConn = (SatConn) null;
    this.currentData = (SatelliteDataCache) null;
    this.previousData = (SatelliteDataCache) null;
  }
  public SatConn satConn;
  public SatelliteDataCache currentData;
  public SatelliteDataCache previousData;
  public int abs(int val) {
    if (Integer.signum((val)) == -1) {
      return (int)  ((0) - (val));
    } else {
      return val;
    }
  }
  public int average(int valOne, int valTwo)
  {
    return dafny.DafnyEuclidean.EuclideanDivision((int)  ((valOne) + (valTwo)), 2);
  }
  public void init()
  {
    (this).satConn = (SatConn) null;
    (this).currentData = (SatelliteDataCache) null;
    (this).previousData = (SatelliteDataCache) null;
    SatConn _nw0 = new SatConn();

    // Not needed for this system
    // _nw0.__ctor();
    
    (this).satConn = _nw0;
    SatelliteDataCache _out0;
    _out0 = (this.satConn).retrieveCurrentData();
    (this).currentData = _out0;
    SatelliteDataCache _out1;
    _out1 = (this.satConn).retrievePreviousData();
    (this).previousData = _out1;
  }
  public void setCurrentData(SatelliteDataCache data)
  {
    (this).currentData = data;
  }
  public void setPreviousData(SatelliteDataCache data)
  {
    (this).previousData = data;
  }
  public int getBarometricPressure_k(SatelliteDataCache cache)
  {
    int bp = 0;
    if(true) {
      bp = (cache).getBarometricPressure();
      if (!((((this).MIN__AIR__PRESSURE()) <= (bp)) && ((bp) < ((this).MAX__AIR__PRESSURE())))) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(94,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return bp;
  }
  public int getHumidityLevel_k(SatelliteDataCache cache)
  {
    int h = 0;
    if(true) {
      h = (cache).getHumidityLevel();
      if (!((((this).MIN__HUMIDITY()) <= (h)) && ((h) < ((this).MAX__HUMIDITY())))) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(101,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return h;
  }
  public int getWindSpeed_k(SatelliteDataCache cache)
  {
    int w = 0;
    if(true) {
      w = (cache).getWindSpeed();
      if (!((((this).MIN__WINDSPEED()) <= (w)) && ((w) < ((this).MAX__WINDSPEED())))) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(108,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return w;
  }
  public int getTemperature_k(SatelliteDataCache cache)
  {
    int t = 0;
    if(true) {
      t = (cache).getTemperature();
      if (!((((this).MIN__WINDSPEED()) <= (t)) && ((t) < ((this).MAX__TEMPERATURE())))) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(115,8): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return t;
  }
  public boolean checkNearbyAreaStorms()
  {
    boolean warningSuggested = false;
    if(true) {
      boolean _out2;
      _out2 = (this.satConn).otherStationsStormWarning();
      warningSuggested = _out2;
    }
    return warningSuggested;
  }
  public boolean checkNearbyAreaTornadoes()
  {
    boolean warningSuggested = false;
    if(true) {
      boolean _out3;
      _out3 = (this.satConn).otherStationsTornadoWarning();
      warningSuggested = _out3;
    }
    return warningSuggested;
  }
  public boolean runStormCheckForArea(int localHumidity, int localAirPressure, int localTemperature)
  {
    boolean warningSuggested = false;
    if(true) {
      int _157_currHumidityLevel;
      int _out4;
      _out4 = (this).getHumidityLevel_k(this.currentData);
      _157_currHumidityLevel = _out4;
      int _158_currAirPressure;
      int _out5;
      _out5 = (this).getBarometricPressure_k(this.currentData);
      _158_currAirPressure = _out5;
      int _159_currTemperature;
      int _out6;
      _out6 = (this).getTemperature_k(this.currentData);
      _159_currTemperature = _out6;
      int _160_avgHumidityLevel;
      _160_avgHumidityLevel = (this).average(localHumidity, _157_currHumidityLevel);
      int _161_avgAirPressure;
      _161_avgAirPressure = (this).average(localAirPressure, _158_currAirPressure);
      int _162_avgTemperature;
      _162_avgTemperature = (this).average(localTemperature, _159_currTemperature);
      if ((((_160_avgHumidityLevel) > (30)) && ((_162_avgTemperature) > (70))) || (((_160_avgHumidityLevel) > (30)) && ((_161_avgAirPressure) < (900)))) {
        warningSuggested = true;
      } else {
        boolean _out7;
        _out7 = (this).checkNearbyAreaStorms();
        warningSuggested = _out7;
      }
    }
    return warningSuggested;
  }
  public boolean runTornadoCheckForArea(int localHumidity, int localAirPressure, int localWindSpeed)
  {
    boolean warningSuggested = false;
    if(true) {
      int _163_currAirPressure;
      int _out8;
      _out8 = (this).getBarometricPressure_k(this.currentData);
      _163_currAirPressure = _out8;
      int _164_prevAirPressure;
      int _out9;
      _out9 = (this).getBarometricPressure_k(this.previousData);
      _164_prevAirPressure = _out9;
      int _165_airPressureAvg;
      _165_airPressureAvg = (this).average(localAirPressure, _163_currAirPressure);
      int _166_airPressureDiff;
      _166_airPressureDiff = (this).abs((int)  ((_165_airPressureAvg) - (_164_prevAirPressure)));
      int _167_currHumidityLevel;
      int _out10;
      _out10 = (this).getHumidityLevel_k(this.currentData);
      _167_currHumidityLevel = _out10;
      int _168_prevHumidityLevel;
      int _out11;
      _out11 = (this).getHumidityLevel_k(this.previousData);
      _168_prevHumidityLevel = _out11;
      int _169_humidityAvg;
      _169_humidityAvg = (this).average(localHumidity, _167_currHumidityLevel);
      int _170_humidityDiff;
      _170_humidityDiff = (this).abs((int)  ((_169_humidityAvg) - (_168_prevHumidityLevel)));
      int _171_currWindSpeed;
      int _out12;
      _out12 = (this).getWindSpeed_k(this.currentData);
      _171_currWindSpeed = _out12;
      int _172_windSpeedAvg;
      _172_windSpeedAvg = (this).average(localWindSpeed, _171_currWindSpeed);
      if (((_166_airPressureDiff) > (150)) || (((_170_humidityDiff) > (5)) && ((_172_windSpeedAvg) > (15)))) {
        warningSuggested = true;
      } else {
        boolean _out13;
        _out13 = (this).checkNearbyAreaTornadoes();
        warningSuggested = _out13;
      }
    }
    return warningSuggested;
  }
  public int MAX__VALUE()
  {
    return 100000;
  }
  public int MIN__AIR__PRESSURE()
  {
    return 800;
  }
  public int MAX__AIR__PRESSURE()
  {
    return 1100;
  }
  public int MIN__HUMIDITY()
  {
    return 0;
  }
  public int MAX__HUMIDITY()
  {
    return 100;
  }
  public int MIN__WINDSPEED()
  {
    return 0;
  }
  public int MAX__WINDSPEED()
  {
    return 200;
  }
  public int MIN__TEMPERATURE()
  {
    return -175;
  }
  public int MAX__TEMPERATURE()
  {
    return 175;
  }
  private static final dafny.TypeDescriptor<SatelliteUplink> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SatelliteUplink.class, () -> (SatelliteUplink) null);
  public static dafny.TypeDescriptor<SatelliteUplink> _typeDescriptor() {
    return (dafny.TypeDescriptor<SatelliteUplink>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
