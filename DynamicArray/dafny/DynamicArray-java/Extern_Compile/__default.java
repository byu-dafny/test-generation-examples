// Class __default
// Dafny class __default compiled into Java
package Extern_Compile;

import NativeTypes_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__T> java.lang.Object newArrayFill(dafny.TypeDescriptor<__T> _td___T, short n, __T t)
  {
    DafnyProfiling.CodeCoverage.Record(12);
    java.lang.Object ar = (Object) _td___T.newArray(0);
    java.lang.Object _99_arr = (Object) _td___T.newArray(0);
    java.lang.Object _nw0 = _td___T.newArray(dafny.Helpers.unsignedToIntChecked(n, "Java arrays may be no larger than the maximum 32-bit signed int"));
    java.util.function.Function<java.math.BigInteger, __T> _arrayinit0 = ((java.util.function.Function<__T, java.util.function.Function<java.math.BigInteger, __T>>)(_100_t) -> ((java.util.function.Function<java.math.BigInteger, __T>)(_101_i) -> {
      return _100_t;
    })).apply(t);
    for (java.math.BigInteger _arrayinit_00 = java.math.BigInteger.ZERO; _arrayinit_00.compareTo(java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength(_nw0))) < 0; _arrayinit_00 = _arrayinit_00.add(java.math.BigInteger.ONE)) {
      _td___T.setArrayElement(_nw0, dafny.Helpers.toInt(_arrayinit_00), _arrayinit0.apply(_arrayinit_00));
    }
    _99_arr = _nw0;
    ar = _99_arr;
    return ar;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
