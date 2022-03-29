// Class LLHashMapTests
// Dafny class LLHashMapTests compiled into Java
package HashtableTests_Compile;

import Hashtable_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class LLHashMapTests {
  public LLHashMapTests() {
  }
  @org.junit.jupiter.api.Test
  public void testHash()
  {
    Hashtable_Compile.LlHashMap _68_table;
    Hashtable_Compile.LlHashMap _nw5 = new Hashtable_Compile.LlHashMap();
    _nw5.__ctor(java.math.BigInteger.valueOf(16L));
    _68_table = _nw5;
    Utils_Compile.Assertions.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((_68_table.buffer))), java.math.BigInteger.valueOf(16L));
    Utils_Compile.Assertions.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _68_table.size, java.math.BigInteger.ZERO);
    java.math.BigInteger _69_p20 = java.math.BigInteger.ZERO;
    java.math.BigInteger _out7 = java.math.BigInteger.ZERO;
    _out7 = (_68_table).hashOf(java.math.BigInteger.valueOf(20L));
    _69_p20 = _out7;
    java.math.BigInteger _70_p10 = java.math.BigInteger.ZERO;
    java.math.BigInteger _out8 = java.math.BigInteger.ZERO;
    _out8 = (_68_table).hashOf(java.math.BigInteger.valueOf(10L));
    _70_p10 = _out8;
    java.math.BigInteger _71_n10 = java.math.BigInteger.ZERO;
    java.math.BigInteger _out9 = java.math.BigInteger.ZERO;
    _out9 = (_68_table).hashOf(java.math.BigInteger.valueOf(-10L));
    _71_n10 = _out9;
    Utils_Compile.Assertions.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((_68_table.buffer))), java.math.BigInteger.valueOf(16L));
    Utils_Compile.Assertions.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _70_p10, _71_n10);
    Utils_Compile.Assertions.<Boolean>assertFalse(dafny.TypeDescriptor.BOOLEAN, java.util.Objects.equals(_69_p20, java.math.BigInteger.valueOf(10L)));
  }
  private static final dafny.TypeDescriptor<LLHashMapTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(LLHashMapTests.class, () -> (LLHashMapTests) null);
  public static dafny.TypeDescriptor<LLHashMapTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<LLHashMapTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
