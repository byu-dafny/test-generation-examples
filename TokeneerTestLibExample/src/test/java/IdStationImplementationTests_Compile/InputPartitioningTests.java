// Class InputPartitioningTests
// Dafny class InputPartitioningTests compiled into Java
package IdStationImplementationTests_Compile;

import IdStationImplementation_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class InputPartitioningTests {
  public InputPartitioningTests() {
  }
  public static IdStationImplementation_Compile.IdStation freshIdStation() {
    return new IdStationImplementation_Compile.IdStation();
  }
  public static ExternToken_Compile.Token freshToken() {
    return new ExternToken_Compile.Token();
  }
  public static ExternFingerprint_Compile.Fingerprint freshFingerprint() {
    return new ExternFingerprint_Compile.Fingerprint();
  }
  public static ExternToken_Compile.Token tokenDoesNotCertify() {
    ExternToken_Compile.Token tokenMock = org.mockito.Mockito.mock(ExternToken_Compile.Token.class);
    org.mockito.Mockito.when(tokenMock.doesCertify(org.mockito.Mockito.any(ExternFingerprint_Compile.Fingerprint.class))).thenReturn(false);
    return tokenMock;
  }
  public static ExternSecurityClearance_Compile.SecurityClearance freshSecurityClearance() {
    ExternSecurityClearance_Compile.SecurityClearance securityClearanceMock = org.mockito.Mockito.mock(ExternSecurityClearance_Compile.SecurityClearance.class);
    return securityClearanceMock;
  }
  @org.junit.jupiter.api.Test
  public void should__alarmAndDenyAccess__when__tokenDoesNotCertifyFingerprint()
  {
    ExternToken_Compile.Token _2_token;
    ExternToken_Compile.Token _out1;
    _out1 = InputPartitioningTests.tokenDoesNotCertify();
    _2_token = _out1;
    ExternFingerprint_Compile.Fingerprint _3_fingerprint;
    ExternFingerprint_Compile.Fingerprint _out2;
    _out2 = InputPartitioningTests.freshFingerprint();
    _3_fingerprint = _out2;
    ExternSecurityClearance_Compile.SecurityClearance _4_securityClearance;
    ExternSecurityClearance_Compile.SecurityClearance _out3;
    _out3 = InputPartitioningTests.freshSecurityClearance();
    _4_securityClearance = _out3;
    IdStationImplementation_Compile.IdStation _5_idStation;
    IdStationImplementation_Compile.IdStation _nw0 = new IdStationImplementation_Compile.IdStation();
    _nw0.__IdStation(_4_securityClearance);
    _5_idStation = _nw0;
    boolean _6_hasAccess;
    boolean _out4;
    _out4 = (_5_idStation).hasAccess(_2_token, _3_fingerprint);
    _6_hasAccess = _out4;
    Utils_Compile.Assertions.<Boolean>assertTrue(dafny.TypeDescriptor.BOOLEAN, _5_idStation.alarm);
    Utils_Compile.Assertions.<Boolean>assertFalse(dafny.TypeDescriptor.BOOLEAN, _6_hasAccess);
  }
  public static ExternToken_Compile.Token tokenDoesCertify() {
    ExternToken_Compile.Token tokenMock = org.mockito.Mockito.mock(ExternToken_Compile.Token.class);
    org.mockito.Mockito.when(tokenMock.doesCertify(org.mockito.Mockito.any(ExternFingerprint_Compile.Fingerprint.class))).thenReturn(true);
    return tokenMock;
  }
  public static ExternSecurityClearance_Compile.SecurityClearance securityClearanceIsCleared() {
    ExternSecurityClearance_Compile.SecurityClearance securityClearanceMock = org.mockito.Mockito.mock(ExternSecurityClearance_Compile.SecurityClearance.class);
    org.mockito.Mockito.when(securityClearanceMock.isCleared(org.mockito.Mockito.any(ExternSecurityClearance_Compile.SecurityClearance.class))).thenReturn(true);
    return securityClearanceMock;
  }
  @org.junit.jupiter.api.Test
  public void should__notAlarmAndGrantAccess__when__tokenDoesCertifyFingerprintAndIsCleared()
  {
    ExternToken_Compile.Token _7_token;
    ExternToken_Compile.Token _out5;
    _out5 = InputPartitioningTests.tokenDoesCertify();
    _7_token = _out5;
    ExternFingerprint_Compile.Fingerprint _8_fingerprint;
    ExternFingerprint_Compile.Fingerprint _out6;
    _out6 = InputPartitioningTests.freshFingerprint();
    _8_fingerprint = _out6;
    ExternSecurityClearance_Compile.SecurityClearance _9_securityClearance;
    ExternSecurityClearance_Compile.SecurityClearance _out7;
    _out7 = InputPartitioningTests.securityClearanceIsCleared();
    _9_securityClearance = _out7;
    IdStationImplementation_Compile.IdStation _10_idStation;
    IdStationImplementation_Compile.IdStation _nw1 = new IdStationImplementation_Compile.IdStation();
    _nw1.__IdStation(_9_securityClearance);
    _10_idStation = _nw1;
    boolean _11_hasAccess;
    boolean _out8;
    _out8 = (_10_idStation).hasAccess(_7_token, _8_fingerprint);
    _11_hasAccess = _out8;
    Utils_Compile.Assertions.<Boolean>assertFalse(dafny.TypeDescriptor.BOOLEAN, _10_idStation.alarm);
    Utils_Compile.Assertions.<Boolean>assertTrue(dafny.TypeDescriptor.BOOLEAN, _11_hasAccess);
  }
  private static final dafny.TypeDescriptor<InputPartitioningTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(InputPartitioningTests.class, () -> (InputPartitioningTests) null);
  public static dafny.TypeDescriptor<InputPartitioningTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<InputPartitioningTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
