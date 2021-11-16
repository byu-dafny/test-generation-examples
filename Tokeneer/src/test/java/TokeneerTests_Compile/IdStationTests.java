// Class IdStationTests
// Dafny class IdStationTests compiled into Java
package TokeneerTests_Compile;

import Tokeneer_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class IdStationTests {
  public IdStationTests() {
  }
  public void test__OpenVersion0__NotIsValid()
  {
    Tokeneer_Compile.IdStation _106_idStation;
    Tokeneer_Compile.IdStation _out3;
    _out3 = Utils_Compile.IdStationUtils.fresh__IdStation();
    _106_idStation = _out3;
    (_106_idStation).access = false;
    (_106_idStation).alarm = false;
    (_106_idStation).requiredClearanceLevel = Tokeneer_Compile.ClearanceLevel.create_Secret();
    Tokeneer_Compile.Token _107_token;
    Tokeneer_Compile.Token _out4;
    _out4 = Utils_Compile.IdStationUtils.mock__Token__OpenVersion0__NotIsValid();
    _107_token = _out4;
    java.math.BigInteger _108_fingerprint = java.math.BigInteger.ZERO;
    boolean _109_old__t__isMatch;
    _109_old__t__isMatch = (_107_token).f__isValid(_108_fingerprint);
    boolean _110_isOpen;
    boolean _out5;
    _out5 = (_106_idStation).openVersion0(_107_token, _108_fingerprint);
    _110_isOpen = _out5;
    boolean _111_hasSecurityClearance;
    _111_hasSecurityClearance = (_106_idStation).hasSecurityClearance(_107_token);
    Utils_Compile.JUnit5.assertEquals(_106_idStation.access, (_109_old__t__isMatch) && (_111_hasSecurityClearance));
    Utils_Compile.JUnit5.assertEquals(_110_isOpen, _106_idStation.access);
    Utils_Compile.JUnit5.assertFalse(_110_isOpen);
    System.out.print((dafny.DafnySequence.asString("isOpen == ")).verbatimString());
    System.out.print(String.valueOf(_110_isOpen));
  }
  public void test__OpenVersion0__IsValid__NotHasClearance()
  {
    Tokeneer_Compile.IdStation _112_idStation;
    Tokeneer_Compile.IdStation _out6;
    _out6 = Utils_Compile.IdStationUtils.fresh__IdStation();
    _112_idStation = _out6;
    (_112_idStation).access = false;
    (_112_idStation).alarm = false;
    (_112_idStation).requiredClearanceLevel = Tokeneer_Compile.ClearanceLevel.create_Secret();
    Tokeneer_Compile.Token _113_token;
    Tokeneer_Compile.Token _out7;
    _out7 = Utils_Compile.IdStationUtils.mock__Token__OpenVersion0__IsValid__NotHasClearance();
    _113_token = _out7;
    java.math.BigInteger _114_fingerprint = java.math.BigInteger.ZERO;
    boolean _115_old__t__isMatch;
    _115_old__t__isMatch = (_113_token).f__isValid(_114_fingerprint);
    boolean _116_isOpen;
    boolean _out8;
    _out8 = (_112_idStation).openVersion0(_113_token, _114_fingerprint);
    _116_isOpen = _out8;
    boolean _117_hasSecurityClearance;
    _117_hasSecurityClearance = (_112_idStation).hasSecurityClearance(_113_token);
    Utils_Compile.JUnit5.assertEquals(_112_idStation.access, (_115_old__t__isMatch) && (_117_hasSecurityClearance));
    Utils_Compile.JUnit5.assertEquals(_116_isOpen, _112_idStation.access);
    Utils_Compile.JUnit5.assertFalse(_116_isOpen);
    System.out.print((dafny.DafnySequence.asString("isOpen == ")).verbatimString());
    System.out.print(String.valueOf(_116_isOpen));
  }
  public void test__OpenVersion0__IsValid__HasClearance()
  {
    Tokeneer_Compile.IdStation _118_idStation;
    Tokeneer_Compile.IdStation _out9;
    _out9 = Utils_Compile.IdStationUtils.fresh__IdStation();
    _118_idStation = _out9;
    (_118_idStation).access = false;
    (_118_idStation).alarm = false;
    (_118_idStation).requiredClearanceLevel = Tokeneer_Compile.ClearanceLevel.create_Secret();
    Tokeneer_Compile.Token _119_token;
    Tokeneer_Compile.Token _out10;
    _out10 = Utils_Compile.IdStationUtils.mock__Token__OpenVersion0__IsValid__HasClearance();
    _119_token = _out10;
    java.math.BigInteger _120_fingerprint = java.math.BigInteger.ZERO;
    boolean _121_old__t__isMatch;
    _121_old__t__isMatch = (_119_token).f__isValid(_120_fingerprint);
    boolean _122_isOpen;
    boolean _out11;
    _out11 = (_118_idStation).openVersion0(_119_token, _120_fingerprint);
    _122_isOpen = _out11;
    boolean _123_hasSecurityClearance;
    _123_hasSecurityClearance = (_118_idStation).hasSecurityClearance(_119_token);
    Utils_Compile.JUnit5.assertEquals(_118_idStation.access, (_121_old__t__isMatch) && (_123_hasSecurityClearance));
    Utils_Compile.JUnit5.assertEquals(_122_isOpen, _118_idStation.access);
    Utils_Compile.JUnit5.assertTrue(_122_isOpen);
    System.out.print((dafny.DafnySequence.asString("isOpen == ")).verbatimString());
    System.out.print(String.valueOf(_122_isOpen));
  }
  private static final dafny.TypeDescriptor<IdStationTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(IdStationTests.class, () -> (IdStationTests) null);
  public static dafny.TypeDescriptor<IdStationTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<IdStationTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
