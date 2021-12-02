// Class int16
// Dafny class int16 compiled into Java
package NativeTypes_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class int16 {
  public int16() {
  }
  public static java.util.ArrayList<Short> IntegerRange(java.math.BigInteger lo, java.math.BigInteger hi) {
    java.util.ArrayList<Short> arr = new java.util.ArrayList<>();
    for (java.math.BigInteger j = lo; j.compareTo(hi) < 0; j = j.add(java.math.BigInteger.ONE)) { arr.add(Short.valueOf(j.shortValue())); }
    return arr;
  }
  private static final dafny.TypeDescriptor<Short> _TYPE = dafny.TypeDescriptor.shortWithDefault((short)0);
  public static dafny.TypeDescriptor<Short> _typeDescriptor() {
    return (dafny.TypeDescriptor<Short>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
