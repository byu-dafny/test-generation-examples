include "ExternFingerprint.dfy"
include "ExternSecurityClearance.dfy"

module ExternToken {
  import opened ExternFingerprint
  import opened ExternSecurityClearance

  class {:extern} Token {
    predicate method {:extern} doesCertify(f : Fingerprint)
    function method {:extern} getLevel() : SecurityClearance
  }
}