// Class nat64
// Dafny class nat64 compiled into Java
package NativeTypes_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class nat64 {
  public nat64() {
  }
  public static java.util.ArrayList<Long> IntegerRange(java.math.BigInteger lo, java.math.BigInteger hi) {
    java.util.ArrayList<Long> arr = new java.util.ArrayList<>();
    for (java.math.BigInteger j = lo; j.compareTo(hi) < 0; j = j.add(java.math.BigInteger.ONE)) { arr.add(Long.valueOf(j.intValue())); }
    return arr;
  }
  private static final dafny.TypeDescriptor<Long> _TYPE = dafny.TypeDescriptor.longWithDefault(0L);
  public static dafny.TypeDescriptor<Long> _typeDescriptor() {
    return (dafny.TypeDescriptor<Long>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
