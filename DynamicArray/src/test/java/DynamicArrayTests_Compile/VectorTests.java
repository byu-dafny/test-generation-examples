// Class VectorTests
// Dafny class VectorTests compiled into Java
package DynamicArrayTests_Compile;

import org.junit.jupiter.api.Test;

import NativeTypes_Compile.*;
import Extern_Compile.*;
import DynamicArray_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class VectorTests {
  public VectorTests() {
  }

@Test
  public void test__get__size__should__returnCurrentSize()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _177_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out2;
    _out2 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _177_arr = _out2;
    short _178_result;
    short _out3;
    _out3 = (_177_arr).get__size();
    _178_result = _out3;
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(Short.toUnsignedLong(_178_result)), java.math.BigInteger.ZERO);
  }

@Test
  public void test__at__index__should__returnValueAtGivenIndex()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _179_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out4;
    _out4 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _179_arr = _out4;
    java.math.BigInteger _180_oracleValue = java.math.BigInteger.ZERO;
    _180_oracleValue = java.math.BigInteger.valueOf(2L);
    (_179_arr).push__back(_180_oracleValue);
    short _181_index;
    _181_index = (short) 0;
    java.math.BigInteger _182_result = java.math.BigInteger.ZERO;
    java.math.BigInteger _out5 = java.math.BigInteger.ZERO;
    _out5 = (_179_arr).at__index(_181_index);
    _182_result = _out5;
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _182_result, (((java.math.BigInteger[])(_179_arr.buffer)))[(dafny.Helpers.unsignedToInt(_181_index))]);
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, _182_result, _180_oracleValue);
  }

@Test
  public void test__extend__buffer__should__extendBufferThenStop__when__CapacityStaysUnderMax()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _183_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out6;
    _out6 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _183_arr = _out6;
    short _184_currentSizeBeforeCall;
    _184_currentSizeBeforeCall = _183_arr.current__size;
    (_183_arr).extend__buffer(java.math.BigInteger.valueOf(4L));
    Utils_Compile.JUnit5.assertTrue(Integer.compareUnsigned(_183_arr.current__size, _183_arr.current__capacity) < 0);
    Utils_Compile.JUnit5.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(Short.toUnsignedLong(_183_arr.current__size)), java.math.BigInteger.valueOf(Short.toUnsignedLong(_184_currentSizeBeforeCall)));
  }

@Test
  public void test__push__back__should__notExtendBuffer__when__sizeIsNotOneLessThanCapacity()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _185_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out7;
    _out7 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _185_arr = _out7;
    short _186_currentSizeBeforeCall;
    _186_currentSizeBeforeCall = _185_arr.current__size;
    java.math.BigInteger _187_oracleValue = java.math.BigInteger.ZERO;
    _187_oracleValue = java.math.BigInteger.valueOf(7L);
    (_185_arr).push__back(_187_oracleValue);
    Utils_Compile.JUnit5.assertTrue((java.math.BigInteger.valueOf(Short.toUnsignedLong(_186_currentSizeBeforeCall))).compareTo((java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((((java.math.BigInteger[])(_185_arr.buffer))))))) < 0);
    Utils_Compile.JUnit5.assertTrue(java.util.Objects.equals((((java.math.BigInteger[])(_185_arr.buffer)))[(dafny.Helpers.unsignedToInt(_186_currentSizeBeforeCall))], _187_oracleValue));
    Utils_Compile.JUnit5.assertTrue((_185_arr.current__size) == ((short)((short) (short)  ((_186_currentSizeBeforeCall) + ((short) 1)))));
  }

@Test
  public void test__push__back__should__extendBuffer__when__sizeIsOneLessThanCapacity()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _188_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out8;
    _out8 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _188_arr = _out8;
    java.math.BigInteger _189_oracleValue = java.math.BigInteger.ZERO;
    _189_oracleValue = java.math.BigInteger.valueOf(7L);
    java.math.BigInteger _hi0 = (java.math.BigInteger.valueOf(Short.toUnsignedLong(_188_arr.current__capacity))).subtract((java.math.BigInteger.ONE));
    for (java.math.BigInteger _190_i = java.math.BigInteger.ZERO; _190_i.compareTo(_hi0) < 0; _190_i = _190_i.add(java.math.BigInteger.ONE)) {
      (_188_arr).push__back(_189_oracleValue);
    }
    short _191_currentSizeBeforeCall;
    _191_currentSizeBeforeCall = _188_arr.current__size;
    (_188_arr).push__back(_189_oracleValue);
    Utils_Compile.JUnit5.assertTrue((java.math.BigInteger.valueOf(Short.toUnsignedLong(_191_currentSizeBeforeCall))).compareTo((java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((((java.math.BigInteger[])(_188_arr.buffer))))))) < 0);
    Utils_Compile.JUnit5.assertTrue(java.util.Objects.equals((((java.math.BigInteger[])(_188_arr.buffer)))[(dafny.Helpers.unsignedToInt(_191_currentSizeBeforeCall))], _189_oracleValue));
    Utils_Compile.JUnit5.assertTrue((_188_arr.current__size) == ((short)((short) (short)  ((_191_currentSizeBeforeCall) + ((short) 1)))));
  }

@Test
  public void test__push__back__should__throwException__when__capacityAboveMax()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _192_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out9;
    _out9 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _192_arr = _out9;
    java.math.BigInteger _193_value = java.math.BigInteger.ZERO;
    _193_value = java.math.BigInteger.valueOf(7L);
    java.math.BigInteger _hi1 = dafny.DafnyEuclidean.EuclideanDivision(java.math.BigInteger.valueOf(Short.toUnsignedLong(NativeTypes_Compile.__default.UINT16__MAX__JAVA())), java.math.BigInteger.valueOf(2L));
    for (java.math.BigInteger _194_i = java.math.BigInteger.ZERO; _194_i.compareTo(_hi1) < 0; _194_i = _194_i.add(java.math.BigInteger.ONE)) {
      (_192_arr).push__back(_193_value);
    }
    Utils_Compile.JUnit5.<java.math.BigInteger>assertThrowsAfterPushBack(dafny.TypeDescriptor.BIG_INTEGER, _192_arr);
  }

@Test
  public void test__clear__should__modifyCurrentSizeToZero()
  {
    DynamicArray_Compile.Vector<java.math.BigInteger> _195_arr;
    DynamicArray_Compile.Vector<java.math.BigInteger> _out10;
    _out10 = Utils_Compile.DynamicArrayUtils.<java.math.BigInteger>fresh__DynamicArray(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ZERO);
    _195_arr = _out10;
    (_195_arr).clear();
    Utils_Compile.JUnit5.<Short>assertEquals(NativeTypes_Compile.uint16._typeDescriptor(), _195_arr.current__size, (short) 0);
  }
  private static final dafny.TypeDescriptor<VectorTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(VectorTests.class, () -> (VectorTests) null);
  public static dafny.TypeDescriptor<VectorTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<VectorTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
