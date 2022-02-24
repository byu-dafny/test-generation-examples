// Class CalculatorTests
// Dafny class CalculatorTests compiled into Java
package ParamTests_Compile;

import Param_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class CalculatorTests {
  public CalculatorTests() {
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>> AddSource()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>> testInputs = dafny.DafnySequence.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>> empty(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    testInputs = dafny.DafnySequence.of(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create(dafny.DafnySequence.asString("a"), dafny.DafnySequence.asString("b"), dafny.DafnySequence.asString("ab")), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>create(dafny.DafnySequence.asString("loss"), dafny.DafnySequence.asString("love"), dafny.DafnySequence.asString("losslove")));
    return testInputs;
  }
  public static java.util.Collection<Object[]> AddSourceConverter(dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _AddSource() {
  dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>> retValue =  AddSource();
  return AddSourceConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_AddSource")
  public void test__add__shouldAddTwoArguments(dafny.DafnySequence<? extends Character> a, dafny.DafnySequence<? extends Character> b, dafny.DafnySequence<? extends Character> expected)
  {
    dafny.DafnySequence<? extends Character> _66_sum;
    dafny.DafnySequence<? extends Character> _out0;
    _out0 = Param_Compile.Calculator.add(a, b);
    _66_sum = _out0;
    Utils_Compile.Assertions.<dafny.DafnySequence<? extends Character>>assertEquals(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), expected, _66_sum);
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>> MultSource()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>> testInputs = dafny.DafnySequence.<dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>> empty(dafny.Tuple3.<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BIG_INTEGER));
    testInputs = dafny.DafnySequence.of(dafny.Tuple3.<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>_typeDescriptor(dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BIG_INTEGER, dafny.TypeDescriptor.BIG_INTEGER), dafny.Tuple3.<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>create(java.math.BigInteger.valueOf(2L), java.math.BigInteger.valueOf(3L), java.math.BigInteger.valueOf(6L)), dafny.Tuple3.<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>create(java.math.BigInteger.valueOf(40L), java.math.BigInteger.valueOf(-2L), java.math.BigInteger.valueOf(-80L)), dafny.Tuple3.<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>create(java.math.BigInteger.valueOf(-7L), java.math.BigInteger.valueOf(-7L), java.math.BigInteger.valueOf(49L)));
    return testInputs;
  }
  public static java.util.Collection<Object[]> MultSourceConverter(dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _MultSource() {
  dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger, java.math.BigInteger, java.math.BigInteger>> retValue =  MultSource();
  return MultSourceConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_MultSource")
  public void test__mult__shouldMultTwoArguments(java.math.BigInteger a, java.math.BigInteger b, java.math.BigInteger expected)
  {
    java.math.BigInteger _67_product = java.math.BigInteger.ZERO;
    java.math.BigInteger _out1 = java.math.BigInteger.ZERO;
    _out1 = Param_Compile.Calculator.mult(a, b);
    _67_product = _out1;
    Utils_Compile.Assertions.<java.math.BigInteger>assertEquals(dafny.TypeDescriptor.BIG_INTEGER, expected, _67_product);
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger[], java.math.BigInteger[], Boolean>> ArrayEqualSource()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger[], java.math.BigInteger[], Boolean>> testInputs = dafny.DafnySequence.<dafny.Tuple3<java.math.BigInteger[], java.math.BigInteger[], Boolean>> empty(dafny.Tuple3.<java.math.BigInteger[], java.math.BigInteger[], Boolean>_typeDescriptor(((dafny.TypeDescriptor<java.math.BigInteger[]>)(dafny.TypeDescriptor.BIG_INTEGER).arrayType()), ((dafny.TypeDescriptor<java.math.BigInteger[]>)(dafny.TypeDescriptor.BIG_INTEGER).arrayType()), dafny.TypeDescriptor.BOOLEAN));
    java.math.BigInteger[] _68_a;
    java.math.BigInteger[] _nw0 = (java.math.BigInteger[]) dafny.TypeDescriptor.BIG_INTEGER.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(2L)), "Java arrays may be no larger than the maximum 32-bit signed int"));
    _nw0[dafny.Helpers.toInt(0)] = java.math.BigInteger.valueOf(3L);
    _nw0[dafny.Helpers.toInt(1)] = java.math.BigInteger.valueOf(5L);
    _68_a = _nw0;
    java.math.BigInteger[] _69_b;
    java.math.BigInteger[] _nw1 = (java.math.BigInteger[]) dafny.TypeDescriptor.BIG_INTEGER.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(3L)), "Java arrays may be no larger than the maximum 32-bit signed int"));
    _nw1[dafny.Helpers.toInt(0)] = java.math.BigInteger.valueOf(3L);
    _nw1[dafny.Helpers.toInt(1)] = java.math.BigInteger.valueOf(5L);
    _nw1[dafny.Helpers.toInt(2)] = java.math.BigInteger.valueOf(6L);
    _69_b = _nw1;
    testInputs = dafny.DafnySequence.of(dafny.Tuple3.<java.math.BigInteger[], java.math.BigInteger[], Boolean>_typeDescriptor(((dafny.TypeDescriptor<java.math.BigInteger[]>)(dafny.TypeDescriptor.BIG_INTEGER).arrayType()), ((dafny.TypeDescriptor<java.math.BigInteger[]>)(dafny.TypeDescriptor.BIG_INTEGER).arrayType()), dafny.TypeDescriptor.BOOLEAN), dafny.Tuple3.<java.math.BigInteger[], java.math.BigInteger[], Boolean>create(_68_a, _68_a, true), dafny.Tuple3.<java.math.BigInteger[], java.math.BigInteger[], Boolean>create(_68_a, _69_b, false));
    return testInputs;
  }
  public static java.util.Collection<Object[]> ArrayEqualSourceConverter(dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger[], java.math.BigInteger[], Boolean>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _ArrayEqualSource() {
  dafny.DafnySequence<? extends dafny.Tuple3<java.math.BigInteger[], java.math.BigInteger[], Boolean>> retValue =  ArrayEqualSource();
  return ArrayEqualSourceConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_ArrayEqualSource")
  public void test__arrayEqual__shouldCompareTwoArgs(java.math.BigInteger[] a, java.math.BigInteger[] b, boolean expected)
  {
    boolean _70_result;
    boolean _out2;
    _out2 = Param_Compile.Calculator.arrayEqual(a, b);
    _70_result = _out2;
    Utils_Compile.Assertions.<Boolean>assertEquals(dafny.TypeDescriptor.BOOLEAN, expected, _70_result);
  }
  public static dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>> SeqPrefixSource()
  {
    dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>> testInputs = dafny.DafnySequence.<dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>> empty(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BOOLEAN));
    testInputs = dafny.DafnySequence.of(dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.TypeDescriptor.BOOLEAN), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>create(dafny.DafnySequence.of('a', 'g'), dafny.DafnySequence.of('j', 'p'), false), dafny.Tuple3.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>create(dafny.DafnySequence.of('j'), dafny.DafnySequence.of('j', 'k'), true));
    return testInputs;
  }
  public static java.util.Collection<Object[]> SeqPrefixSourceConverter(dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>>dafnyStructure) {
  java.util.List<Object[]> newList = new java.util.ArrayList<>();
  for (var tuple : dafnyStructure) {
  newList.add(new Object[] {tuple.dtor__0(), tuple.dtor__1(), tuple.dtor__2()});
  }
  return newList;
  }
  public static java.util.Collection<Object[]> _SeqPrefixSource() {
  dafny.DafnySequence<? extends dafny.Tuple3<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, Boolean>> retValue =  SeqPrefixSource();
  return SeqPrefixSourceConverter(retValue);
  }
  @org.junit.jupiter.params.ParameterizedTest
  @org.junit.jupiter.params.provider.MethodSource("_SeqPrefixSource")
  public void test__seqPrefix__shouldSeeIfAIsPrefixOfB(dafny.DafnySequence<? extends Character> a, dafny.DafnySequence<? extends Character> b, boolean expected)
  {
    boolean _71_result;
    boolean _out3;
    _out3 = Param_Compile.Calculator.seqPrefix(a, b);
    _71_result = _out3;
    Utils_Compile.Assertions.<Boolean>assertEquals(dafny.TypeDescriptor.BOOLEAN, expected, _71_result);
  }
  private static final dafny.TypeDescriptor<CalculatorTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CalculatorTests.class, () -> (CalculatorTests) null);
  public static dafny.TypeDescriptor<CalculatorTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<CalculatorTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
