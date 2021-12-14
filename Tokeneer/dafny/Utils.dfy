include "Tokeneer.dfy"

module Utils {
  import opened Tokeneer

  class JUnit5 {
    static method {:extern} assertEquals(left : bool, right : bool)
    ensures true

    static method {:extern} assertTrue(value : bool)
    ensures true

    static method {:extern} assertFalse(value : bool)
    ensures true
  }

  class IdStationUtils {
    static method {:fresh} fresh_IdStation() returns (idStation : IdStation)
    ensures fresh(idStation)

    static method {:mock} mock_Token_OpenVersion0_NotIsValid() returns (token : Token) 
    ensures fresh(token)
    ensures forall fingerprint : int :: token.f_isValid(fingerprint) == false;

    static method {:mock} mock_Token_OpenVersion0_IsValid_NotHasClearance() returns (token : Token) 
    ensures fresh(token)
    ensures forall fingerprint : int :: token.f_isValid(fingerprint) == true;
    ensures token.getClearanceLevel() == Confidential

    static method {:mock} mock_Token_OpenVersion0_IsValid_HasClearance() returns (token : Token) 
    ensures fresh(token)
    ensures forall fingerprint : int :: token.f_isValid(fingerprint) == true;
    ensures token.getClearanceLevel() == TopSecret
  }
}