include "Tokeneer.dfy"

module Utils {
  import opened Tokeneer

  class JUnit5 {
    static method {:axiom} assertEquals(left : bool, right : bool)
    ensures true
  }

  class IdStationUtils {
    static method {:axiom} fresh_IdStation() returns (idStation : IdStation)
    ensures fresh(idStation)

    static method {:axiom} mock_Token_OpenVersion0_NotIsValid() returns (token : Token) 
    ensures fresh(token)
    //ensures forall fingerprint : int :: token.isValid(fingerprint) == true;
    ensures forall fingerprint : int :: token.isMatch(fingerprint) == true;
    ensures token.getClearanceLevel() == Confidential
  }
}