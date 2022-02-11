// Class SatelliteUplink
// Dafny class SatelliteUplink compiled into Java
package instruments.satellite;

@SuppressWarnings({"unchecked", "deprecation"})
public class SatelliteUplink {
  public SatelliteUplink() {
    this.satConn = new SatConnDummy();

    // Necessary Change for the generated code to fit
    Init();
  }
  public SatConn satConn;
  public SatelliteDataCache currentData;
  public SatelliteDataCache previousData;
  public dafny.BigRational abs(dafny.BigRational val) {
    if ((val).compareTo((new dafny.BigRational(new java.math.BigInteger("0"), java.math.BigInteger.ONE))) < 0) {
      return (new dafny.BigRational(new java.math.BigInteger("0"), java.math.BigInteger.ONE)).subtract((val));
    } else {
      return val;
    }
  }
  public dafny.BigRational average(dafny.BigRational valOne, dafny.BigRational valTwo)
  {
    return ((valOne).add((valTwo))).divide((new dafny.BigRational(new java.math.BigInteger("2"), java.math.BigInteger.ONE)));
  }

  // public void __ctor()
  // {
  //   SatConn _nw0 = new SatConn();
  //   _nw0.__ctor();
  //   (this).satConn = _nw0;
  //   SatelliteDataCache _nw1 = new SatelliteDataCache();
  //   _nw1.__ctor();
  //   (this).currentData = _nw1;
  //   SatelliteDataCache _nw2 = new SatelliteDataCache();
  //   _nw2.__ctor();
  //   (this).previousData = _nw2;
  // }

  public void Init()
  {
    SatelliteDataCache _out0;
    _out0 = (this.satConn).retrieveCurrentData();
    (this).currentData = _out0;
    SatelliteDataCache _out1;
    _out1 = (this.satConn).retrievePreviousData();
    (this).previousData = _out1;
  }

  private double convertToDouble(dafny.BigRational val)
  {
    return Double.parseDouble(val.toString());
  }

  private dafny.BigRational doubleToRational(double val)
  {
    double negligableRatio = 0.0000000001;
    for (int denominator = 1 ;; denominator++)
    {
      double numerator = val / (1D / denominator);
      if (Math.abs(numerator - Math.round(numerator)) < negligableRatio) {
        return new dafny.BigRational((int) Math.round(numerator), denominator);
      }
    }
  }

  public dafny.BigRational getBarometricPressure_k(SatelliteDataCache cache)
  {
    dafny.BigRational bp = dafny.BigRational.ZERO;
    if(true) {
      bp = doubleToRational((cache).getBarometricPressure());
      if (!((bp).compareTo((new dafny.BigRational(new java.math.BigInteger("0"), java.math.BigInteger.ONE))) > 0)) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(52,6): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return bp;
  }
  public dafny.BigRational getHumidityLevel_k(SatelliteDataCache cache)
  {
    dafny.BigRational h = dafny.BigRational.ZERO;
    if(true) {
      h = doubleToRational((cache).getHumidityLevel());
      if (!((h).compareTo((new dafny.BigRational(new java.math.BigInteger("0"), java.math.BigInteger.ONE))) > 0)) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(59,6): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return h;
  }
  public dafny.BigRational getWindSpeed_k(SatelliteDataCache cache)
  {
    dafny.BigRational w = dafny.BigRational.ZERO;
    if(true) {
      w = doubleToRational((cache).getWindSpeed());
      if (!((w).compareTo((new dafny.BigRational(new java.math.BigInteger("0"), java.math.BigInteger.ONE))) > 0)) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(66,6): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
    }
    return w;
  }
  public dafny.BigRational getTemperature_k(SatelliteDataCache cache)
  {
    dafny.BigRational t = dafny.BigRational.ZERO;
    if(true) {
      t = doubleToRational((cache).getTemperature());
      if (!((t).compareTo((new dafny.BigRational(new java.math.BigInteger("0"), java.math.BigInteger.ONE))) > 0)) {
        throw new dafny.DafnyHaltException("/Users/jasonanderson/Documents/School/Winter-2022/Research/test-generation-examples/WeatherStation/dafny/SatelliteUplink.dfy(73,6): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
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

  public boolean runStormCheckForArea(double localHumidity, double localAirPressure, double localTemperature) {
    // Convert the parameters into Dafny Big Rationals and invoke Dafny method

    return runStormCheckForArea_k(doubleToRational(localHumidity), doubleToRational(localAirPressure), doubleToRational(localTemperature));
  }

  public boolean runStormCheckForArea_k(dafny.BigRational localHumidity, dafny.BigRational localAirPressure, dafny.BigRational localTemperature)
  {
    boolean warningSuggested = false;
    if(true) {
      dafny.BigRational _97_currHumidityLevel;
      dafny.BigRational _out4;
      _out4 = (this).getHumidityLevel_k(this.currentData);
      _97_currHumidityLevel = _out4;
      dafny.BigRational _98_currAirPressure;
      dafny.BigRational _out5;
      _out5 = (this).getBarometricPressure_k(this.currentData);
      _98_currAirPressure = _out5;
      dafny.BigRational _99_currTemperature;
      dafny.BigRational _out6;
      _out6 = (this).getTemperature_k(this.currentData);
      _99_currTemperature = _out6;
      dafny.BigRational _100_avgHumidityLevel;
      _100_avgHumidityLevel = (this).average(localHumidity, _97_currHumidityLevel);
      dafny.BigRational _101_avgAirPressure;
      _101_avgAirPressure = (this).average(localAirPressure, _98_currAirPressure);
      dafny.BigRational _102_avgTemperature;
      _102_avgTemperature = (this).average(localTemperature, _99_currTemperature);
      if ((((_100_avgHumidityLevel).compareTo((new dafny.BigRational(new java.math.BigInteger("30"), java.math.BigInteger.ONE))) > 0) && ((_102_avgTemperature).compareTo((new dafny.BigRational(new java.math.BigInteger("70"), java.math.BigInteger.ONE))) > 0)) || (((_100_avgHumidityLevel).compareTo((new dafny.BigRational(new java.math.BigInteger("30"), java.math.BigInteger.ONE))) > 0) && ((_101_avgAirPressure).compareTo((new dafny.BigRational(new java.math.BigInteger("900"), java.math.BigInteger.ONE))) < 0))) {
        warningSuggested = true;
      } else {
        boolean _out7;
        _out7 = (this).checkNearbyAreaStorms();
        warningSuggested = _out7;
      }
    }
    return warningSuggested;
  }

  public boolean runTornadoCheckForArea(double localHumidity, double localAirPressure, double localWindSpeed) {
    // Convert the parameters into Dafny Big Rationals and invoke Dafny method

    return runTornadoCheckForArea_k(doubleToRational(localHumidity), doubleToRational(localAirPressure), doubleToRational(localWindSpeed));
  }

  public boolean runTornadoCheckForArea_k(dafny.BigRational localHumidity, dafny.BigRational localAirPressure, dafny.BigRational localWindSpeed)
  {
    boolean warningSuggested = false;
    if(true) {
      dafny.BigRational _103_currAirPressure;
      dafny.BigRational _out8;
      _out8 = (this).getBarometricPressure_k(this.currentData);
      _103_currAirPressure = _out8;
      dafny.BigRational _104_prevAirPressure;
      dafny.BigRational _out9;
      _out9 = (this).getBarometricPressure_k(this.previousData);
      _104_prevAirPressure = _out9;
      dafny.BigRational _105_airPressureAvg;
      _105_airPressureAvg = (this).average(localAirPressure, _103_currAirPressure);
      dafny.BigRational _106_airPressureDiff;
      _106_airPressureDiff = (this).abs((_105_airPressureAvg).subtract((_104_prevAirPressure)));
      dafny.BigRational _107_currHumidityLevel;
      dafny.BigRational _out10;
      _out10 = (this).getHumidityLevel_k(this.currentData);
      _107_currHumidityLevel = _out10;
      dafny.BigRational _108_prevHumidityLevel;
      dafny.BigRational _out11;
      _out11 = (this).getHumidityLevel_k(this.previousData);
      _108_prevHumidityLevel = _out11;
      dafny.BigRational _109_humidityAvg;
      _109_humidityAvg = (this).average(localHumidity, _107_currHumidityLevel);
      dafny.BigRational _110_humidityDiff;
      _110_humidityDiff = (this).abs((_109_humidityAvg).subtract((_108_prevHumidityLevel)));
      dafny.BigRational _111_currWindSpeed;
      dafny.BigRational _out12;
      _out12 = (this).getWindSpeed_k(this.currentData);
      _111_currWindSpeed = _out12;
      dafny.BigRational _112_windSpeedAvg;
      _112_windSpeedAvg = (this).average(localWindSpeed, _111_currWindSpeed);
      if (((_106_airPressureDiff).compareTo((new dafny.BigRational(new java.math.BigInteger("150"), java.math.BigInteger.ONE))) > 0) || (((_110_humidityDiff).compareTo((new dafny.BigRational(new java.math.BigInteger("5"), java.math.BigInteger.ONE))) > 0) && ((_112_windSpeedAvg).compareTo((new dafny.BigRational(new java.math.BigInteger("15"), java.math.BigInteger.ONE))) > 0))) {
        warningSuggested = true;
      } else {
        boolean _out13;
        _out13 = (this).checkNearbyAreaTornadoes();
        warningSuggested = _out13;
      }
    }
    return warningSuggested;
  }
  private static final dafny.TypeDescriptor<SatelliteUplink> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SatelliteUplink.class, () -> (SatelliteUplink) null);
  public static dafny.TypeDescriptor<SatelliteUplink> _typeDescriptor() {
    return (dafny.TypeDescriptor<SatelliteUplink>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
