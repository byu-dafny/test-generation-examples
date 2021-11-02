// Class IdStationTests
// Dafny class IdStationTests compiled into Java
package TokeneerTests_Compile;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import Tokeneer_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
@DisplayName("Tests for the IdStation")
public class IdStationTests {
  public IdStationTests() {
  }

  @Test
  @DisplayName("Test for path 0")
  public void test__path0()
  {
    Tokeneer_Compile.ClearanceLevel _49_clearanceLevel;
    _49_clearanceLevel = Tokeneer_Compile.ClearanceLevel.create_Confidential();
    Tokeneer_Compile.IdStation _50_i;
    Tokeneer_Compile.IdStation _nw0 = new Tokeneer_Compile.IdStation();
    _nw0.idStation(_49_clearanceLevel);
    _50_i = _nw0;
    (_50_i).access = false;
    (_50_i).alarm = false;
    (_50_i).requiredClearanceLevel = Tokeneer_Compile.ClearanceLevel.create_Secret();
    Tokeneer_Compile.Token _51_t = null;
    java.math.BigInteger _52_f = java.math.BigInteger.ZERO;
    Assertions.assertTrue(true);
  }
  private static final dafny.TypeDescriptor<IdStationTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(IdStationTests.class, () -> (IdStationTests) null);
  public static dafny.TypeDescriptor<IdStationTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<IdStationTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
