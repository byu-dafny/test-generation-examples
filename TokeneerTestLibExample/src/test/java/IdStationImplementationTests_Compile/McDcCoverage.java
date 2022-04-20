// Class McDcCoverage
// Dafny class McDcCoverage compiled into Java
package IdStationImplementationTests_Compile;

import IdStationImplementation_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class McDcCoverage {
  public McDcCoverage() {
  }
  public static ExternSecurityClearance_Compile.SecurityClearance securityClearanceIsNotCleared() {
    ExternSecurityClearance_Compile.SecurityClearance securityClearanceMock = org.mockito.Mockito.mock(ExternSecurityClearance_Compile.SecurityClearance.class);
    org.mockito.Mockito.when(securityClearanceMock.isCleared(org.mockito.Mockito.any(ExternSecurityClearance_Compile.SecurityClearance.class))).thenReturn(false);
    return securityClearanceMock;
  }
  public static dafny.DafnySequence<? extends dafny.Tuple5<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>> McDcTestIo()
  {
    dafny.DafnySequence<? extends dafny.Tuple5<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>> testIo = dafny.DafnySequence.<dafny.Tuple5<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>> empty(dafny.Tuple5.<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>_typeDescriptor(ExternSecurityClearance_Compile.SecurityClearance._typeDescriptor(), ExternToken_Compile.Token._typeDescriptor(), ExternFingerprint_Compile.Fingerprint._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN, dafny.TypeDescriptor.BOOLEAN));
    ExternSecurityClearance_Compile.SecurityClearance _12_securityClearance0;
    ExternSecurityClearance_Compile.SecurityClearance _out9;
    _out9 = InputPartitioningTests.freshSecurityClearance();
    _12_securityClearance0 = _out9;
    ExternToken_Compile.Token _13_token0;
    ExternToken_Compile.Token _out10;
    _out10 = InputPartitioningTests.tokenDoesNotCertify();
    _13_token0 = _out10;
    ExternFingerprint_Compile.Fingerprint _14_fingerprint0;
    ExternFingerprint_Compile.Fingerprint _out11;
    _out11 = InputPartitioningTests.freshFingerprint();
    _14_fingerprint0 = _out11;
    boolean _15_hasAccess0;
    _15_hasAccess0 = false;
    boolean _16_alarm0;
    _16_alarm0 = true;
    ExternSecurityClearance_Compile.SecurityClearance _17_securityClearance1;
    ExternSecurityClearance_Compile.SecurityClearance _out12;
    _out12 = McDcCoverage.securityClearanceIsNotCleared();
    _17_securityClearance1 = _out12;
    ExternToken_Compile.Token _18_token1;
    ExternToken_Compile.Token _out13;
    _out13 = InputPartitioningTests.tokenDoesCertify();
    _18_token1 = _out13;
    ExternFingerprint_Compile.Fingerprint _19_fingerprint1;
    ExternFingerprint_Compile.Fingerprint _out14;
    _out14 = InputPartitioningTests.freshFingerprint();
    _19_fingerprint1 = _out14;
    boolean _20_hasAccess1;
    _20_hasAccess1 = false;
    boolean _21_alarm1;
    _21_alarm1 = false;
    ExternSecurityClearance_Compile.SecurityClearance _22_securityClearance2;
    ExternSecurityClearance_Compile.SecurityClearance _out15;
    _out15 = InputPartitioningTests.securityClearanceIsCleared();
    _22_securityClearance2 = _out15;
    ExternToken_Compile.Token _23_token2;
    ExternToken_Compile.Token _out16;
    _out16 = InputPartitioningTests.tokenDoesCertify();
    _23_token2 = _out16;
    ExternFingerprint_Compile.Fingerprint _24_fingerprint2;
    ExternFingerprint_Compile.Fingerprint _out17;
    _out17 = InputPartitioningTests.freshFingerprint();
    _24_fingerprint2 = _out17;
    boolean _25_hasAccess2;
    _25_hasAccess2 = true;
    boolean _26_alarm2;
    _26_alarm2 = false;
    testIo = dafny.DafnySequence.of(dafny.Tuple5.<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>_typeDescriptor(ExternSecurityClearance_Compile.SecurityClearance._typeDescriptor(), ExternToken_Compile.Token._typeDescriptor(), ExternFingerprint_Compile.Fingerprint._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN, dafny.TypeDescriptor.BOOLEAN), dafny.Tuple5.<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>create(_12_securityClearance0, _13_token0, _14_fingerprint0, _15_hasAccess0, _16_alarm0), dafny.Tuple5.<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>create(_17_securityClearance1, _18_token1, _19_fingerprint1, _20_hasAccess1, _21_alarm1), dafny.Tuple5.<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>create(_22_securityClearance2, _23_token2, _24_fingerprint2, _25_hasAccess2, _26_alarm2));
    return testIo;
  }
  public static java.util.Collection<Object[]> McDcTestIoConverter(dafny.DafnySequence<? extends dafny.Tuple5<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>> dafnyStructure) {
    java.util.List<Object[]> newList = new java.util.ArrayList<>();
    for (var tuple : dafnyStructure) {
      newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2(), tuple.dtor__3(), tuple.dtor__4()});
    }
    return newList;
  }
  public static java.util.Collection<Object[]> _McDcTestIo() {
    dafny.DafnySequence<? extends dafny.Tuple5<ExternSecurityClearance_Compile.SecurityClearance, ExternToken_Compile.Token, ExternFingerprint_Compile.Fingerprint, Boolean, Boolean>> retValue =  McDcTestIo();
    return McDcTestIoConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_McDcTestIo")
  public void should__resultInMcDcCoverage__when__givenAllTestInputs(ExternSecurityClearance_Compile.SecurityClearance securityClearance, ExternToken_Compile.Token token, ExternFingerprint_Compile.Fingerprint fingerprint, boolean expectedHasAccess, boolean expectedAlarm)
  {
    IdStationImplementation_Compile.IdStation _27_idStation;
    IdStationImplementation_Compile.IdStation _nw2 = new IdStationImplementation_Compile.IdStation();
    _nw2.__IdStation(securityClearance);
    _27_idStation = _nw2;
    boolean _28_hasAccess;
    boolean _out18;
    _out18 = (_27_idStation).hasAccess(token, fingerprint);
    _28_hasAccess = _out18;
    Utils_Compile.Assertions.<Boolean>expectEquals(dafny.TypeDescriptor.BOOLEAN, _28_hasAccess, expectedHasAccess);
    Utils_Compile.Assertions.<Boolean>expectEquals(dafny.TypeDescriptor.BOOLEAN, _27_idStation.alarm, expectedAlarm);
  }
  private static final dafny.TypeDescriptor<McDcCoverage> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(McDcCoverage.class, () -> (McDcCoverage) null);
  public static dafny.TypeDescriptor<McDcCoverage> _typeDescriptor() {
    return (dafny.TypeDescriptor<McDcCoverage>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
