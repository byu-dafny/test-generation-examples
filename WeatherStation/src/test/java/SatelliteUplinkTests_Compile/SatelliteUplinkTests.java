// Class SatelliteUplinkTests
// Dafny class SatelliteUplinkTests compiled into Java
package SatelliteUplinkTests_Compile;

import org.junit.jupiter.api.Assertions;

import Extern_Compile.Int;
import instruments.satellite.SatelliteDataCache;
import instruments.satellite.SatelliteUplink;

@SuppressWarnings({"unchecked", "deprecation"})
public class SatelliteUplinkTests {
  public SatelliteUplinkTests() {
  }
  public SatelliteDataCache getCurrentDataMock() {
    SatelliteDataCache cacheTmp = org.mockito.Mockito.mock(SatelliteDataCache.class);
    org.mockito.Mockito.when(cacheTmp.getBarometricPressure()).thenReturn(800);
    org.mockito.Mockito.when(cacheTmp.getHumidityLevel()).thenReturn(30);
    org.mockito.Mockito.when(cacheTmp.getWindSpeed()).thenReturn(15);
    org.mockito.Mockito.when(cacheTmp.getTemperature()).thenReturn(75);
    return cacheTmp;
  }
  public SatelliteDataCache getPreviousDataMock() {
    SatelliteDataCache cacheTmp = org.mockito.Mockito.mock(SatelliteDataCache.class);
    org.mockito.Mockito.when(cacheTmp.getBarometricPressure()).thenReturn(1000);
    org.mockito.Mockito.when(cacheTmp.getHumidityLevel()).thenReturn(30);
    org.mockito.Mockito.when(cacheTmp.getWindSpeed()).thenReturn(15);
    org.mockito.Mockito.when(cacheTmp.getTemperature()).thenReturn(75);
    return cacheTmp;
  }
  public SatelliteUplink getNewInstance()
  {
    SatelliteUplink uplink = null;
    if(true) {
      SatelliteUplink _nw1 = new SatelliteUplink();
      _nw1.init();
      uplink = _nw1;
      SatelliteDataCache _173_currentData;
      SatelliteDataCache _out14;
      _out14 = (this).getCurrentDataMock();
      _173_currentData = _out14;
      SatelliteDataCache _174_previousData;
      SatelliteDataCache _out15;
      _out15 = (this).getPreviousDataMock();
      _174_previousData = _out15;
      (uplink).setCurrentData(_173_currentData);
      (uplink).setPreviousData(_174_previousData);
    }
    return uplink;
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> Parameterized__ShouldReturnStormWarning__Provider()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> testInputs = dafny.DafnySequence.<dafny.Tuple3<Integer, Integer, Integer>> empty(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()));
    if(true) {
      testInputs = dafny.DafnySequence.of(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()), dafny.Tuple3.<Integer, Integer, Integer>create(40, 800, 75), dafny.Tuple3.<Integer, Integer, Integer>create(35, 900, 60));
    }
    return testInputs;
  }
  public static java.util.Collection<Object[]> Parameterized_ShouldReturnStormWarning_ProviderConverter(dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _Parameterized_ShouldReturnStormWarning_Provider() {
  dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> retValue =  Parameterized__ShouldReturnStormWarning__Provider();
  return Parameterized_ShouldReturnStormWarning_ProviderConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_Parameterized_ShouldReturnStormWarning_Provider")
  public void test__ShouldReturnStormWarning(int humidity, int airPressure, int temperature)
  {
    SatelliteUplink _175_uplink;
    SatelliteUplink _out16;
    _out16 = (this).getNewInstance();
    _175_uplink = _out16;
    boolean _176_stormWarning;
    boolean _out17;
    _out17 = (_175_uplink).runStormCheckForArea(humidity, airPressure, temperature);
    _176_stormWarning = _out17;
    Assertions.assertTrue(_176_stormWarning);
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> Parameterized__ShouldReturn__No__StormWarning__Provider()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> testInputs = dafny.DafnySequence.<dafny.Tuple3<Integer, Integer, Integer>> empty(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()));
    if(true) {
      testInputs = dafny.DafnySequence.of(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()), dafny.Tuple3.<Integer, Integer, Integer>create(35, 1090, 60), dafny.Tuple3.<Integer, Integer, Integer>create(38, 1050, 30), dafny.Tuple3.<Integer, Integer, Integer>create(20, 1050, 30));
    }
    return testInputs;
  }
  public static java.util.Collection<Object[]> Parameterized_ShouldReturn_No_StormWarning_ProviderConverter(dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _Parameterized_ShouldReturn_No_StormWarning_Provider() {
  dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> retValue =  Parameterized__ShouldReturn__No__StormWarning__Provider();
  return Parameterized_ShouldReturn_No_StormWarning_ProviderConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_Parameterized_ShouldReturn_No_StormWarning_Provider")
  public void test__shouldReturn__No__StormWarning(int humidity, int airPressure, int temperature)
  {
    SatelliteUplink _177_uplink;
    SatelliteUplink _out18;
    _out18 = (this).getNewInstance();
    _177_uplink = _out18;
    boolean _178_stormWarning;
    boolean _out19;
    _out19 = (_177_uplink).runStormCheckForArea(humidity, airPressure, temperature);
    _178_stormWarning = _out19;
    Assertions.assertFalse(_178_stormWarning);
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> Parameterized__ShouldReturnTornadoWarning__Provider()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> testInputs = dafny.DafnySequence.<dafny.Tuple3<Integer, Integer, Integer>> empty(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()));
    if(true) {
      testInputs = dafny.DafnySequence.of(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()), dafny.Tuple3.<Integer, Integer, Integer>create(45, 967, 17), dafny.Tuple3.<Integer, Integer, Integer>create(32, 800, 14));
    }
    return testInputs;
  }
  public static java.util.Collection<Object[]> Parameterized_ShouldReturnTornadoWarning_ProviderConverter(dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _Parameterized_ShouldReturnTornadoWarning_Provider() {
  dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> retValue =  Parameterized__ShouldReturnTornadoWarning__Provider();
  return Parameterized_ShouldReturnTornadoWarning_ProviderConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_Parameterized_ShouldReturnTornadoWarning_Provider")
  public void test__shouldReturnTornadoWarning(int humidity, int airPressure, int windSpeed)
  {
    SatelliteUplink _179_uplink;
    SatelliteUplink _out20;
    _out20 = (this).getNewInstance();
    _179_uplink = _out20;
    boolean _180_tornadoWarning;
    boolean _out21;
    _out21 = (_179_uplink).runTornadoCheckForArea(humidity, airPressure, windSpeed);
    _180_tornadoWarning = _out21;
    Assertions.assertTrue(_180_tornadoWarning);
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> Parameterized__ShouldReturn__No__TornadoWarning__Provider()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> testInputs = dafny.DafnySequence.<dafny.Tuple3<Integer, Integer, Integer>> empty(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()));
    if(true) {
      testInputs = dafny.DafnySequence.of(dafny.Tuple3.<Integer, Integer, Integer>_typeDescriptor(Int._typeDescriptor(), Int._typeDescriptor(), Int._typeDescriptor()), dafny.Tuple3.<Integer, Integer, Integer>create(29, 950, 17), dafny.Tuple3.<Integer, Integer, Integer>create(31, 900, 14), dafny.Tuple3.<Integer, Integer, Integer>create(45, 900, 14));
    }
    return testInputs;
  }
  public static java.util.Collection<Object[]> Parameterized_ShouldReturn_No_TornadoWarning_ProviderConverter(dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _Parameterized_ShouldReturn_No_TornadoWarning_Provider() {
  dafny.DafnySequence<? extends dafny.Tuple3<Integer, Integer, Integer>> retValue =  Parameterized__ShouldReturn__No__TornadoWarning__Provider();
  return Parameterized_ShouldReturn_No_TornadoWarning_ProviderConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_Parameterized_ShouldReturn_No_TornadoWarning_Provider")
  public void test__shouldReturn__No__TornadoWarning(int humidity, int airPressure, int windSpeed)
  {
    SatelliteUplink _181_uplink;
    SatelliteUplink _out22;
    _out22 = (this).getNewInstance();
    _181_uplink = _out22;
    boolean _182_tornadoWarning;
    boolean _out23;
    _out23 = (_181_uplink).runTornadoCheckForArea(humidity, airPressure, windSpeed);
    _182_tornadoWarning = _out23;
    Assertions.assertFalse(_182_tornadoWarning);
  }
  public int MIN__HUMIDITY()
  {
    return 0;
  }
  public int MAX__HUMIDITY()
  {
    return 100;
  }
  public int MIN__AIR__PRESSURE()
  {
    return 800;
  }
  public int MAX__AIR__PRESSURE()
  {
    return 1100;
  }
  public int MIN__TEMPERATURE()
  {
    return -175;
  }
  public int MAX__TEMPERATURE()
  {
    return 175;
  }
  public int MIN__WINDSPEED()
  {
    return 0;
  }
  public int MAX__WINDSPEED()
  {
    return 200;
  }
  private static final dafny.TypeDescriptor<SatelliteUplinkTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SatelliteUplinkTests.class, () -> (SatelliteUplinkTests) null);
  public static dafny.TypeDescriptor<SatelliteUplinkTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<SatelliteUplinkTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
