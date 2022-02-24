// Class Assertions
// Dafny class Assertions compiled into Java
package Utils_Compile;

import Param_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Assertions {
  public Assertions() {
  }
  static public <T> void assertEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    org.junit.jupiter.api.Assertions.assertEquals(left, right);
}
  private static final dafny.TypeDescriptor<Assertions> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Assertions.class, () -> (Assertions) null);
  public static dafny.TypeDescriptor<Assertions> _typeDescriptor() {
    return (dafny.TypeDescriptor<Assertions>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
