// Class __default
// Dafny class __default compiled into Java
package FindAndReplace_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends Character> findAndReplace(dafny.DafnySequence<? extends Character> str, dafny.DafnySequence<? extends Character> toFind, dafny.DafnySequence<? extends Character> toReplace)
  {
    dafny.DafnySequence<? extends Character> newString = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    if(true) {
      if ((java.math.BigInteger.valueOf((str).length())).compareTo((java.math.BigInteger.valueOf((toFind).length()))) < 0) {
        newString = str;
        return newString;
      }
      if ((toFind).isPrefixOf((str))) {
        dafny.DafnySequence<? extends Character> _62_result;
        dafny.DafnySequence<? extends Character> _out0;
        _out0 = __default.findAndReplace((str).drop(java.math.BigInteger.valueOf((toFind).length())), toFind, toReplace);
        _62_result = _out0;
        newString = dafny.DafnySequence.<Character>concatenate(toReplace, _62_result);
        return newString;
      } else {
        dafny.DafnySequence<? extends Character> _63_result;
        dafny.DafnySequence<? extends Character> _out1;
        _out1 = __default.findAndReplace((str).drop(java.math.BigInteger.ONE), toFind, toReplace);
        _63_result = _out1;
        newString = dafny.DafnySequence.<Character>concatenate((str).take(java.math.BigInteger.ONE), _63_result);
        return newString;
      }
    }
    return newString;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
