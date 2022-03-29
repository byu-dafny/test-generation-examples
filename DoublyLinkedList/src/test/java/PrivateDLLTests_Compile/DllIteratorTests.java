// Class DllIteratorTests
// Dafny class DllIteratorTests compiled into Java
package PrivateDLLTests_Compile;

import PrivateDLL_Compile.*;
import Utils_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DllIteratorTests {
  public DllIteratorTests() {
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
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out63;
      _out63 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out63;
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
      PrivateDLL_Compile.PrivateNode<__T> _out64;
      _out64 = (this).<__T>GetFreshPrivateNode(_td___T);
      node = _out64;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out65;
      _out65 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out65;
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
      PrivateDLL_Compile.PrivateNode<__T> _out66;
      _out66 = (this).<__T>GetFreshPrivateNode(_td___T);
      node1 = _out66;
      PrivateDLL_Compile.PrivateNode<__T> _out67;
      _out67 = (this).<__T>GetFreshPrivateNode(_td___T);
      node2 = _out67;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out68;
      _out68 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out68;
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
      PrivateDLL_Compile.PrivateNode<__T> _out69;
      _out69 = (this).<__T>GetFreshPrivateNode(_td___T);
      node1 = _out69;
      PrivateDLL_Compile.PrivateNode<__T> _out70;
      _out70 = (this).<__T>GetFreshPrivateNode(_td___T);
      node2 = _out70;
      PrivateDLL_Compile.PrivateNode<__T> _out71;
      _out71 = (this).<__T>GetFreshPrivateNode(_td___T);
      node3 = _out71;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out72;
      _out72 = (this).<__T>GetFreshPrivateDoublyLinkedList(_td___T);
      list = _out72;
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
    PrivateDLL_Compile.PrivateNode<__T> _603_curr;
    _603_curr = list.head;
    PrivateDLL_Compile.PrivateNode<__T> _604_currOld;
    _604_currOld = (PrivateDLL_Compile.PrivateNode<__T>) null;
    java.math.BigInteger _hi1 = java.math.BigInteger.valueOf((elements).length());
    for (java.math.BigInteger _605_i = java.math.BigInteger.ZERO; _605_i.compareTo(_hi1) < 0; _605_i = _605_i.add(java.math.BigInteger.ONE)) {
      if (((_603_curr) == (Object)  ((PrivateDLL_Compile.PrivateNode<__T>) null)) || (!java.util.Objects.equals(_603_curr.payload, (elements).select(dafny.Helpers.toInt((_605_i)))))) {
        b = false;
        return b;
      }
      _604_currOld = _603_curr;
      _603_curr = _603_curr.R;
      if (((_603_curr) != (Object)  ((PrivateDLL_Compile.PrivateNode<__T>) null)) && ((_603_curr.L) != (Object)  (_604_currOld))) {
        b = false;
        return b;
      }
    }
    b = (_603_curr) == (Object)  ((PrivateDLL_Compile.PrivateNode<__T>) null);
    return b;
  }
  @org.junit.jupiter.api.Test
  public void TestGetVal()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _606_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _607___v21;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _608___v22;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out73;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out74;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out75;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector12 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(2L));
    _out73 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector12.dtor__0();
    _out74 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector12.dtor__1();
    _out75 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector12.dtor__2();
    _606_list = _out73;
    _607___v21 = _out74;
    _608___v22 = _out75;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _609_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out76;
    _out76 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _609_iter = _out76;
    (_609_iter).d = _606_list;
    (_609_iter).ptr = _606_list.tail;
    java.math.BigInteger _610_payload = java.math.BigInteger.ZERO;
    java.math.BigInteger _out77 = java.math.BigInteger.ZERO;
    _out77 = (_609_iter).GetVal();
    _610_payload = _out77;
    Utils_Compile.Assertions.<java.math.BigInteger>expectEquals(dafny.TypeDescriptor.BIG_INTEGER, _610_payload, java.math.BigInteger.valueOf(2L));
  }
  @org.junit.jupiter.api.Test
  public void TestMoveNextValid()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _611_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _612___v23;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _613_tail;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out78;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out79;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out80;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector13 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(2L));
    _out78 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector13.dtor__0();
    _out79 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector13.dtor__1();
    _out80 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector13.dtor__2();
    _611_list = _out78;
    _612___v23 = _out79;
    _613_tail = _out80;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _614_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out81;
    _out81 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _614_iter = _out81;
    (_614_iter).d = _611_list;
    (_614_iter).ptr = _611_list.head;
    boolean _615_valid;
    boolean _out82;
    _out82 = (_614_iter).MoveNext();
    _615_valid = _out82;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _615_valid);
    Utils_Compile.Assertions.<PrivateDLL_Compile.PrivateNode<java.math.BigInteger>>expectEquals(PrivateDLL_Compile.PrivateNode.<java.math.BigInteger>_typeDescriptor(dafny.TypeDescriptor.BIG_INTEGER), _614_iter.ptr, _611_list.tail);
  }
  @org.junit.jupiter.api.Test
  public void TestMoveNextNotValid()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _616_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _617___v24;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _618_tail;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out83;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out84;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out85;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector14 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(2L));
    _out83 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector14.dtor__0();
    _out84 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector14.dtor__1();
    _out85 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector14.dtor__2();
    _616_list = _out83;
    _617___v24 = _out84;
    _618_tail = _out85;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _619_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out86;
    _out86 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _619_iter = _out86;
    (_619_iter).d = _616_list;
    (_619_iter).ptr = _616_list.tail;
    boolean _620_valid;
    boolean _out87;
    _out87 = (_619_iter).MoveNext();
    _620_valid = _out87;
    Utils_Compile.Assertions.<Boolean>expectFalse(dafny.TypeDescriptor.BOOLEAN, _620_valid);
    Utils_Compile.Assertions.<PrivateDLL_Compile.PrivateNode<java.math.BigInteger>>expectEquals(PrivateDLL_Compile.PrivateNode.<java.math.BigInteger>_typeDescriptor(dafny.TypeDescriptor.BIG_INTEGER), _619_iter.ptr, (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) null);
  }
  @org.junit.jupiter.api.Test
  public void TestInsertBeforeIterHead()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _621_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _622___v25;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out88;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out89;
    dafny.Tuple2<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector15 = (this).<java.math.BigInteger>GetListWithOneNode(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(2L));
    _out88 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector15.dtor__0();
    _out89 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector15.dtor__1();
    _621_list = _out88;
    _622___v25 = _out89;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _623_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out90;
    _out90 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _623_iter = _out90;
    (_623_iter).d = _621_list;
    (_623_iter).ptr = _621_list.head;
    (_623_iter).<java.math.BigInteger>InsertBeforeIter(dafny.TypeDescriptor.BIG_INTEGER, _621_list, _623_iter, java.math.BigInteger.ONE);
    boolean _624_correct;
    boolean _out91;
    _out91 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _621_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(2L)));
    _624_correct = _out91;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _624_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestInsertBeforeIterInside()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _625_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _626___v26;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _627___v27;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out92;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out93;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out94;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector16 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(3L));
    _out92 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector16.dtor__0();
    _out93 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector16.dtor__1();
    _out94 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector16.dtor__2();
    _625_list = _out92;
    _626___v26 = _out93;
    _627___v27 = _out94;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _628_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out95;
    _out95 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _628_iter = _out95;
    (_628_iter).d = _625_list;
    (_628_iter).ptr = _625_list.tail;
    (_628_iter).<java.math.BigInteger>InsertBeforeIter(dafny.TypeDescriptor.BIG_INTEGER, _625_list, _628_iter, java.math.BigInteger.valueOf(2L));
    boolean _629_correct;
    boolean _out96;
    _out96 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _625_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(2L), java.math.BigInteger.valueOf(3L)));
    _629_correct = _out96;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _629_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveIterGood()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _630_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _631___v28;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _632___v29;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out97;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out98;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out99;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector17 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(3L));
    _out97 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector17.dtor__0();
    _out98 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector17.dtor__1();
    _out99 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector17.dtor__2();
    _630_list = _out97;
    _631___v28 = _out98;
    _632___v29 = _out99;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _633_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out100;
    _out100 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _633_iter = _out100;
    (_633_iter).d = _630_list;
    (_633_iter).ptr = _630_list.head;
    boolean _634_good;
    boolean _out101;
    _out101 = (_633_iter).<java.math.BigInteger>RemoveIter(dafny.TypeDescriptor.BIG_INTEGER, _630_list, _633_iter);
    _634_good = _out101;
    boolean _635_correct;
    boolean _out102;
    _out102 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _630_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.valueOf(3L)));
    _635_correct = _out102;
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _634_good);
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _635_correct);
  }
  @org.junit.jupiter.api.Test
  public void TestRemoveIterNotGood()
  {
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _636_list;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _637___v30;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _638___v31;
    PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger> _out103;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out104;
    PrivateDLL_Compile.PrivateNode<java.math.BigInteger> _out105;
    dafny.Tuple3<PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>, PrivateDLL_Compile.PrivateNode<java.math.BigInteger>> _outcollector18 = (this).<java.math.BigInteger>GetListWithTwoNodes(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE, java.math.BigInteger.valueOf(3L));
    _out103 = (PrivateDLL_Compile.PrivateDoublyLinkedList<java.math.BigInteger>) (Object) _outcollector18.dtor__0();
    _out104 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector18.dtor__1();
    _out105 = (PrivateDLL_Compile.PrivateNode<java.math.BigInteger>) (Object) _outcollector18.dtor__2();
    _636_list = _out103;
    _637___v30 = _out104;
    _638___v31 = _out105;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _639_iter;
    PrivateDLL_Compile.DllIterator<java.math.BigInteger> _out106;
    _out106 = (this).<java.math.BigInteger>GetFreshDllIterator(dafny.TypeDescriptor.BIG_INTEGER);
    _639_iter = _out106;
    (_639_iter).d = _636_list;
    (_639_iter).ptr = _636_list.tail;
    boolean _640_good;
    boolean _out107;
    _out107 = (_639_iter).<java.math.BigInteger>RemoveIter(dafny.TypeDescriptor.BIG_INTEGER, _636_list, _639_iter);
    _640_good = _out107;
    boolean _641_correct;
    boolean _out108;
    _out108 = (this).<java.math.BigInteger>ListIs(dafny.TypeDescriptor.BIG_INTEGER, _636_list, dafny.DafnySequence.of(dafny.TypeDescriptor.BIG_INTEGER, java.math.BigInteger.ONE));
    _641_correct = _out108;
    Utils_Compile.Assertions.<Boolean>expectFalse(dafny.TypeDescriptor.BOOLEAN, _640_good);
    Utils_Compile.Assertions.<Boolean>expectTrue(dafny.TypeDescriptor.BOOLEAN, _641_correct);
  }
  private static final dafny.TypeDescriptor<DllIteratorTests> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DllIteratorTests.class, () -> (DllIteratorTests) null);
  public static dafny.TypeDescriptor<DllIteratorTests> _typeDescriptor() {
    return (dafny.TypeDescriptor<DllIteratorTests>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
