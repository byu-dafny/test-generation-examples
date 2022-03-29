package Utils_Compile;

import java.math.BigInteger;
import dafny.TypeDescriptor;
public class Assertions {
  static public void assertEquals(TypeDescriptor<BigInteger> T, BigInteger expected, BigInteger actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public void expectEquals(TypeDescriptor<BigInteger> T, BigInteger expected, BigInteger actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public void assertEquals(TypeDescriptor<Boolean> T, Boolean expected, Boolean actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public void expectEquals(TypeDescriptor<Boolean> T, Boolean expected, Boolean actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public void assertTrue(TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertTrue(condition);
  }

  static public void expectTrue(TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertTrue(condition);
  }

  static public void assertFalse(TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertFalse(condition);
  }

  static public void expectFalse(TypeDescriptor<Boolean> T, Boolean condition) {
    org.junit.jupiter.api.Assertions.assertFalse(condition);
  }
}