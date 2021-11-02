// Class Token
// Dafny class Token compiled into Java
package Tokeneer_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class Token {
  public Token() {
    this.fingerprint = java.math.BigInteger.ZERO;
    this.clearanceLevel = ClearanceLevel.Default();
    this.valid = false;
  }
  public java.math.BigInteger fingerprint;
  public ClearanceLevel clearanceLevel;
  public boolean valid;
  public void token(java.math.BigInteger fingerprint, ClearanceLevel clearanceLevel)
  {
    (this).fingerprint = fingerprint;
    (this).clearanceLevel = clearanceLevel;
    (this).valid = true;
  }
  public boolean isMatch(java.math.BigInteger fingerprint) {
    return (this.valid) && (java.util.Objects.equals(fingerprint, this.fingerprint));
  }
  public ClearanceLevel getClearanceLevel() {
    return this.clearanceLevel;
  }
  public boolean isValid(java.math.BigInteger fingerprint)
  {
    boolean valid = false;
    (this).valid = (this.valid) && ((this).isMatch(fingerprint));
    valid = this.valid;
    return valid;
  }
  private static final dafny.TypeDescriptor<Token> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Token.class, () -> (Token) null);
  public static dafny.TypeDescriptor<Token> _typeDescriptor() {
    return (dafny.TypeDescriptor<Token>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
