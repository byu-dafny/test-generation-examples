// Class VectorTests
// Dafny class VectorTests compiled into Java
package DynamicArrayTests_Compile;

import org.junit.jupiter.api.Test;

import NativeTypes_Compile.*;
import DynamicArray_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VectorTests {
  public VectorTests() {
  }
  public void get__size__should__returnCurrentSize()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _157_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out2;
    _out2 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER);
    _157_arr = _out2;
    int _158_result;
    int _out3;
    _out3 = (_157_arr).get__size();
    _158_result = _out3;
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(Integer.toUnsignedLong(_158_result)), java.math.BigInteger.ZERO);
  }
  public void at__index__should__returnValueAtGivenIndex()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _159_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out4;
    _out4 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER);
    _159_arr = _out4;
    java.math.BigInteger _160_oracleValue = java.math.BigInteger.ZERO;
    _160_oracleValue = java.math.BigInteger.valueOf(2L);
    (_159_arr).push__back(_160_oracleValue);
    int _161_index;
    _161_index = 0;
    java.math.BigInteger _162_result = java.math.BigInteger.ZERO;
    java.math.BigInteger _out5 = java.math.BigInteger.ZERO;
    _out5 = (_159_arr).at__index(_161_index);
    _162_result = _out5;
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _162_result, (((java.math.BigInteger[])(_159_arr.buffer)))[(_161_index)]);
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _162_result, _160_oracleValue);
  }
  public void extend__buffer__should__extendBufferThenStop__when__CapacityStaysUnderMax()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _163_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out6;
    _out6 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER);
    _163_arr = _out6;
    int _164_currentSizeBeforeCall;
    _164_currentSizeBeforeCall = _163_arr.current__size;
    (_163_arr).extend__buffer(java.math.BigInteger.valueOf(4L));
    Utils_Compile.JUnit5.assertTrue(Integer.compareUnsigned(_163_arr.current__size, _163_arr.current__capacity) < 0);
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(Integer.toUnsignedLong(_163_arr.current__size)), java.math.BigInteger.valueOf(Integer.toUnsignedLong(_164_currentSizeBeforeCall)));
  }
  public void push__back__should__notExtendBuffer__when__sizeIsNotOneLessThanCapacity()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _165_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out7;
    _out7 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER);
    _165_arr = _out7;
    int _166_currentSizeBeforeCall;
    _166_currentSizeBeforeCall = _165_arr.current__size;
    java.math.BigInteger _167_oracleValue = java.math.BigInteger.ZERO;
    _167_oracleValue = java.math.BigInteger.valueOf(7L);
    (_165_arr).push__back(_167_oracleValue);
    Utils_Compile.JUnit5.assertTrue((java.math.BigInteger.valueOf(Integer.toUnsignedLong(_166_currentSizeBeforeCall))).compareTo((java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((((java.math.BigInteger[])(_165_arr.buffer))))))) < 0);
    Utils_Compile.JUnit5.assertTrue(java.util.Objects.equals((((java.math.BigInteger[])(_165_arr.buffer)))[(_166_currentSizeBeforeCall)], _167_oracleValue));
    Utils_Compile.JUnit5.assertTrue((_165_arr.current__size) == ((int)  ((_166_currentSizeBeforeCall) + (1))));
  }
  public void push__back__should__extendBuffer__when__sizeIsOneLessThanCapacity()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _168_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out8;
    _out8 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER);
    _168_arr = _out8;
    java.math.BigInteger _169_oracleValue = java.math.BigInteger.ZERO;
    _169_oracleValue = java.math.BigInteger.valueOf(7L);
    java.math.BigInteger _hi0 = (java.math.BigInteger.valueOf(Integer.toUnsignedLong(_168_arr.current__capacity))).subtract((java.math.BigInteger.ONE));
    for (java.math.BigInteger _170_i = java.math.BigInteger.ZERO; _170_i.compareTo(_hi0) < 0; _170_i = _170_i.add(java.math.BigInteger.ONE)) {
      (_168_arr).push__back(_169_oracleValue);
    }
    int _171_currentSizeBeforeCall;
    _171_currentSizeBeforeCall = _168_arr.current__size;
    (_168_arr).push__back(_169_oracleValue);
    Utils_Compile.JUnit5.assertTrue((java.math.BigInteger.valueOf(Integer.toUnsignedLong(_171_currentSizeBeforeCall))).compareTo((java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((((java.math.BigInteger[])(_168_arr.buffer))))))) < 0);
    Utils_Compile.JUnit5.assertTrue(java.util.Objects.equals((((java.math.BigInteger[])(_168_arr.buffer)))[(_171_currentSizeBeforeCall)], _169_oracleValue));
    Utils_Compile.JUnit5.assertTrue((_168_arr.current__size) == ((int)  ((_171_currentSizeBeforeCall) + (1))));
  }
  public void clear__should__modifyCurrentSizeToZero()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _172_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out9;
    _out9 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER);
    _172_arr = _out9;
    (_172_arr).clear();
    Utils_Compile.JUnit5.<Integer>assertEquals(NativeTypes_Compile.uint32._typeDescriptor(), _172_arr.current__size, 0);
  }
  private static final dafny.TypeDescriptor<VectorTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(VectorTests.class, () -> (VectorTests) null);
  public static dafny.TypeDescriptor<VectorTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<VectorTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
