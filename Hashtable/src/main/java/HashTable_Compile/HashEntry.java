// Class HashEntry
// Dafny class HashEntry compiled into Java
package Hashtable_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class HashEntry {
  public HashEntry() {
    this.key = java.math.BigInteger.ZERO;
    this.value = java.math.BigInteger.ZERO;
  }
  public java.math.BigInteger key;
  public java.math.BigInteger value;
  public void __ctor(java.math.BigInteger key, java.math.BigInteger value)
  {
    (this).key = key;
    (this).value = value;
  }
  private static final dafny.TypeDescriptor<HashEntry> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(HashEntry.class, () -> (HashEntry) null);
  public static dafny.TypeDescriptor<HashEntry> _typeDescriptor() {
    return (dafny.TypeDescriptor<HashEntry>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
