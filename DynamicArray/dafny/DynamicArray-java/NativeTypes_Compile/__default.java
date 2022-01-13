// Class __default
// Dafny class __default compiled into Java
package NativeTypes_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static long maxi64(long x, long y)
  {
    DafnyProfiling.CodeCoverage.Record(0);
    if ((x) > (y)) {
      DafnyProfiling.CodeCoverage.Record(1);
      return x;
    } else {
      DafnyProfiling.CodeCoverage.Record(2);
      return y;
    }
  }
  public static long maxu64(long x, long y)
  {
    DafnyProfiling.CodeCoverage.Record(3);
    if (Long.compareUnsigned(x, y) > 0) {
      DafnyProfiling.CodeCoverage.Record(4);
      return x;
    } else {
      DafnyProfiling.CodeCoverage.Record(5);
      return y;
    }
  }
  public static int minu32(int x, int y)
  {
    DafnyProfiling.CodeCoverage.Record(6);
    if (Integer.compareUnsigned(x, y) > 0) {
      DafnyProfiling.CodeCoverage.Record(7);
      return y;
    } else {
      DafnyProfiling.CodeCoverage.Record(8);
      return x;
    }
  }
  public static long minu64(long x, long y)
  {
    DafnyProfiling.CodeCoverage.Record(9);
    if (Long.compareUnsigned(x, y) > 0) {
      DafnyProfiling.CodeCoverage.Record(10);
      return y;
    } else {
      DafnyProfiling.CodeCoverage.Record(11);
      return x;
    }
  }
  public static long UINT62__MAX()
  {
    return 4611686018427387903L;
  }
  public static long UINT64__MAX()
  {
    return -1L;
  }
  public static int UINT32__MAX()
  {
    return -1;
  }
  public static short UINT16__MAX()
  {
    return (short) 65535;
  }
  public static long INT64__MAX()
  {
    return 9223372036854775807L;
  }
  public static long INT64__MIN()
  {
    return -9223372036854775807L;
  }
  public static short UINT16__MAX__JAVA()
  {
    return (short) 32767;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
