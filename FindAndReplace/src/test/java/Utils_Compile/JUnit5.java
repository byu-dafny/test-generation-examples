// Class JUnit5
// Dafny class JUnit5 compiled into Java
package Utils_Compile;

import FindAndReplace_Compile.*;
import org.junit.jupiter.api.Assertions;

@SuppressWarnings({"unchecked", "deprecation"})
public class JUnit5 {
  public JUnit5() {
  }

  static public <T> void assertEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    Assertions.assertEquals(left, right);
  }

  static public <T> void assertNotEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    Assertions.assertNotEquals(left, right);
  }

  static public void assertTrue(boolean value) {
    Assertions.assertTrue(value);
  }

  static public void assertFalse(boolean value) {
    Assertions.assertFalse(value);
  }

  private static final dafny.TypeDescriptor<JUnit5> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(JUnit5.class, () -> (JUnit5) null);
  public static dafny.TypeDescriptor<JUnit5> _typeDescriptor() {
    return (dafny.TypeDescriptor<JUnit5>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
