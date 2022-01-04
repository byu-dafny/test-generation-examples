// Class __default
// Dafny class __default compiled into Java
package NativeTypes_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static long maxi64(long x, long y)
  {
    if ((x) > (y)) {
      return x;
    } else {
      return y;
    }
  }
  public static long maxu64(long x, long y)
  {
    if (Long.compareUnsigned(x, y) > 0) {
      return x;
    } else {
      return y;
    }
  }
  public static int minu32(int x, int y)
  {
    if (Integer.compareUnsigned(x, y) > 0) {
      return y;
    } else {
      return x;
    }
  }
  public static long minu64(long x, long y)
  {
    if (Long.compareUnsigned(x, y) > 0) {
      return y;
    } else {
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
