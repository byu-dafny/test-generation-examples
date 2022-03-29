// Class PrivateDoublyLinkedListTests
// Dafny class PrivateDoublyLinkedListTests compiled into Java
package PrivateDLLTests_Compile;

import PrivateDLL_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class PrivateDoublyLinkedListTests {
  public PrivateDoublyLinkedListTests() {
  }
  public PrivateDLL_Compile.PrivateDoublyLinkedList<__T> GetFreshPrivateDoublyLinkedList() {
    return new PrivateDLL_Compile.PrivateDoublyLinkedList<__T>();
  }
  public PrivateDLL_Compile.PrivateNode<__T> GetFreshPrivateNode() {
    return new PrivateDLL_Compile.PrivateNode<__T>();
  }
  public PrivateDLL_Compile.DllIterator<__T> GetFreshDllIterator() {
    return new PrivateDLL_Compile.DllIterator<__T>();
  }
  public <__T> PrivateDLL_Compile.PrivateDoublyLinkedList<__T> GetEmptyList(dafny.TypeDescriptor<__T> _td___T)
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list = null;
    if(true) {
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out0;
      _out0 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out0;
      (list).head = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (list).tail = (PrivateDLL_Compile.PrivateNode<__T>) null;
    }
    return list;
  }
  public <__T> dafny.Tuple2 GetListWithOneNode(dafny.TypeDescriptor<__T> _td___T, __T payload)
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list = null;
    PrivateDLL_Compile.PrivateNode<__T> node = null;
    if(true) {
      PrivateDLL_Compile.PrivateNode<__T> _out1;
      _out1 = (this).<__T>GetFreshPrivateNode(_td___T);
      node = _out1;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out2;
      _out2 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out2;
      (node).payload = payload;
      (node).L = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (node).R = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (list).head = node;
      (list).tail = node;
    }
    return new dafny.Tuple2<>(list, node);
  }
  public <__T> dafny.Tuple3 GetListWithTwoNodes(dafny.TypeDescriptor<__T> _td___T, __T payload1, __T payload2)
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list = null;
    PrivateDLL_Compile.PrivateNode<__T> node1 = null;
    PrivateDLL_Compile.PrivateNode<__T> node2 = null;
    if(true) {
      PrivateDLL_Compile.PrivateNode<__T> _out3;
      _out3 = (this).<__T>GetFreshPrivateNode(_td___T);
      node1 = _out3;
      PrivateDLL_Compile.PrivateNode<__T> _out4;
      _out4 = (this).<__T>GetFreshPrivateNode(_td___T);
      node2 = _out4;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out5;
      _out5 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out5;
      (node1).payload = payload1;
      (node1).L = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (node1).R = node2;
      (node2).payload = payload2;
      (node2).L = node1;
      (node2).R = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (list).head = node1;
      (list).tail = node2;
    }
    return new dafny.Tuple3<>(list, node1, node2);
  }
  public <__T> dafny.Tuple4 GetListWithThreeNodes(dafny.TypeDescriptor<__T> _td___T, __T payload1, __T payload2, __T payload3)
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list = null;
    PrivateDLL_Compile.PrivateNode<__T> node1 = null;
    PrivateDLL_Compile.PrivateNode<__T> node2 = null;
    PrivateDLL_Compile.PrivateNode<__T> node3 = null;
    if(true) {
      PrivateDLL_Compile.PrivateNode<__T> _out6;
      _out6 = (this).<__T>GetFreshPrivateNode(_td___T);
      node1 = _out6;
      PrivateDLL_Compile.PrivateNode<__T> _out7;
      _out7 = (this).<__T>GetFreshPrivateNode(_td___T);
      node2 = _out7;
      PrivateDLL_Compile.PrivateNode<__T> _out8;
      _out8 = (this).<__T>GetFreshPrivateNode(_td___T);
      node3 = _out8;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out9;
      _out9 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out9;
      (node1).payload = payload1;
      (node1).L = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (node1).R = node2;
      (node2).payload = payload2;
      (node2).L = node1;
      (node2).R = node3;
      (node3).payload = payload3;
      (node3).L = node2;
      (node3).R = (PrivateDLL_Compile.PrivateNode<__T>) null;
      (list).head = node1;
      (list).tail = node3;
    }
    return new dafny.Tuple4<>(list, node1, node2, node3);
  }
  public <__T> boolean ListIs(dafny.TypeDescriptor<__T> _td___T, PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list, dafny.DafnySequence<? extends __T> elements)
  {
    boolean b = false;
    PrivateDLL_Compile.PrivateNode<__T> _547_curr;
    _547_curr = list.head;
    PrivateDLL_Compile.PrivateNode<__T> _548_currOld;
    _548_currOld = (PrivateDLL_Compile.PrivateNode<__T>) null;
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((elements).length());
    for (java.math.BigInteger _549_i = java.math.BigInteger.ZERO; _549_i.compareTo(_hi0) < 0; _549_i = _549_i.add(java.math.BigInteger.ONE)) {
      if (((_547_curr) == (Object)  ((PrivateDLL_Compile.PrivateNode<__T>) null)) || (!java.util.Objects.equals(_547_curr.payload, (elements).select(dafny.Helpers.toInt((_549_i)))))) {
        b = false;
        return b;
      }
      _548_currOld = _547_curr;
      _547_curr = _547_curr.R;
      if (((_547_curr) != (Object)  ((PrivateDLL_Compile.PrivateNode<__T>) null)) && ((_547_curr.L) != (Object)  (_548_currOld))) {
        b = false;
        return b;
      }
    }
    b = (_547_curr) == (Object)  ((PrivateDLL_Compile.PrivateNode<__T>) null);
    return b;
  }
  @org.junit.jupiter.api.Test
  public void TestIsEmptyTrue()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _550_list;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out10;
    _out10 = (this).<java.math.BigInteger>GetEmptyList(dafny.TypeDescriptor.BIG_INTEGER);
    _550_list = _out10;
    boolean _551_empty;
    boolean _out11;
    _out11 = (_550_list).IsEmpty();
    _551_empty = _out11;
    Utils_Compile.Assertions.<Boolean>assertTrue(dafny.TypeDescriptor.BOOLEAN, _551_empty);
  }
  @org.junit.jupiter.api.Test
  public void TestIsEmptyFalse()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _552_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _553___v0;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out12;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out13;
    dafny.Tuple2<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector0 = (this).<java.math.BigInteger>GetListWithOneNode(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L));
    _out12 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector0.dtor__0();
    _out13 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector0.dtor__1();
    _552_list = _out12;
    _553___v0 = _out13;
    boolean _554_empty;
    boolean _out14;
    _out14 = (_552_list).IsEmpty();
    _554_empty = _out14;
    Utils_Compile.Assertions.<Boolean>assertFalse(dafny.TypeDescriptor.BOOLEAN, _554_empty);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveOnly()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _555_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _556_node;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out15;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out16;
    dafny.Tuple2<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector1 = (this).<java.math.BigInteger>GetListWithOneNode(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L));
    _out15 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector1.dtor__0();
    _out16 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector1.dtor__1();
    _555_list = _out15;
    _556_node = _out16;
    (_555_list).Remove(_556_node);
    boolean _557_empty;
    boolean _out17;
    _out17 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _555_list, dafny.DafnySequence.<java.math.BigInteger> empty(dafny.TypeDescriptor.BIG_INTEGER));
    _557_empty = _out17;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _557_empty);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveFirst()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _558_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _559_head;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _560___v2;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out18;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out19;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out20;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector2 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(6L));
    _out18 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector2.dtor__0();
    _out19 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector2.dtor__1();
    _out20 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector2.dtor__2();
    _558_list = _out18;
    _559_head = _out19;
    _560___v2 = _out20;
    (_558_list).Remove(_559_head);
    boolean _561_correct;
    boolean _out21;
    _out21 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _558_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(6L)));
    _561_correct = _out21;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _561_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveLast()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _562_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _563___v4;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _564_tail;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out22;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out23;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out24;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector3 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(6L));
    _out22 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector3.dtor__0();
    _out23 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector3.dtor__1();
    _out24 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector3.dtor__2();
    _562_list = _out22;
    _563___v4 = _out23;
    _564_tail = _out24;
    (_562_list).Remove(_564_tail);
    boolean _565_correct;
    boolean _out25;
    _out25 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _562_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L)));
    _565_correct = _out25;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _565_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveMiddle()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _566_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _567___v6;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _568_node;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _569___v7;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out26;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out27;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out28;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out29;
    dafny.Tuple4<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector4 = (this).<java.math.BigInteger>GetListWithThreeNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(6L), java.math.BigInteger.valueOf(7L));
    _out26 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector4.dtor__0();
    _out27 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector4.dtor__1();
    _out28 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector4.dtor__2();
    _out29 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector4.dtor__3();
    _566_list = _out26;
    _567___v6 = _out27;
    _568_node = _out28;
    _569___v7 = _out29;
    (_566_list).Remove(_568_node);
    boolean _570_correct;
    boolean _out30;
    _out30 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _566_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(7L)));
    _570_correct = _out30;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _570_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveHead()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _571_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _572___v9;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _573___v10;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out31;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out32;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out33;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector5 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(6L));
    _out31 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector5.dtor__0();
    _out32 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector5.dtor__1();
    _out33 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector5.dtor__2();
    _571_list = _out31;
    _572___v9 = _out32;
    _573___v10 = _out33;
    java.math.BigInteger _574_head = java.math.BigInteger.ZERO;
    java.math.BigInteger _out34 = java.math.BigInteger.ZERO;
    _out34 = (_571_list).RemoveHead();
    _574_head = _out34;
    if (!(java.util.Objects.equals(_574_head, java.math.BigInteger.valueOf(5L)))) {
      throw new dafny.DafnyHaltException("/Users/cassidywaldrip/Documents/vvlab/test-generation-examples/DoublyLinkedList/dafny/PrivateDLLTests.dfy(181,12): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    boolean _575_correct;
    boolean _out35;
    _out35 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _571_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(6L)));
    _575_correct = _out35;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _575_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveTail()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _576_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _577___v11;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _578___v12;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out36;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out37;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out38;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector6 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(6L));
    _out36 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector6.dtor__0();
    _out37 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector6.dtor__1();
    _out38 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector6.dtor__2();
    _576_list = _out36;
    _577___v11 = _out37;
    _578___v12 = _out38;
    java.math.BigInteger _579_tail = java.math.BigInteger.ZERO;
    java.math.BigInteger _out39 = java.math.BigInteger.ZERO;
    _out39 = (_576_list).RemoveTail();
    _579_tail = _out39;
    if (!(java.util.Objects.equals(_579_tail, java.math.BigInteger.valueOf(6L)))) {
      throw new dafny.DafnyHaltException("/Users/cassidywaldrip/Documents/vvlab/test-generation-examples/DoublyLinkedList/dafny/PrivateDLLTests.dfy(190,12): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    boolean _580_correct;
    boolean _out40;
    _out40 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _576_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L)));
    _580_correct = _out40;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _580_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestInsertHeadEmpty()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _581_list;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out41;
    _out41 = (this).<java.math.BigInteger>GetEmptyList(dafny.TypeDescriptor.BIG_INTEGER);
    _581_list = _out41;
    (_581_list).InsertHead(java.math.BigInteger.valueOf(5L));
    boolean _582_correct;
    boolean _out42;
    _out42 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _581_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L)));
    _582_correct = _out42;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _582_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestInsertHeadNonEmpty()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _583_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _584___v13;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out43;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out44;
    dafny.Tuple2<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector7 = (this).<java.math.BigInteger>GetListWithOneNode(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(6L));
    _out43 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector7.dtor__0();
    _out44 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector7.dtor__1();
    _583_list = _out43;
    _584___v13 = _out44;
    (_583_list).InsertHead(java.math.BigInteger.valueOf(5L));
    boolean _585_correct;
    boolean _out45;
    _out45 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _583_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L), java.math.BigInteger.valueOf(6L)));
    _585_correct = _out45;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _585_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestInsertTailEmpty()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _586_list;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out46;
    _out46 = (this).<java.math.BigInteger>GetEmptyList(dafny.TypeDescriptor.BIG_INTEGER);
    _586_list = _out46;
    (_586_list).InsertTail(java.math.BigInteger.valueOf(5L));
    boolean _587_correct;
    boolean _out47;
    _out47 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _586_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(5L)));
    _587_correct = _out47;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _587_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestInsertTailNonEmpty()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _588_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _589___v14;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out48;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out49;
    dafny.Tuple2<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector8 = (this).<java.math.BigInteger>GetListWithOneNode(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(6L));
    _out48 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector8.dtor__0();
    _out49 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector8.dtor__1();
    _588_list = _out48;
    _589___v14 = _out49;
    (_588_list).InsertTail(java.math.BigInteger.valueOf(5L));
    boolean _590_correct;
    boolean _out50;
    _out50 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _588_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(6L), java.math.BigInteger.valueOf(5L)));
    _590_correct = _out50;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _590_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestPeekHead()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _591_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _592___v15;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _593___v16;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out51;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out52;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out53;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector9 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(3L), java.math.BigInteger.valueOf(4L));
    _out51 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector9.dtor__0();
    _out52 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector9.dtor__1();
    _out53 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector9.dtor__2();
    _591_list = _out51;
    _592___v15 = _out52;
    _593___v16 = _out53;
    java.math.BigInteger _594_head = java.math.BigInteger.ZERO;
    java.math.BigInteger _out54 = java.math.BigInteger.ZERO;
    _out54 = (_591_list).PeekHead();
    _594_head = _out54;
    Utils_Compile.Assertions.<java.math.BigInteger>expectEquals(dafny.TypeDescriptor.BIG_INTEGER, _594_head, java.math.BigInteger.valueOf(3L));
  }
  @org.junit.jupiter.api.Test
  public void TestPeekTail()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _595_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _596___v17;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _597___v18;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out55;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out56;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out57;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector10 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(3L), java.math.BigInteger.valueOf(4L));
    _out55 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector10.dtor__0();
    _out56 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector10.dtor__1();
    _out57 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector10.dtor__2();
    _595_list = _out55;
    _596___v17 = _out56;
    _597___v18 = _out57;
    java.math.BigInteger _598_tail = java.math.BigInteger.ZERO;
    java.math.BigInteger _out58 = java.math.BigInteger.ZERO;
    _out58 = (_595_list).PeekTail();
    _598_tail = _out58;
    Utils_Compile.Assertions.<java.math.BigInteger>expectEquals(dafny.TypeDescriptor.BIG_INTEGER, _598_tail, java.math.BigInteger.valueOf(4L));
  }
  @org.junit.jupiter.api.Test
  public void TestClear()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _599_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _600___v19;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _601___v20;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out59;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out60;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out61;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector11 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(3L), java.math.BigInteger.valueOf(4L));
    _out59 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector11.dtor__0();
    _out60 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector11.dtor__1();
    _out61 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector11.dtor__2();
    _599_list = _out59;
    _600___v19 = _out60;
    _601___v20 = _out61;
    (_599_list).Clear();
    boolean _602_empty;
    boolean _out62;
    _out62 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _599_list, dafny.DafnySequence.<java.math.BigInteger> empty(dafny.TypeDescriptor.BIG_INTEGER));
    _602_empty = _out62;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _602_empty);
  }
  private static final dafny.TypeDescriptor<PrivateDoublyLinkedListTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(PrivateDoublyLinkedListTests.class, () -> (PrivateDoublyLinkedListTests) null);
  public static dafny.TypeDescriptor<PrivateDoublyLinkedListTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<PrivateDoublyLinkedListTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
