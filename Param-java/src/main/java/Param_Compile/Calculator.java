// Class Calculator
// Dafny class Calculator compiled into Java
package Param_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class Calculator {
  public Calculator() {
  }
  public static java.math.BigInteger mult(java.math.BigInteger a, java.math.BigInteger b)
  {
    java.math.BigInteger res = java.math.BigInteger.ZERO;
    res = (a).multiply((b));
    return res;
  }
  public static dafny.DafnySequence<? extends Character> add(dafny.DafnySequence<? extends Character> a, dafny.DafnySequence<? extends Character> b)
  {
    dafny.DafnySequence<? extends Character> res = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    res = dafny.DafnySequence.<Character>concatenate(a, b);
    return res;
  }
  public static boolean arrayEqual(java.math.BigInteger[] a, java.math.BigInteger[] b)
  {
    boolean res = false;
    if(true) {
      if ((a) == (Object)  (b)) {
        res = true;
        return res;
      } else {
        res = false;
        return res;
      }
    }
    return res;
  }
  public static boolean seqPrefix(dafny.DafnySequence<? extends Character> a, dafny.DafnySequence<? extends Character> b)
  {
    boolean res = false;
    if(true) {
      if ((a).isProperPrefixOf((b))) {
        res = true;
        return res;
      } else {
        res = false;
        return res;
      }
    }
    return res;
  }
  private static final dafny.TypeDescriptor<Calculator> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Calculator.class, () -> (Calculator) null);
  public static dafny.TypeDescriptor<Calculator> _typeDescriptor() {
    return (dafny.TypeDescriptor<Calculator>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
