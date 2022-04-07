// Class Int
// Dafny class Int compiled into Java
package Extern_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class Int {
  public Int() {
  }
  public static java.util.ArrayList<Integer> IntegerRange(java.math.BigInteger lo, java.math.BigInteger hi) {
    java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
    for (java.math.BigInteger j = lo; j.compareTo(hi) < 0; j = j.add(java.math.BigInteger.ONE)) { arr.add(Integer.valueOf(j.intValue())); }
    return arr;
  }
  private static final dafny.TypeDescriptor<Integer> _TYPE = dafny.TypeDescriptor.intWithDefault(0);
  public static dafny.TypeDescriptor<Integer> _typeDescriptor() {
    return (dafny.TypeDescriptor<Integer>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
