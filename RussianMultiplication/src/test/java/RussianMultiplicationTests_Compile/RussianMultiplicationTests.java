// Class RussianMultiplicationTests
// Dafny class RussianMultiplicationTests compiled into Java
package RussianMultiplicationTests_Compile;

import org.junit.jupiter.api.Test;

import RussianMultiplication_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class RussianMultiplicationTests {
  public RussianMultiplicationTests() {
  }

@Test
  public void test__mult__should__keepSigns__when__n0IsPositive()
  {
    java.math.BigInteger _38_n0 = java.math.BigInteger.ZERO;
    _38_n0 = java.math.BigInteger.valueOf(5L);
    java.math.BigInteger _39_m0 = java.math.BigInteger.ZERO;
    _39_m0 = java.math.BigInteger.valueOf(3L);
    java.math.BigInteger _40_res = java.math.BigInteger.ZERO;
    java.math.BigInteger _out0 = java.math.BigInteger.ZERO;
    _out0 = RussianMultiplication_Compile.__default.mult(_38_n0, _39_m0);
    _40_res = _out0;
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _40_res, (_38_n0).multiply((_39_m0)));
  }

@Test
  public void test__mult__should__switchSigns__when__n0IsNegative()
  {
    java.math.BigInteger _41_n0 = java.math.BigInteger.ZERO;
    _41_n0 = java.math.BigInteger.valueOf(-5L);
    java.math.BigInteger _42_m0 = java.math.BigInteger.ZERO;
    _42_m0 = java.math.BigInteger.valueOf(3L);
    java.math.BigInteger _43_res = java.math.BigInteger.ZERO;
    java.math.BigInteger _out1 = java.math.BigInteger.ZERO;
    _out1 = RussianMultiplication_Compile.__default.mult(_41_n0, _42_m0);
    _43_res = _out1;
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _43_res, (_41_n0).multiply((_42_m0)));
  }
  private static final dafny.TypeDescriptor<RussianMultiplicationTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(RussianMultiplicationTests.class, () -> (RussianMultiplicationTests) null);
  public static dafny.TypeDescriptor<RussianMultiplicationTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<RussianMultiplicationTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
