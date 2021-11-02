// Class IdStation
// Dafny class IdStation compiled into Java
package Tokeneer_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class IdStation {
  public IdStation() {
    this.alarm = false;
    this.access = false;
    this.requiredClearanceLevel = ClearanceLevel.Default();
  }
  public boolean alarm;
  public boolean access;
  public ClearanceLevel requiredClearanceLevel;
  public void idStation(ClearanceLevel requiredClearanceLevel)
  {
    (this).alarm = false;
    (this).access = false;
    (this).requiredClearanceLevel = requiredClearanceLevel;
  }
  public boolean hasSecurityClearance(Token t) {
    return (((((t).getClearanceLevel()).is_Confidential()) && ((this.requiredClearanceLevel).is_Confidential())) || ((((t).getClearanceLevel()).is_Secret()) && (((this.requiredClearanceLevel).is_Confidential()) || ((this.requiredClearanceLevel).is_Secret())))) || ((((t).getClearanceLevel()).is_TopSecret()) && ((((this.requiredClearanceLevel).is_Confidential()) || ((this.requiredClearanceLevel).is_Secret())) || ((this.requiredClearanceLevel).is_TopSecret())));
  }
  public boolean openVersion0(Token t, java.math.BigInteger fingerprint)
  {
    boolean access = false;
    boolean _59_isValid;
    boolean _out0;
    _out0 = (t).isValid(fingerprint);
    _59_isValid = _out0;
    boolean _60_hasSecurityClearance;
    _60_hasSecurityClearance = (this).hasSecurityClearance(t);
    (this).access = (_59_isValid) && (_60_hasSecurityClearance);
    access = this.access;
    return access;
  }
  public boolean openVersion1(Token t, java.math.BigInteger fingerprint)
  {
    boolean access = false;
    boolean _61_isValid;
    boolean _out1;
    _out1 = (t).isValid(fingerprint);
    _61_isValid = _out1;
    if (_61_isValid) {
      if ((this).hasSecurityClearance(t)) {
        boolean _out2;
        _out2 = (t).isValid(fingerprint);
        (this).access = _out2;
      }
    }
    access = this.access;
    return access;
  }
  private static final dafny.TypeDescriptor<IdStation> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(IdStation.class, () -> (IdStation) null);
  public static dafny.TypeDescriptor<IdStation> _typeDescriptor() {
    return (dafny.TypeDescriptor<IdStation>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}