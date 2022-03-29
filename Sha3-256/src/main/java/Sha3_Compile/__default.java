// Class __default
// Dafny class __default compiled into Java
package Sha3_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static java.math.BigInteger rhotates(java.math.BigInteger i)
  {
    java.math.BigInteger out = java.math.BigInteger.ZERO;
    if(true) {
      if ((i).signum() == 0) {
        out = java.math.BigInteger.ZERO;
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.ONE)) {
        out = java.math.BigInteger.ONE;
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(2L))) {
        out = java.math.BigInteger.valueOf(62L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(3L))) {
        out = java.math.BigInteger.valueOf(28L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(4L))) {
        out = java.math.BigInteger.valueOf(27L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(5L))) {
        out = java.math.BigInteger.valueOf(36L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(6L))) {
        out = java.math.BigInteger.valueOf(44L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(7L))) {
        out = java.math.BigInteger.valueOf(6L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(8L))) {
        out = java.math.BigInteger.valueOf(55L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(9L))) {
        out = java.math.BigInteger.valueOf(20L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(10L))) {
        out = java.math.BigInteger.valueOf(3L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(11L))) {
        out = java.math.BigInteger.valueOf(10L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(12L))) {
        out = java.math.BigInteger.valueOf(43L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(13L))) {
        out = java.math.BigInteger.valueOf(25L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(14L))) {
        out = java.math.BigInteger.valueOf(39L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(15L))) {
        out = java.math.BigInteger.valueOf(41L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(16L))) {
        out = java.math.BigInteger.valueOf(45L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(17L))) {
        out = java.math.BigInteger.valueOf(15L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(18L))) {
        out = java.math.BigInteger.valueOf(21L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(19L))) {
        out = java.math.BigInteger.valueOf(8L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(20L))) {
        out = java.math.BigInteger.valueOf(18L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(21L))) {
        out = java.math.BigInteger.valueOf(2L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(22L))) {
        out = java.math.BigInteger.valueOf(61L);
        return out;
      } else if (java.util.Objects.equals(i, java.math.BigInteger.valueOf(23L))) {
        out = java.math.BigInteger.valueOf(56L);
        return out;
      } else {
        out = java.math.BigInteger.valueOf(14L);
        return out;
      }
    }
    return out;
  }
  public static long lcycle(long b, java.math.BigInteger i)
  {
    long out = 0;
    if(true) {
      out = (long)  (((long) (((long)  ((b) << (i).intValue())))) | ((long)  ((b) >>> ((java.math.BigInteger.valueOf(64L)).subtract((i))).intValue())));
    }
    return out;
  }
  public static dafny.Array2<Long> rho(dafny.Array2<Long> state)
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw0 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw0;
      java.math.BigInteger _hi0 = java.math.BigInteger.valueOf(25L);
      for (java.math.BigInteger _99_i = java.math.BigInteger.ZERO; _99_i.compareTo(_hi0) < 0; _99_i = _99_i.add(java.math.BigInteger.ONE)) {
        java.math.BigInteger _100_y = java.math.BigInteger.ZERO;
        _100_y = dafny.DafnyEuclidean.EuclideanDivision(_99_i, java.math.BigInteger.valueOf(5L));
        java.math.BigInteger _101_x = java.math.BigInteger.ZERO;
        _101_x = dafny.DafnyEuclidean.EuclideanModulus(_99_i, java.math.BigInteger.valueOf(5L));
        java.math.BigInteger _102_rhot = java.math.BigInteger.ZERO;
        java.math.BigInteger _out0 = java.math.BigInteger.ZERO;
        _out0 = __default.rhotates(_99_i);
        _102_rhot = _out0;
        long _out1;
        _out1 = __default.lcycle((long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((_100_y)))][(dafny.Helpers.toInt((_101_x)))], _102_rhot);
        ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((_100_y)).intValue())][dafny.Helpers.toInt(((_101_x)).intValue())] = _out1;
      }
    }
    return out;
  }
  public static dafny.Array2<Long> pi(dafny.Array2<Long> state)
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw1 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw1;
      java.math.BigInteger _hi1 = java.math.BigInteger.valueOf(25L);
      for (java.math.BigInteger _103_i = java.math.BigInteger.ZERO; _103_i.compareTo(_hi1) < 0; _103_i = _103_i.add(java.math.BigInteger.ONE)) {
        java.math.BigInteger _104_y = java.math.BigInteger.ZERO;
        _104_y = dafny.DafnyEuclidean.EuclideanDivision(_103_i, java.math.BigInteger.valueOf(5L));
        java.math.BigInteger _105_x = java.math.BigInteger.ZERO;
        _105_x = dafny.DafnyEuclidean.EuclideanModulus(_103_i, java.math.BigInteger.valueOf(5L));
        ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((_104_y)).intValue())][dafny.Helpers.toInt(((_105_x)).intValue())] = (long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((_105_x)))][(dafny.Helpers.toInt((dafny.DafnyEuclidean.EuclideanModulus((_105_x).add(((java.math.BigInteger.valueOf(3L)).multiply((_104_y)))), java.math.BigInteger.valueOf(5L)))))];
      }
    }
    return out;
  }
  public static dafny.Array2<Long> chi(dafny.Array2<Long> state)
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw2 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw2;
      java.math.BigInteger _hi2 = java.math.BigInteger.valueOf(25L);
      for (java.math.BigInteger _106_i = java.math.BigInteger.ZERO; _106_i.compareTo(_hi2) < 0; _106_i = _106_i.add(java.math.BigInteger.ONE)) {
        java.math.BigInteger _107_y = java.math.BigInteger.ZERO;
        _107_y = dafny.DafnyEuclidean.EuclideanDivision(_106_i, java.math.BigInteger.valueOf(5L));
        java.math.BigInteger _108_x = java.math.BigInteger.ZERO;
        _108_x = dafny.DafnyEuclidean.EuclideanModulus(_106_i, java.math.BigInteger.valueOf(5L));
        ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((_107_y)).intValue())][dafny.Helpers.toInt(((_108_x)).intValue())] = (long)  (((long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((_108_x)))][(dafny.Helpers.toInt((_107_y)))]) ^ ((long)  (((long)  (((long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((_107_y)))][(dafny.Helpers.toInt((dafny.DafnyEuclidean.EuclideanModulus((_108_x).add((java.math.BigInteger.ONE)), java.math.BigInteger.valueOf(5L)))))]) ^ (-1L))) & ((long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((_107_y)))][(dafny.Helpers.toInt((dafny.DafnyEuclidean.EuclideanModulus((_108_x).add((java.math.BigInteger.valueOf(2L))), java.math.BigInteger.valueOf(5L)))))]))));
      }
    }
    return out;
  }
  public static long[] iotas()
  {
    long[] out = new long[0];
    if(true) {
      long[] _nw3 = (long[]) dafny.TypeDescriptor.LONG.fillThenReturnArray(dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(24L)), "Java arrays may be no larger than the maximum 32-bit signed int")), 0);
      out = _nw3;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 1L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 32898L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = -9223372036854742902L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = -9223372034707259392L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 32907L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(5L))).intValue())] = 2147483649L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(6L))).intValue())] = -9223372034707259263L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(7L))).intValue())] = -9223372036854743031L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(8L))).intValue())] = 138L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(9L))).intValue())] = 136L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(10L))).intValue())] = 2147516425L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(11L))).intValue())] = 2147483658L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(12L))).intValue())] = 2147516555L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(13L))).intValue())] = -9223372036854775669L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(14L))).intValue())] = -9223372036854742903L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(15L))).intValue())] = -9223372036854743037L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(16L))).intValue())] = -9223372036854743038L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(17L))).intValue())] = -9223372036854775680L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(18L))).intValue())] = 32778L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(19L))).intValue())] = -9223372034707292150L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(20L))).intValue())] = -9223372034707259263L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(21L))).intValue())] = -9223372036854742912L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(22L))).intValue())] = 2147483649L;
      (out)[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(23L))).intValue())] = -9223372034707259384L;
    }
    return out;
  }
  public static dafny.Array2<Long> iota(dafny.Array2<Long> state, java.math.BigInteger i)
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw4 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw4;
      java.math.BigInteger _hi3 = java.math.BigInteger.valueOf(25L);
      for (java.math.BigInteger _109_i = java.math.BigInteger.ONE; _109_i.compareTo(_hi3) < 0; _109_i = _109_i.add(java.math.BigInteger.ONE)) {
        java.math.BigInteger _110_y = java.math.BigInteger.ZERO;
        _110_y = dafny.DafnyEuclidean.EuclideanDivision(_109_i, java.math.BigInteger.valueOf(5L));
        java.math.BigInteger _111_x = java.math.BigInteger.ZERO;
        _111_x = dafny.DafnyEuclidean.EuclideanModulus(_109_i, java.math.BigInteger.valueOf(5L));
        ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((_110_y)).intValue())][dafny.Helpers.toInt(((_111_x)).intValue())] = (long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((_110_y)))][(dafny.Helpers.toInt((_111_x)))];
      }
      long[] _112_iots;
      long[] _out2;
      _out2 = __default.iotas();
      _112_iots = _out2;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = (long)  (((_112_iots)[(dafny.Helpers.toInt((i)))]) ^ ((long)((long[][]) (((state)).elmts))[(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))][(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))]));
    }
    return out;
  }
  public static void Main()
  {
  }
  public static void __Main() {
    __default.Main();
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
