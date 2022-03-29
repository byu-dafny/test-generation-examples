package Utils_Compile; // rename as needed

import dafny.TypeDescriptor;

public class Assertions {

  static public <T> void assertEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    org.junit.jupiter.api.Assertions.assertEquals(left, right);
  }

  static public <T> void expectEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    org.junit.jupiter.api.Assertions.assertEquals(left, right);
  }

  static public <T> void assertNotEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    org.junit.jupiter.api.Assertions.assertNotEquals(left, right);
  }

  static public <T> void expectNotEquals(dafny.TypeDescriptor<T> typeDescriptor, T left, T right) {
    org.junit.jupiter.api.Assertions.assertNotEquals(left, right);
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
}
