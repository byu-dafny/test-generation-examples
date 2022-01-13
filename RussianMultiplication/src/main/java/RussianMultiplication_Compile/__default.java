// Class __default
// Dafny class __default compiled into Java
package RussianMultiplication_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static java.math.BigInteger mult(java.math.BigInteger n0, java.math.BigInteger m0)
  {
    java.math.BigInteger res = java.math.BigInteger.ZERO;
    if(true) {
      java.math.BigInteger _36_n = java.math.BigInteger.ZERO;
      java.math.BigInteger _37_m = java.math.BigInteger.ZERO;
      res = java.math.BigInteger.ZERO;
      if ((n0).signum() != -1) {
        java.math.BigInteger _rhs0 = n0;
        java.math.BigInteger _rhs1 = m0;
        _36_n = _rhs0;
        _37_m = _rhs1;
      } else {
        java.math.BigInteger _rhs2 = (java.math.BigInteger.ZERO).subtract((n0));
        java.math.BigInteger _rhs3 = (java.math.BigInteger.ZERO).subtract((m0));
        _36_n = _rhs2;
        _37_m = _rhs3;
      }
      while ((_36_n).signum() == 1) {
        res = (res).add((_37_m));
        _36_n = (_36_n).subtract((java.math.BigInteger.ONE));
      }
    }
    return res;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
