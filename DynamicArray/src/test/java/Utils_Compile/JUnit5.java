// Class JUnit5
// Dafny class JUnit5 compiled into Java
package Utils_Compile;

import NativeTypes_Compile.*;
import Extern_Compile.*;
import DynamicArray_Compile.*;
import org.junit.jupiter.api.Assertions;
import java.lang.AssertionError;

@SuppressWarnings({"unchecked", "deprecation"})
public class JUnit5 {
  public JUnit5() {
  }
  private static final dafny.TypeDescriptor<JUnit5> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(JUnit5.class, () -> (JUnit5) null);
  public static dafny.TypeDescriptor<JUnit5> _typeDescriptor() {
    return (dafny.TypeDescriptor<JUnit5>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  
  static public <T> void assertEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    Assertions.assertEquals(left, right);
  }

  static public void assertTrue(boolean value) {
    Assertions.assertTrue(value);
  }

  static public void assertFalse(boolean value) {
    Assertions.assertFalse(value);
  }
  static public <T> void assertThrowsAfterPushBack(dafny.TypeDescriptor<T> typeDescriptor, Vector v) {
    Assertions.assertThrows(AssertionError.class, () -> {
      v.push__back(java.math.BigInteger.valueOf(7L));
    });
  }
}
