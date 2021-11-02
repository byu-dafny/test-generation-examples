// Class JUnit5
// Dafny class JUnit5 compiled into Java
package Utils_Compile;

import org.junit.jupiter.api.Assertions;

public class JUnit5 {
  static public void assertEquals(boolean left, boolean right) {
    Assertions.assertEquals(left, right);
  }
}
