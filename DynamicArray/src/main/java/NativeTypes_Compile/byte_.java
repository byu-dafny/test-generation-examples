// Class byte_
// Dafny class byte_ compiled into Java
package NativeTypes_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class byte_ {
  public byte_() {
  }
  public static java.util.ArrayList<Byte> IntegerRange(java.math.BigInteger lo, java.math.BigInteger hi) {
    java.util.ArrayList<Byte> arr = new java.util.ArrayList<>();
    for (java.math.BigInteger j = lo; j.compareTo(hi) < 0; j = j.add(java.math.BigInteger.ONE)) { arr.add(Byte.valueOf(j.byteValue())); }
    return arr;
  }
  private static final dafny.TypeDescriptor<Byte> _TYPE = dafny.TypeDescriptor.byteWithDefault((byte)0);
  public static dafny.TypeDescriptor<Byte> _typeDescriptor() {
    return (dafny.TypeDescriptor<Byte>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
