// Class IdStation
// Dafny class IdStation compiled into Java
package IdStationImplementation_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class IdStation {
  public IdStation() {
    this.alarm = false;
    this.level = null;
  }
  public boolean alarm;
  public ExternSecurityClearance_Compile.SecurityClearance level;
  public void __IdStation(ExternSecurityClearance_Compile.SecurityClearance requiredLevel)
  {
    (this).alarm = false;
    (this).level = requiredLevel;
  }
  public boolean hasAccess(ExternToken_Compile.Token t, ExternFingerprint_Compile.Fingerprint fingerprint)
  {
    boolean hasAccess = false;
    if(true) {
      if (!(!(this.alarm))) {
        throw new dafny.DafnyHaltException("/Users/cassidywaldrip/Documents/vvlab/test-generation-examples/TokeneerTestLibExample/dafny/IdStationImplementation.dfy(29,6): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
      boolean _0_doesCertify;
      boolean _out0;
      _out0 = (t).certify(fingerprint);
      _0_doesCertify = _out0;
      if (_0_doesCertify) {
        ExternSecurityClearance_Compile.SecurityClearance _1_tokenLevel;
        _1_tokenLevel = (t).getLevel();
        hasAccess = (this.level).isCleared(_1_tokenLevel);
      } else {
        (this).alarm = true;
        hasAccess = false;
      }
    }
    return hasAccess;
  }
  private static final dafny.TypeDescriptor<IdStation> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(IdStation.class, () -> (IdStation) null);
  public static dafny.TypeDescriptor<IdStation> _typeDescriptor() {
    return (dafny.TypeDescriptor<IdStation>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
