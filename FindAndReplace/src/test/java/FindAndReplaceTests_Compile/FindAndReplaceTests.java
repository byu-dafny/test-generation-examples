// Class FindAndReplaceTests
// Dafny class FindAndReplaceTests compiled into Java
package FindAndReplaceTests_Compile;

import org.junit.jupiter.api.Test;

import FindAndReplace_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class FindAndReplaceTests {
  public FindAndReplaceTests() {
  }

@Test
  public void test__findAndReplace__should__replaceWordInMiddleOfStr()
  {
    dafny.DafnySequence<? extends Character> _64_str;
    _64_str = dafny.DafnySequence.asString("tis");
    dafny.DafnySequence<? extends Character> _65_toFind;
    _65_toFind = dafny.DafnySequence.asString("is");
    dafny.DafnySequence<? extends Character> _66_toReplace;
    _66_toReplace = dafny.DafnySequence.asString("was");
    dafny.DafnySequence<? extends Character> _67_witnessValue;
    _67_witnessValue = dafny.DafnySequence.asString("ah");
    Utils_Compile.JUnit5.<dafny.DafnySequence<? extends Character>>assertNotEquals(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _67_witnessValue, _65_toFind);
    dafny.DafnySequence<? extends Character> _68_result;
    dafny.DafnySequence<? extends Character> _out2;
    _out2 = FindAndReplace_Compile.__default.findAndReplace(_64_str, _65_toFind, _66_toReplace);
    _68_result = _out2;
    dafny.DafnySequence<? extends Character> _69_oracleValue;
    _69_oracleValue = dafny.DafnySequence.asString("twas");
    Utils_Compile.JUnit5.<dafny.DafnySequence<? extends Character>>assertEquals(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _68_result, _69_oracleValue);
  }
  private static final dafny.TypeDescriptor<FindAndReplaceTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(FindAndReplaceTests.class, () -> (FindAndReplaceTests) null);
  public static dafny.TypeDescriptor<FindAndReplaceTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<FindAndReplaceTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
