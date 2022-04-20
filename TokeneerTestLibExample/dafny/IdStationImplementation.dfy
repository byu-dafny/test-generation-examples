include "ExternSecurityClearance.dfy"
include "ExternFingerprint.dfy"
include "ExternToken.dfy"

module IdStationImplementation {
  import opened ExternSecurityClearance
  import opened ExternFingerprint
  import opened ExternToken

  class IdStation {
    var alarm : bool; 
    var level : SecurityClearance;

    constructor IdStation(requiredLevel : SecurityClearance)
    ensures this.alarm == false
    ensures this.level == requiredLevel
    {
      this.alarm := false;
      this.level := requiredLevel;
    }

    method hasAccess(t : Token, fingerprint : Fingerprint) 
    returns (hasAccess :  bool)
      requires !this.alarm
      modifies this`alarm
      ensures alarm == !t.doesCertify(fingerprint)
      ensures hasAccess == (!alarm && level.isCleared(t.getLevel()))
    {
      expect !this.alarm;

      var doesCertify : bool := t.doesCertify(fingerprint);
      if (doesCertify) {
        var tokenLevel : SecurityClearance := t.getLevel();
        hasAccess := level.isCleared(tokenLevel);
      } else {
        alarm := true;
        hasAccess := false;
      }
    }
  }
}