// Class JUnit5
// Dafny class JUnit5 compiled into Java
package Utils_Compile;

public class Assertions {
  static public void assertEquals(boolean expected, boolean actual) {
    org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
  }

  static public void assertTrue(boolean condition) {
    org.junit.jupiter.api.Assertions.assertTrue(condition);
  }

  static public void assertFalse(boolean condition) {
    org.junit.jupiter.api.Assertions.assertFalse(condition);
  }
}
