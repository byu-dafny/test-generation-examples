package ExternToken_Compile;

public class Token {
  public ExternSecurityClearance_Compile.SecurityClearance getLevel() {
    return null;
  }

  public boolean doesCertify(ExternFingerprint_Compile.Fingerprint f) {
    return false;
  }

  public boolean certify(ExternFingerprint_Compile.Fingerprint f) {
    return doesCertify(f);
  } 

  private static final dafny.TypeDescriptor<Token> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Token.class, () -> (Token) null);
  public static dafny.TypeDescriptor<Token> _typeDescriptor() {
    return (dafny.TypeDescriptor<Token>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}