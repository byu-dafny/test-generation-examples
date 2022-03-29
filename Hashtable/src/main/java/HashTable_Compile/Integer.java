// Class Integer
// Dafny class Integer compiled into Java
package Hashtable_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class Integer {
  public Integer() {
    this.val = java.math.BigInteger.ZERO;
  }
  public java.math.BigInteger val;
  public void __ctor(java.math.BigInteger val)
  {
    (this).val = val;
  }
  private static final dafny.TypeDescriptor<Integer> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Integer.class, () -> (Integer) null);
  public static dafny.TypeDescriptor<Integer> _typeDescriptor() {
    return (dafny.TypeDescriptor<Integer>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
