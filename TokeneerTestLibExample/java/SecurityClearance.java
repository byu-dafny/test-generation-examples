package ExternSecurityClearance_Compile;

public class SecurityClearance {
  public boolean isCleared(SecurityClearance level) {
    return false;      
  }

  private static final dafny.TypeDescriptor<SecurityClearance> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SecurityClearance.class, () -> (SecurityClearance) null);
  public static dafny.TypeDescriptor<SecurityClearance> _typeDescriptor() {
  return (dafny.TypeDescriptor<SecurityClearance>) (dafny.TypeDescriptor<?>) _TYPE;
}
}