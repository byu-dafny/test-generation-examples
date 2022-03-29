module Tokeneer {
  datatype ClearanceLevel = Confidential | Secret | TopSecret

  class Token {
    var fingerprint : int; 
    var clearanceLevel : ClearanceLevel;  
    var valid : bool;

    constructor token(fingerprint : int, clearanceLevel : ClearanceLevel)
    ensures this.fingerprint == fingerprint
    ensures this.clearanceLevel == clearanceLevel
    ensures valid == true
    {
      this.fingerprint := fingerprint;
      this.clearanceLevel := clearanceLevel;
      valid := true;
    }

    function method fIsValid(fingerprint : int) : bool
    reads `valid, `fingerprint 
    { 
      (valid && (fingerprint == this.fingerprint))
    }

    function method getClearanceLevel() : ClearanceLevel
    reads `clearanceLevel 
    { 
      clearanceLevel
    }
  }

  class IdStation {
    var alarm : bool; 
    var access : bool; 
    var requiredClearanceLevel : ClearanceLevel;

    constructor idStation(requiredClearanceLevel : ClearanceLevel)
    ensures this.alarm == false
    ensures this.access == false
    ensures this.requiredClearanceLevel == requiredClearanceLevel
    {
      this.alarm := false;
      this.access := false;
      this.requiredClearanceLevel := requiredClearanceLevel;
    }

    function method hasSecurityClearance(t : Token) : bool
    reads t, `requiredClearanceLevel
    {
         (t.getClearanceLevel().Confidential? && 
           (   requiredClearanceLevel.Confidential? 
           )
         )
      ||
         (t.getClearanceLevel().Secret? && 
           (   requiredClearanceLevel.Confidential? 
            || requiredClearanceLevel.Secret? 
           )
         )
      ||
         (t.getClearanceLevel().TopSecret? && 
           (   requiredClearanceLevel.Confidential? 
            || requiredClearanceLevel.Secret? 
            || requiredClearanceLevel.TopSecret?
           )
         )
    }

    method openVersion0(t : Token, fingerprint : int) returns (access :  bool)
    modifies t`valid, `access;
    requires this.access == false
    ensures this.access == (old(t.fIsValid(fingerprint)) && hasSecurityClearance(t)) 
    ensures access == this.access
    {
      var isValid := t.fIsValid(fingerprint);
      var hasSecurityClearance := hasSecurityClearance(t);
      this.access := isValid && hasSecurityClearance;
      return this.access;
    }

    method openVersion1(t : Token, fingerprint : int) returns (access :  bool)
    modifies t`valid, `access;
    requires this.access == false
    ensures (old(t.fIsValid(fingerprint)) && hasSecurityClearance(t)) == this.access
    ensures access == this.access
    {
      var isValid := t.fIsValid(fingerprint);
      if (isValid) {
        if (hasSecurityClearance(t)) {
          this.access := t.fIsValid(fingerprint);
        }
      }
      return this.access;
    }
  }
}