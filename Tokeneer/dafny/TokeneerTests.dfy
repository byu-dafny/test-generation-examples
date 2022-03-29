include "Tokeneer.dfy"
include "Utils.dfy"

module TokeneerTests {

  import opened Tokeneer
  import opened Utils

  class IdStationTests {

    method {:extern} {:fresh} fresh_IdStation() returns (idStation : IdStation)
      ensures fresh(idStation)

    method {:extern} {:mock} mock_Token_OpenVersion0_NotIsValid() returns (token : Token) 
      ensures fresh(token)
      ensures forall fingerprint : int :: token.fIsValid(fingerprint) == false;
      ensures token.getClearanceLevel() == Confidential

    method {:extern} {:mock} mock_Token_OpenVersion0_IsValid_NotHasClearance() returns (token : Token) 
      ensures fresh(token)
      ensures forall fingerprint : int :: token.fIsValid(fingerprint) == true;
      ensures token.getClearanceLevel() == Confidential

    method {:extern} {:mock} mock_Token_OpenVersion0_IsValid_HasClearance() returns (token : Token) 
      ensures fresh(token)
      ensures forall fingerprint : int :: token.fIsValid(fingerprint) == true;
      ensures token.getClearanceLevel() == TopSecret

    method {:test} test_OpenVersion0_NotIsValid() {
      // Initialize Object State
      var idStation : IdStation := fresh_IdStation();
      idStation.access := false;
      idStation.alarm := false;
      idStation.requiredClearanceLevel := Secret;

      // Create mocks for input
      var token : Token := mock_Token_OpenVersion0_NotIsValid();
      var fingerprint : int;
    
      // Capture old state
      var old_t_isMatch := token.fIsValid(fingerprint);

      // Invoke method under test
      var isOpen := idStation.openVersion0(token, fingerprint);
   
      // Check ensures
      var hasSecurityClearance : bool := idStation.hasSecurityClearance(token);
      
      assert(idStation.access == (old_t_isMatch && hasSecurityClearance));
      Assertions.assertEquals(idStation.access, old_t_isMatch && hasSecurityClearance);
      
      assert(isOpen == idStation.access);
      Assertions.assertEquals(isOpen, idStation.access);

      assert(!isOpen);
      Assertions<bool>.assertFalse(isOpen);
    }

    method {:test} test_OpenVersion0_IsValid_NotHasClearance() {
      // Initialize Object State
      var idStation : IdStation := fresh_IdStation();
      idStation.access := false;
      idStation.alarm := false;
      idStation.requiredClearanceLevel := Secret;

      // Create mocks for input
      var token : Token := mock_Token_OpenVersion0_IsValid_NotHasClearance();
      var fingerprint : int;
    
      // Capture old state
      var old_t_isMatch := token.fIsValid(fingerprint);

      // Invoke method under test
      var isOpen := idStation.openVersion0(token, fingerprint);

      // Check ensures
      var hasSecurityClearance : bool := idStation.hasSecurityClearance(token);
      
      assert(idStation.access == (old_t_isMatch && hasSecurityClearance));
      Assertions.assertEquals(idStation.access, old_t_isMatch && hasSecurityClearance);
      
      assert(isOpen == idStation.access);
      Assertions.assertEquals(isOpen, idStation.access);

      assert(!isOpen);
      Assertions<bool>.assertFalse(isOpen);
      print "isOpen == ", isOpen; 
    }

    method {:test} test_OpenVersion0_IsValid_HasClearance() {
      // Initialize Object State
      var idStation : IdStation := fresh_IdStation();
      idStation.access := false;
      idStation.alarm := false;
      idStation.requiredClearanceLevel := Secret;

      // Create mocks for input
      var token : Token := mock_Token_OpenVersion0_IsValid_HasClearance();
      var fingerprint : int;
    
      // Capture old state
      var old_t_isMatch := token.fIsValid(fingerprint);

      // Invoke method under test
      var isOpen := idStation.openVersion0(token, fingerprint);

      // Check ensures
      var hasSecurityClearance : bool := idStation.hasSecurityClearance(token);
      
      assert(idStation.access == (old_t_isMatch && hasSecurityClearance));
      Assertions.assertEquals(idStation.access, old_t_isMatch && hasSecurityClearance);
      
      assert(isOpen == idStation.access);
      Assertions.assertEquals(isOpen, idStation.access);

      assert(isOpen);
      Assertions<bool>.assertTrue(isOpen);
    }
  }
}