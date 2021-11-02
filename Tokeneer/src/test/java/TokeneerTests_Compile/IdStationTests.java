// Class IdStationTests
// Dafny class IdStationTests compiled into Java
package TokeneerTests_Compile;

import org.junit.jupiter.api.Test;

import Tokeneer_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class IdStationTests {
  public IdStationTests() {
  }
  @Test
  public void test__OpenVersion0__NotIsValid()
  {
    Tokeneer_Compile.IdStation _62_idStation;
    Tokeneer_Compile.IdStation _out3;
    _out3 = Utils_Compile.IdStationUtils.fresh__IdStation();
    _62_idStation = _out3;
    (_62_idStation).access = false;
    (_62_idStation).alarm = false;
    (_62_idStation).requiredClearanceLevel = Tokeneer_Compile.ClearanceLevel.create_Secret();
    Tokeneer_Compile.Token _63_token;
    Tokeneer_Compile.Token _out4;
    _out4 = Utils_Compile.IdStationUtils.mock__Token__OpenVersion0__NotIsValid();
    _63_token = _out4;
    java.math.BigInteger _64_fingerPrint = java.math.BigInteger.ZERO;
    boolean _65_old__t__isMatch;
    _65_old__t__isMatch = (_63_token).isMatch(_64_fingerPrint);
    boolean _66_isOpen;
    boolean _out5;
    _out5 = (_62_idStation).openVersion0(_63_token, _64_fingerPrint);
    _66_isOpen = _out5;
    boolean _67_hasSecurityClearance;
    _67_hasSecurityClearance = (_62_idStation).hasSecurityClearance(_63_token);
    Utils_Compile.JUnit5.assertEquals(_62_idStation.access, (_65_old__t__isMatch) && (_67_hasSecurityClearance));
    Utils_Compile.JUnit5.assertEquals(_66_isOpen, _62_idStation.access);
  }
  private static final dafny.TypeDescriptor<IdStationTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(IdStationTests.class, () -> (IdStationTests) null);
  public static dafny.TypeDescriptor<IdStationTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<IdStationTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
