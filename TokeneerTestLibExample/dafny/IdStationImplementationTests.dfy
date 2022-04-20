
include "ExternSecurityClearance.dfy"
include "ExternFingerprint.dfy"
include "ExternToken.dfy"
include "IdStationImplementation.dfy"
include "Utils.dfy"

module IdStationImplementationTests {
  import opened ExternSecurityClearance
  import opened ExternFingerprint
  import opened ExternToken
  import opened IdStationImplementation

  import opened Utils

  // method hasAccess(t : Token, fingerprint : Fingerprint) 
  //   returns (hasAccess :  bool)
  //   requires !this.alarm
  //   modifies this`alarm
  //   ensures alarm == !t.doesCertify(fingerprint)
  //   ensures hasAccess == (!alarm && level.isCleared(t.getLevel()))
  
  class InputPartitioningTests {
    static method {:synthesize "fresh"}
      freshIdStation() returns (idStation : IdStation)
      ensures fresh(idStation)

    static method {:synthesize "mock"}
    freshToken() returns (token : Token)
      ensures fresh(token)

    static method {:synthesize "mock"}
    freshFingerprint() returns (fingerprint : Fingerprint)
      ensures fresh(fingerprint)

    method {:test "throws"} 
    should_throwException_when_alarmIsAlreadySet()
    {
      var idStation : IdStation := freshIdStation();
      idStation.alarm := true;
      var token : Token := freshToken();
      var fingerprint := freshFingerprint();
      var hasAccess : bool := idStation.hasAccess(token, fingerprint);
    }

    static method {:synthesize "mock"}
    tokenDoesNotCertify() returns (token : Token)
      ensures fresh(token)
      ensures forall fingerprint : Fingerprint :: 
        token.doesCertify(fingerprint) == false

    static method {:synthesize "mock"}
    freshSecurityClearance() returns (securityClearance : SecurityClearance)
      ensures fresh(securityClearance)

    method {:test}
    should_alarmAndDenyAccess_when_tokenDoesNotCertifyFingerprint()
    {
      var token : Token := tokenDoesNotCertify();
      var fingerprint : Fingerprint := freshFingerprint();
      var securityClearance : SecurityClearance := freshSecurityClearance();
      var idStation : IdStation := new IdStation.IdStation(securityClearance);

      var hasAccess : bool := idStation.hasAccess(token, fingerprint);
      Assertions<bool>.assertTrue(idStation.alarm);
      Assertions<bool>.assertFalse(hasAccess);
    }

    static method {:synthesize "mock"}
    tokenDoesCertify(level : SecurityClearance) returns (token : Token)
      ensures fresh(token)
      ensures forall fingerprint : Fingerprint :: 
        token.doesCertify(fingerprint) == true
      ensures token.getLevel() == level

    static method {:synthesize "mock"}
    securityClearanceIsCleared() returns (securityClearance : SecurityClearance)
      ensures fresh(securityClearance)
      ensures forall level : SecurityClearance :: 
        securityClearance.isCleared(level) == true

    method {:test}
    should_notAlarmAndGrantAccess_when_tokenDoesCertifyFingerprintAndIsCleared()
    {
      var fingerprint : Fingerprint := freshFingerprint();
      var securityClearance : SecurityClearance := securityClearanceIsCleared();
      var token : Token := tokenDoesCertify(securityClearance);
      var idStation : IdStation := new IdStation.IdStation(securityClearance);

      var hasAccess : bool := idStation.hasAccess(token, fingerprint);
      Assertions<bool>.assertFalse(idStation.alarm);
      Assertions<bool>.assertTrue(hasAccess);
    }
  }

  class McDcCoverage {
    static method {:synthesize "mock"}
    securityClearanceIsNotCleared() returns (securityClearance : SecurityClearance)
      ensures fresh(securityClearance)
      ensures forall level : SecurityClearance :: 
        securityClearance.isCleared(level) == false

    // Input: IdStation.level (SecurityClearance), token (Token), fingerprint (Fingerprint)
    // Output: hasAccess (bool), IdStation.alarm (bool) 
    static method McDcTestIo() 
    returns ( testIo : seq<(SecurityClearance, Token, Fingerprint, bool, bool)>)
    {
      // If-statement, doesCertify false
      var securityClearance0 : SecurityClearance := 
        InputPartitioningTests.freshSecurityClearance();
      var token0 : Token := InputPartitioningTests.tokenDoesNotCertify();
      var fingerprint0 : Fingerprint := 
        InputPartitioningTests.freshFingerprint();
      var hasAccess0 : bool := false;
      var alarm0 : bool := true;

      // If-statement, doesCertify true, isCleared false
      var securityClearance1 : SecurityClearance := 
        securityClearanceIsNotCleared();
      var token1 : Token := InputPartitioningTests.tokenDoesCertify(securityClearance1);
      var fingerprint1 : Fingerprint := 
        InputPartitioningTests.freshFingerprint();
      var hasAccess1 : bool := false;
      var alarm1 : bool := false;

      // If-statement, doesCertify true, isCleared true
      var securityClearance2 : SecurityClearance := 
        InputPartitioningTests.securityClearanceIsCleared();
      var token2 : Token := InputPartitioningTests.tokenDoesCertify(securityClearance2);
      var fingerprint2 : Fingerprint := 
        InputPartitioningTests.freshFingerprint();
      var hasAccess2 : bool := true;
      var alarm2 : bool := false;

      return [
        (securityClearance0, token0, fingerprint0, hasAccess0, alarm0),
        (securityClearance1, token1, fingerprint1, hasAccess1, alarm1),
        (securityClearance2, token2, fingerprint2, hasAccess2, alarm2)
      ];
    }

    method {:test "MethodSource", "McDcTestIo"} 
    should_resultInMcDcCoverage_when_givenAllTestInputs(
      securityClearance : SecurityClearance, 
      token : Token, fingerprint : Fingerprint,
      expectedHasAccess : bool, expectedAlarm : bool)
    {
      var idStation : IdStation := new IdStation.IdStation(securityClearance);
      var hasAccess : bool := idStation.hasAccess(token, fingerprint);
      Assertions<bool>.expectEquals(hasAccess, expectedHasAccess);
      Assertions<bool>.expectEquals(idStation.alarm, expectedAlarm);
    }
  }
}