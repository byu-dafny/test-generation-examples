package Extern;

import java.lang.String;
import java.lang.AssertionError;
import dafny.DafnySequence;
import dafny.Array;
import  java.lang.reflect.Constructor.*;

public class Extern {

    public static void fatal(DafnySequence<java.lang.Character> msg) {
        throw new AssertionError();
    }

  public static <__T> java.lang.Object newArrayFill(dafny.TypeDescriptor<__T> _td___T, int n, __T t)
  {
    java.lang.Object ar = (Object) _td___T.newArray(0);
    java.lang.Object _156_arr = (Object) _td___T.newArray(0);
    java.lang.Object _nw0 = _td___T.newArray(n);
    java.util.function.Function<java.math.BigInteger, __T> _arrayinit0 = ((java.util.function.Function<__T, java.util.function.Function<java.math.BigInteger, __T>>)(_157_t) -> ((java.util.function.Function<java.math.BigInteger, __T>)(_158_i) -> {
      return _157_t;
    })).apply(t);
    for (java.math.BigInteger _arrayinit_00 = java.math.BigInteger.ZERO; _arrayinit_00.compareTo(java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength(_nw0))) < 0; _arrayinit_00 = _arrayinit_00.add(java.math.BigInteger.ONE)) {
      _td___T.setArrayElement(_nw0, dafny.Helpers.toInt(_arrayinit_00), _arrayinit0.apply(_arrayinit_00));
    }
    _156_arr = _nw0;
    ar = _156_arr;
    return ar;
  }
}