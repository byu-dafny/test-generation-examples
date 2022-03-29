// Class Sha3Tests
// Dafny class Sha3Tests compiled into Java
package Sha3Tests_Compile;

import Sha3_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Sha3Tests {
  public Sha3Tests() {
  }
  public dafny.Array2<Long> initialState()
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw5 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw5;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = -1594274268089155584L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 1L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
    }
    return out;
  }
  public dafny.Array2<Long> rhoFinalState()
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw6 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw6;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = -1594274268089155584L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ZERO)).intValue())] = 262144L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.ONE)).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(2L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(3L))).intValue())] = 0L;
      ((long[][]) (((out)).elmts))[dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())][dafny.Helpers.toInt(((java.math.BigInteger.valueOf(4L))).intValue())] = 0L;
    }
    return out;
  }
  public void testRho()
  {
    dafny.Array2<Long> _113_inState;
    dafny.Array2<Long> _out3;
    _out3 = (this).initialState();
    _113_inState = _out3;
    dafny.Array2<Long> _114_rhoState;
    dafny.Array2<Long> _out4;
    _out4 = Sha3_Compile.__default.rho(_113_inState);
    _114_rhoState = _out4;
    dafny.Array2<Long> _115_outState;
    dafny.Array2<Long> _out5;
    _out5 = (this).rhoFinalState();
    _115_outState = _out5;
  }
  public dafny.Array2<Long> chiFinalState()
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw7 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw7;
    }
    return out;
  }
  public void testChi()
  {
    dafny.Array2<Long> _116_state;
    dafny.Array2<Long> _out6;
    _out6 = (this).initialState();
    _116_state = _out6;
  }
  public dafny.Array2<Long> piFinalState()
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw8 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw8;
    }
    return out;
  }
  public void testPi()
  {
    dafny.Array2<Long> _117_state;
    dafny.Array2<Long> _out7;
    _out7 = (this).initialState();
    _117_state = _out7;
  }
  public dafny.Array2<Long> iotaFinalState()
  {
    dafny.Array2<Long> out = new dafny.Array2<>(dafny.TypeDescriptor.LONG, 0, 0, new long[0][0]);
    if(true) {
      dafny.Array2<Long> _nw9 = new dafny.Array2<>(dafny.TypeDescriptor.LONG, dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), (Object[]) dafny.TypeDescriptor.LONG.newArray(dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"), dafny.Helpers.toIntChecked((java.math.BigInteger.valueOf(5L)), "Java arrays may be no larger than the maximum 32-bit signed int"))).fillThenReturn(0);
      out = _nw9;
    }
    return out;
  }
  public void testIota()
  {
    dafny.Array2<Long> _118_state;
    dafny.Array2<Long> _out8;
    _out8 = (this).initialState();
    _118_state = _out8;
  }
  private static final dafny.TypeDescriptor<Sha3Tests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Sha3Tests.class, () -> (Sha3Tests) null);
  public static dafny.TypeDescriptor<Sha3Tests> _typeDescriptor() {
    return (dafny.TypeDescriptor<Sha3Tests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
