// Class Assertions
// Dafny class Assertions compiled into Java
package Utils_Compile;

import Hashtable_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Assertions<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public Assertions(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
  }

  static public <T> void assertEquals(dafny.TypeDescriptor<T> typeDescriptor, T expected, T actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public <T> void expectEquals(dafny.TypeDescriptor<T> typeDescriptor, T expected, T actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public void assertTrue(dafny.TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertTrue(condition);
  }

  static public void expectTrue(dafny.TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertTrue(condition);
  }

  static public void assertFalse(dafny.TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertFalse(condition);
  }

  static public void expectFalse(dafny.TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertFalse(condition);
  }

  public static <T> dafny.TypeDescriptor<Assertions<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<Assertions<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(Assertions.class, () -> (Assertions<T>) null);
  }
}
