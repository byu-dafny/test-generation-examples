include "Tokeneer.dfy"
include "Utils.dfy"

module TokeneerTests {

  import opened Tokeneer
  import opened Utils

  class IdStationTests {

    method test_OpenVersion0_NotIsValid() {
      // Initialize Object State
      var idStation : IdStation := IdStationUtils.fresh_IdStation();
      idStation.access := false;
      idStation.alarm := false;
      idStation.requiredClearanceLevel := Secret;

      // Create mocks for input
      var token : Token := IdStationUtils.mock_Token_OpenVersion0_NotIsValid();
      var fingerprint : int;
    
      // Capture old state
      var old_t_isMatch := token.isMatch(fingerprint);

      // Invoke method under test
      var isOpen := idStation.openVersion0(token, fingerprint);
   
      // Check ensures
      var hasSecurityClearance : bool := idStation.hasSecurityClearance(token);
      
      assert(idStation.access == (old_t_isMatch && hasSecurityClearance));
      JUnit5.assertEquals(idStation.access, old_t_isMatch && hasSecurityClearance);
      
      assert(isOpen == idStation.access);
      JUnit5.assertEquals(isOpen, idStation.access);

      assert(!isOpen);
      JUnit5.assertFalse(isOpen);
    }

    method test_OpenVersion0_IsValid_NotHasClearance() {
      // Initialize Object State
      var idStation : IdStation := IdStationUtils.fresh_IdStation();
      idStation.access := false;
      idStation.alarm := false;
      idStation.requiredClearanceLevel := Secret;

      // Create mocks for input
      var token : Token := IdStationUtils.mock_Token_OpenVersion0_IsValid_NotHasClearance();
      var fingerprint : int;
    
      // Capture old state
      var old_t_isMatch := token.isMatch(fingerprint);

      // Invoke method under test
      var isOpen := idStation.openVersion0(token, fingerprint);

      // Check ensures
      var hasSecurityClearance : bool := idStation.hasSecurityClearance(token);
      
      assert(idStation.access == (old_t_isMatch && hasSecurityClearance));
      JUnit5.assertEquals(idStation.access, old_t_isMatch && hasSecurityClearance);
      
      assert(isOpen == idStation.access);
      JUnit5.assertEquals(isOpen, idStation.access);

      assert(!isOpen);
      JUnit5.assertFalse(isOpen);
    }

    method test_OpenVersion0_IsValid_HasClearance() {
      // Initialize Object State
      var idStation : IdStation := IdStationUtils.fresh_IdStation();
      idStation.access := false;
      idStation.alarm := false;
      idStation.requiredClearanceLevel := Secret;

      // Create mocks for input
      var token : Token := IdStationUtils.mock_Token_OpenVersion0_IsValid_HasClearance();
      var fingerprint : int;
    
      // Capture old state
      var old_t_isMatch := token.isMatch(fingerprint);

      // Invoke method under test
      var isOpen := idStation.openVersion0(token, fingerprint);

      // Check ensures
      var hasSecurityClearance : bool := idStation.hasSecurityClearance(token);
      
      assert(idStation.access == (old_t_isMatch && hasSecurityClearance));
      JUnit5.assertEquals(idStation.access, old_t_isMatch && hasSecurityClearance);
      
      assert(isOpen == idStation.access);
      JUnit5.assertEquals(isOpen, idStation.access);

      assert(isOpen);
      JUnit5.assertTrue(isOpen);
    }
  }
}