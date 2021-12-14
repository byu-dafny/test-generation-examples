// Dafny program PrivateDLLTests.dfy compiled into C#
// To recompile, you will need the libraries
//     System.Runtime.Numerics.dll System.Collections.Immutable.dll
// but the 'dotnet' tool in net5.0 should pick those up automatically.
// Optionally, you may want to include compiler switches like
//     /debug /nowarn:162,164,168,183,219,436,1717,1718

using System;
using System.Numerics;
[assembly: DafnyAssembly.DafnySourceAttribute(@"// Dafny 3.3.0.31020
// Command Line Options: /out:/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.cs /spillTargetCode:3 /compile:0 /home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy
// PrivateDLLTests.dfy


module PrivateDLLTests {

  import opened PrivateDLL
  class PrivateDoublyLinkedListTests {
    static method {:test} TestIsEmptyTrue()
    {
      var list := GetEmptyList<int>();
      var empty := list.IsEmpty();
      expect empty, ""expectation violation""
    }

    static method {:test} TestIsEmptyFalse()
    {
      var list, _ := GetListWithOneNode<int>(5);
      var empty := list.IsEmpty();
      expect !empty, ""expectation violation""
    }

    static method {:test} TestRemoveOnly()
    {
      var list, node := GetListWithOneNode<int>(5);
      ghost var _ := list.Remove(node);
      var empty := ListIs(list, []);
      expect empty, ""expectation violation""
    }

    static method {:test} TestRemoveFirst()
    {
      var list, head, _ := GetListWithTwoNodes<int>(5, 6);
      ghost var _ := list.Remove(head);
      var correct := ListIs(list, [6]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestRemoveLast()
    {
      var list, _, tail := GetListWithTwoNodes<int>(5, 6);
      ghost var _ := list.Remove(tail);
      var correct := ListIs(list, [5]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestRemoveMiddle()
    {
      var list, _, node, _ := GetListWithThreeNodes<int>(5, 6, 7);
      ghost var _ := list.Remove(node);
      var correct := ListIs(list, [5, 7]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestRemoveHead()
    {
      var list, _, _ := GetListWithTwoNodes<int>(5, 6);
      var head := list.RemoveHead();
      expect head == 5, ""expectation violation""
      var correct := ListIs(list, [6]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestRemoveTail()
    {
      var list, _, _ := GetListWithTwoNodes<int>(5, 6);
      var tail := list.RemoveTail();
      expect tail == 6, ""expectation violation""
      var correct := ListIs(list, [5]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestInsertHeadEmpty()
    {
      var list := GetEmptyList<int>();
      list.InsertHead(5);
      var correct := ListIs(list, [5]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestInsertHeadNonEmpty()
    {
      var list, _ := GetListWithOneNode<int>(6);
      list.InsertHead(5);
      var correct := ListIs(list, [5, 6]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestInsertTailEmpty()
    {
      var list := GetEmptyList<int>();
      list.InsertTail(5);
      var correct := ListIs(list, [5]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestInsertTailNonEmpty()
    {
      var list, _ := GetListWithOneNode<int>(6);
      list.InsertTail(5);
      var correct := ListIs(list, [6, 5]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestPeekHead()
    {
      var list, _, _ := GetListWithTwoNodes<int>(3, 4);
      var head := list.PeekHead();
      expect head == 3, ""expectation violation""
    }

    static method {:test} TestPeekTail()
    {
      var list, _, _ := GetListWithTwoNodes<int>(3, 4);
      var tail := list.PeekTail();
      expect tail == 4, ""expectation violation""
    }

    static method {:test} TestClear()
    {
      var list, _, _ := GetListWithTwoNodes<int>(3, 4);
      list.Clear();
      var empty := ListIs(list, []);
      expect empty, ""expectation violation""
    }
  }

  class DllIteratorTests {
    static method {:test} TestGetVal()
    {
      var list, _, _ := GetListWithTwoNodes<int>(1, 2);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.tail;
      iter.index := 1;
      var payload := iter.GetVal();
      expect payload == 2, ""expectation violation""
    }

    static method {:test} TestMoveNextValid()
    {
      var list, _, tail := GetListWithTwoNodes<int>(1, 2);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.head;
      iter.index := 0;
      var valid := iter.MoveNext();
      expect valid, ""expectation violation""
      expect iter.ptr == list.tail, ""expectation violation""
    }

    static method {:test} TestMoveNextNotValid()
    {
      var list, _, tail := GetListWithTwoNodes<int>(1, 2);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.tail;
      iter.index := 1;
      var valid := iter.MoveNext();
      expect !valid, ""expectation violation""
      expect iter.ptr == null, ""expectation violation""
    }

    static method {:test} TestInsertBeforeIterHead()
    {
      var list, _ := GetListWithOneNode<int>(2);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.head;
      iter.index := 0;
      InsertBeforeIter(list, iter, 1);
      var correct := ListIs(list, [1, 2]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestInsertBeforeIterInside()
    {
      var list, _, _ := GetListWithTwoNodes<int>(1, 3);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.tail;
      iter.index := 1;
      InsertBeforeIter(list, iter, 2);
      var correct := ListIs(list, [1, 2, 3]);
      expect correct, ""expectation violation""
    }

    static method {:test} TestRemoveIterGood()
    {
      var list, _, _ := GetListWithTwoNodes<int>(1, 3);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.head;
      iter.index := 0;
      var good := RemoveIter(list, iter);
      var correct := ListIs(list, [3]);
      expect good, ""expectation violation""
      expect correct, ""expectation violation""
    }

    static method {:test} TestRemoveIterNotGood()
    {
      var list, _, _ := GetListWithTwoNodes<int>(1, 3);
      var iter := GetFreshDllIterator();
      iter.d := list;
      iter.ptr := list.tail;
      iter.index := 1;
      var good := RemoveIter(list, iter);
      var correct := ListIs(list, [1]);
      expect !good, ""expectation violation""
      expect correct, ""expectation violation""
    }
  }

  method {:extern} {:fresh} GetFreshPrivateDoublyLinkedList<T>() returns (list: PrivateDoublyLinkedList<T>)
    ensures fresh(list)

  method {:extern} {:fresh} GetFreshPrivateNode<T>() returns (node: PrivateNode<T>)
    ensures fresh(node)

  method {:extern} {:fresh} GetFreshDllIterator<T>() returns (iter: DllIterator<T>)
    ensures fresh(iter)

  method GetEmptyList<T>() returns (list: PrivateDoublyLinkedList<T>)
    ensures fresh(list) && fresh(list.Repr)
    ensures list.Nodes == [] && list.Valid()
  {
    list := GetFreshPrivateDoublyLinkedList<T>();
    list.Nodes := [];
    list.Repr := {};
    list.Vals := [];
    list.head := null;
    list.tail := null;
  }

  method GetListWithOneNode<T>(payload: T) returns (list: PrivateDoublyLinkedList<T>, node: PrivateNode<T>)
    ensures fresh(list) && fresh(node) && fresh(list.Repr)
    ensures list.Nodes == [node] && list.Valid()
  {
    node := GetFreshPrivateNode<T>();
    list := GetFreshPrivateDoublyLinkedList<T>();
    node.payload := payload;
    node.L := null;
    node.R := null;
    list.Nodes := [node];
    list.Repr := {node};
    list.Vals := [payload];
    list.head := node;
    list.tail := node;
  }

  method GetListWithTwoNodes<T>(payload1: T, payload2: T)
      returns (list: PrivateDoublyLinkedList<T>, node1: PrivateNode<T>, node2: PrivateNode<T>)
    ensures fresh(list) && fresh(node1) && fresh(node2) && fresh(list.Repr)
    ensures list.Nodes == [node1, node2] && list.Valid()
  {
    node1 := GetFreshPrivateNode<T>();
    node2 := GetFreshPrivateNode<T>();
    list := GetFreshPrivateDoublyLinkedList<T>();
    node1.payload := payload1;
    node1.L := null;
    node1.R := node2;
    node2.payload := payload2;
    node2.L := node1;
    node2.R := null;
    list.Nodes := [node1, node2];
    list.Repr := {node1, node2};
    list.Vals := [payload1, payload2];
    list.head := node1;
    list.tail := node2;
  }

  method GetListWithThreeNodes<T>(payload1: T, payload2: T, payload3: T)
      returns (list: PrivateDoublyLinkedList<T>, node1: PrivateNode<T>, node2: PrivateNode<T>, node3: PrivateNode<T>)
    ensures fresh(list) && fresh(node1) && fresh(node2) && fresh(node3)
    ensures list.Repr == {node1, node2, node3}
    ensures list.Nodes == [node1, node2, node3]
    ensures list.Valid()
  {
    node1 := GetFreshPrivateNode<T>();
    node2 := GetFreshPrivateNode<T>();
    node3 := GetFreshPrivateNode<T>();
    list := GetFreshPrivateDoublyLinkedList<T>();
    node1.payload := payload1;
    node1.L := null;
    node1.R := node2;
    node2.payload := payload2;
    node2.L := node1;
    node2.R := node3;
    node3.payload := payload3;
    node3.L := node2;
    node3.R := null;
    list.Nodes := [node1, node2, node3];
    list.Repr := {node1, node2, node3};
    list.Vals := [payload1, payload2, payload3];
    list.head := node1;
    list.tail := node3;
  }

  method ListIs<T(==)>(list: PrivateDoublyLinkedList<T>, elements: seq<T>) returns (b: bool)
    decreases list, elements
  {
    var curr: PrivateNode?<T> := list.head;
    var currOld: PrivateNode?<T> := null;
    for i: int := 0 to |elements| {
      if curr == null || curr.payload != elements[i] {
        return false;
      }
      currOld := curr;
      curr := curr.R;
      if curr != null && curr.L != currOld {
        return false;
      }
    }
    return curr == null;
  }
}

module PrivateDLL {

  import opened Seqs
  class PrivateNode<T> {
    var L: PrivateNode?<T>
    var R: PrivateNode?<T>
    var payload: T

    constructor (p: T)
      ensures payload == p
    {
      payload := p;
    }
  }

  class PrivateDoublyLinkedList<T> {
    ghost var Nodes: seq<PrivateNode<T>>
    ghost var Repr: set<PrivateNode<T>>
    ghost var Vals: seq<T>
    var head: PrivateNode?<T>
    var tail: PrivateNode?<T>

    predicate Valid()
      reads this, Repr
      decreases Repr + {this}
    {
      (forall i: int :: 
        0 <= i < |Nodes| ==>
          Nodes[i] in Repr) &&
      |Nodes| == |Repr| &&
      (|Nodes| == 0 <==> head == tail == null) &&
      (|Nodes| > 0 ==>
        head == Nodes[0] &&
        tail == last(Nodes) &&
        Nodes[0].L == null &&
        last(Nodes).R == null &&
        (forall i: int {:trigger Nodes[i].L} :: 
          1 <= i < |Nodes| ==>
            Nodes[i].L == Nodes[i - 1]) &&
        forall i: int {:trigger Nodes[i].R} :: 
          0 <= i < |Nodes| - 1 ==>
            Nodes[i].R == Nodes[i + 1]) &&
      (forall i: int, j: int :: 
        0 <= i < j < |Nodes| ==>
          Nodes[i] != Nodes[j]) &&
      |Nodes| == |Vals| &&
      forall i: int :: 
        0 <= i < |Nodes| ==>
          Nodes[i].payload == Vals[i]
    }

    constructor ()
      ensures Valid()
      ensures Vals == []
      ensures fresh(Repr)
    {
      Nodes := [];
      Repr := {};
      Vals := [];
      head := null;
      tail := null;
    }

    method IsEmpty() returns (b: bool)
      requires Valid()
      ensures b <==> |Vals| == 0
    {
      b := head == null && tail == null;
    }

    method Remove(x: PrivateNode<T>) returns (ghost k: int)
      requires Valid()
      requires x in Repr
      modifies this, Repr
      ensures Valid()
      ensures 0 <= k < |old(Nodes)| && x == old(Nodes)[k]
      ensures Nodes == old(Nodes)[..k] + old(Nodes)[k + 1..]
      ensures Vals == old(Vals)[..k] + old(Vals)[k + 1..]
      ensures x.L == old(x.L) && x.R == old(x.R) && x.payload == old(x.payload)
      ensures Repr == old(Repr) - {x}
      decreases x
    {
      k := find_index(Nodes, Repr, x);
      if x.L == null && x.R == null {
        Nodes := [];
        Repr := Repr - {x};
        head := null;
        tail := null;
        Vals := [];
      } else if x.L == null {
        assert k == 0;
        x.R.L := null;
        head := x.R;
        Nodes := Nodes[1..];
        Repr := Repr - {x};
        Vals := Vals[1..];
      } else if x.R == null {
        assert k == |Nodes| - 1;
        x.L.R := null;
        tail := x.L;
        Nodes := Nodes[..|Nodes| - 1];
        assert old(Nodes)[k + 1..] == [];
        Repr := Repr - {x};
        Vals := Vals[..|Vals| - 1];
        assert old(Vals)[k + 1..] == [];
      } else {
        x.R.L := x.L;
        x.L.R := x.R;
        Nodes := Nodes[..k] + Nodes[k + 1..];
        Repr := Repr - {x};
        Vals := Vals[0 .. k] + Vals[k + 1..];
        assert Vals == old(Vals)[..k] + old(Vals)[k + 1..];
      }
    }

    method RemoveHead() returns (h: T)
      requires Valid()
      requires |Vals| != 0
      modifies this, Repr
      ensures Valid()
      ensures h == old(Vals)[0]
      ensures Vals == old(Vals)[1..]
      ensures forall o: PrivateNode<T> :: o in Repr ==> o in old(Repr)
    {
      h := head.payload;
      ghost var k := Remove(head);
    }

    method RemoveTail() returns (t: T)
      requires Valid()
      requires |Vals| != 0
      modifies this, Repr
      ensures Valid()
      ensures t == last(old(Vals))
      ensures Vals == all_but_last(old(Vals))
      ensures forall o: PrivateNode<T> :: o in Repr ==> o in old(Repr)
    {
      t := tail.payload;
      ghost var k := Remove(tail);
    }

    method InsertHead(v: T)
      requires Valid()
      modifies this, Repr
      ensures Valid()
      ensures Vals == [v] + old(Vals)
      ensures forall o: PrivateNode<T> :: o in Repr ==> o in old(Repr) || fresh(o)
    {
      var x := new PrivateNode<T>(v);
      if head == null {
        head := x;
        tail := x;
        x.L := null;
        x.R := null;
        Nodes := [x];
        Repr := {x};
      } else {
        x.R := head;
        x.L := null;
        head.L := x;
        head := x;
        Nodes := [x] + old(Nodes);
        Repr := {x} + old(Repr);
      }
      Vals := [v] + Vals;
    }

    method InsertTail(v: T)
      requires Valid()
      modifies this, Repr
      ensures Valid()
      ensures Vals == old(Vals) + [v]
      ensures forall o: PrivateNode<T> :: o in Repr ==> o in old(Repr) || fresh(o)
    {
      var x := new PrivateNode<T>(v);
      if tail == null {
        head := x;
        tail := x;
        x.L := null;
        x.R := null;
        Nodes := [x];
        Repr := {x};
      } else {
        x.L := tail;
        x.R := null;
        tail.R := x;
        tail := x;
        Nodes := old(Nodes) + [x];
        Repr := old(Repr) + {x};
      }
      Vals := Vals + [v];
    }

    method PeekHead() returns (v: T)
      requires Valid()
      requires |Vals| != 0
      ensures v == Vals[0]
    {
      v := head.payload;
    }

    method PeekTail() returns (v: T)
      requires Valid()
      requires |Vals| != 0
      ensures v == last(Vals)
    {
      v := tail.payload;
    }

    method Clear()
      requires Valid()
      modifies this, Repr
      ensures Valid()
    {
      Repr := {};
      Nodes := [];
      Vals := [];
      head := null;
      tail := null;
    }
  }

  class DllIterator<T> {
    var ptr: PrivateNode?<T>
    ghost var index: nat
    var d: PrivateDoublyLinkedList<T>

    predicate Valid()
      reads this, d, d.Repr
      decreases d.Repr + {this, d}
    {
      d.Valid() &&
      0 <= index < |d.Nodes| &&
      ptr == d.Nodes[index]
    }

    function GetIndex(): nat
      reads this
      decreases {this}
    {
      index
    }

    constructor (d': PrivateDoublyLinkedList<T>)
      requires d'.Valid()
      requires |d'.Vals| > 0
      ensures Valid()
      ensures d == d'
      ensures GetIndex() == 0
      decreases d'
    {
      d := d';
      ptr := d'.head;
      index := 0;
    }

    method GetVal() returns (v: T)
      requires Valid()
      ensures 0 <= GetIndex() < |d.Vals| && d.Vals[GetIndex()] == v
    {
      return ptr.payload;
    }

    method MoveNext() returns (good: bool)
      requires Valid()
      modifies this
      ensures good ==> Valid()
      ensures GetIndex() == old(GetIndex()) + 1
      ensures !good ==> GetIndex() == |d.Vals|
      ensures d == old(d)
    {
      ptr := ptr.R;
      index := index + 1;
      if ptr != null {
        good := true;
      } else {
        good := false;
      }
    }
  }

  lemma find_index<T>(Nodes: seq<PrivateNode<T>>, Repr: set<PrivateNode<T>>, x: PrivateNode<T>)
      returns (k: nat)
    requires forall i: int :: 0 <= i < |Nodes| ==> Nodes[i] in Repr
    requires |Nodes| == |Repr|
    requires x in Repr
    requires forall i: int, j: int :: 0 <= i < j < |Nodes| ==> Nodes[i] != Nodes[j]
    ensures 0 <= k < |Nodes| && Nodes[k] == x
    decreases Nodes, Repr, x
  {
  }

  lemma exists_index<T>(Nodes: seq<PrivateNode<T>>, Repr: set<PrivateNode<T>>, x: PrivateNode<T>)
    requires forall i: int :: 0 <= i < |Nodes| ==> Nodes[i] in Repr
    requires |Nodes| == |Repr|
    requires x in Repr
    requires forall i: int, j: int :: 0 <= i < j < |Nodes| ==> Nodes[i] != Nodes[j]
    ensures exists k: int :: 0 <= k < |Nodes| && Nodes[k] == x
    decreases Nodes, Repr, x
  {
  }

  method InsertBeforeIter<T>(d: PrivateDoublyLinkedList<T>, iter: DllIterator<T>, v: T)
    requires iter.Valid() && iter.d == d
    modifies d, d.Repr
    ensures d.Valid()
    ensures d.Vals == old(d.Vals)[..iter.GetIndex()] + [v] + old(d.Vals)[iter.GetIndex()..]
    ensures d.Vals[iter.GetIndex()] == v
    ensures forall o: PrivateNode<T> :: o in d.Repr ==> o in old(d.Repr) || fresh(o)
    decreases d, iter
  {
    if iter.ptr == d.head {
      d.InsertHead(v);
    } else {
      var x := new PrivateNode<T>(v);
      x.L := iter.ptr.L;
      x.R := iter.ptr;
      iter.ptr.L.R := x;
      iter.ptr.L := x;
      d.Nodes := old(d.Nodes)[..iter.index] + [x] + old(d.Nodes)[iter.index..];
      d.Vals := old(d.Vals)[..iter.index] + [v] + old(d.Vals)[iter.index..];
      d.Repr := old(d.Repr) + {x};
    }
  }

  method RemoveIter<T>(d: PrivateDoublyLinkedList<T>, iter: DllIterator<T>) returns (good: bool)
    requires iter.Valid() && iter.d == d
    modifies d, d.Repr, iter
    ensures d.Valid()
    ensures good ==> iter.Valid()
    ensures !good ==> iter.GetIndex() == |d.Vals|
    ensures iter.GetIndex() == old(iter.GetIndex()) && iter.d == d
    ensures forall o: PrivateNode<T> :: o in d.Repr ==> o in old(d.Repr)
    ensures d.Vals == old(d.Vals)[..old(iter.GetIndex())] + old(d.Vals)[old(iter.GetIndex()) + 1..]
    decreases d, iter
  {
    good := iter.ptr.R != null;
    var tmp := iter.ptr.R;
    ghost var k := d.Remove(iter.ptr);
    if good {
      iter.ptr := tmp;
      iter.index := iter.index;
    }
  }
}

module Seqs {
  function last<T>(s: seq<T>): T
    requires |s| > 0
    decreases s
  {
    s[|s| - 1]
  }

  function all_but_last<T>(s: seq<T>): seq<T>
    requires |s| > 0
    decreases s
  {
    s[..|s| - 1]
  }

  function reverse<T>(s: seq<T>): seq<T>
    ensures |reverse(s)| == |s|
    decreases s
  {
    if s == [] then
      []
    else
      reverse(s[1..]) + [s[0]]
  }
}
")]

//-----------------------------------------------------------------------------
//
// Copyright by the contributors to the Dafny Project
// SPDX-License-Identifier: MIT
//
//-----------------------------------------------------------------------------

#if ISDAFNYRUNTIMELIB
using System; // for Func
using System.Numerics;
#endif

namespace DafnyAssembly {
  [AttributeUsage(AttributeTargets.Assembly)]
  public class DafnySourceAttribute : Attribute {
    public readonly string dafnySourceText;
    public DafnySourceAttribute(string txt) { dafnySourceText = txt; }
  }
}

namespace Dafny {
  using System.Collections.Generic;
  using System.Collections.Immutable;
  using System.Linq;

  public interface ISet<out T> {
    int Count { get; }
    long LongCount { get; }
    IEnumerable<T> Elements { get; }
    IEnumerable<ISet<T>> AllSubsets { get; }
    bool Contains<G>(G t);
    bool EqualsAux(ISet<object> other);
    ISet<U> DowncastClone<U>(Func<T, U> converter);
  }

  public class Set<T> : ISet<T> {
    readonly ImmutableHashSet<T> setImpl;
    readonly bool containsNull;
    Set(ImmutableHashSet<T> d, bool containsNull) {
      this.setImpl = d;
      this.containsNull = containsNull;
    }

    public static readonly ISet<T> Empty = new Set<T>(ImmutableHashSet<T>.Empty, false);

    private static readonly TypeDescriptor<ISet<T>> _TYPE = new Dafny.TypeDescriptor<ISet<T>>(Empty);
    public static TypeDescriptor<ISet<T>> _TypeDescriptor() {
      return _TYPE;
    }

    public static ISet<T> FromElements(params T[] values) {
      return FromCollection(values);
    }

    public static Set<T> FromISet(ISet<T> s) {
      return s as Set<T> ?? FromCollection(s.Elements);
    }

    public static Set<T> FromCollection(IEnumerable<T> values) {
      var d = ImmutableHashSet<T>.Empty.ToBuilder();
      var containsNull = false;
      foreach (T t in values) {
        if (t == null) {
          containsNull = true;
        } else {
          d.Add(t);
        }
      }

      return new Set<T>(d.ToImmutable(), containsNull);
    }

    public static ISet<T> FromCollectionPlusOne(IEnumerable<T> values, T oneMoreValue) {
      var d = ImmutableHashSet<T>.Empty.ToBuilder();
      var containsNull = false;
      if (oneMoreValue == null) {
        containsNull = true;
      } else {
        d.Add(oneMoreValue);
      }

      foreach (T t in values) {
        if (t == null) {
          containsNull = true;
        } else {
          d.Add(t);
        }
      }

      return new Set<T>(d.ToImmutable(), containsNull);
    }

    public ISet<U> DowncastClone<U>(Func<T, U> converter) {
      if (this is ISet<U> th) {
        return th;
      } else {
        var d = ImmutableHashSet<U>.Empty.ToBuilder();
        foreach (var t in this.setImpl) {
          var u = converter(t);
          d.Add(u);
        }

        return new Set<U>(d.ToImmutable(), this.containsNull);
      }
    }

    public int Count {
      get { return this.setImpl.Count + (containsNull ? 1 : 0); }
    }

    public long LongCount {
      get { return this.setImpl.Count + (containsNull ? 1 : 0); }
    }

    public IEnumerable<T> Elements {
      get {
        if (containsNull) {
          yield return default(T);
        }

        foreach (var t in this.setImpl) {
          yield return t;
        }
      }
    }

    /// <summary>
    /// This is an inefficient iterator for producing all subsets of "this".
    /// </summary>
    public IEnumerable<ISet<T>> AllSubsets {
      get {
        // Start by putting all set elements into a list, but don't include null
        var elmts = new List<T>();
        elmts.AddRange(this.setImpl);
        var n = elmts.Count;
        var which = new bool[n];
        var s = ImmutableHashSet<T>.Empty.ToBuilder();
        while (true) {
          // yield both the subset without null and, if null is in the original set, the subset with null included
          var ihs = s.ToImmutable();
          yield return new Set<T>(ihs, false);
          if (containsNull) {
            yield return new Set<T>(ihs, true);
          }

          // "add 1" to "which", as if doing a carry chain.  For every digit changed, change the membership of the corresponding element in "s".
          int i = 0;
          for (; i < n && which[i]; i++) {
            which[i] = false;
            s.Remove(elmts[i]);
          }

          if (i == n) {
            // we have cycled through all the subsets
            break;
          }

          which[i] = true;
          s.Add(elmts[i]);
        }
      }
    }

    public bool Equals(ISet<T> other) {
      if (other == null || Count != other.Count) {
        return false;
      } else if (this == other) {
        return true;
      }

      foreach (var elmt in Elements) {
        if (!other.Contains(elmt)) {
          return false;
        }
      }

      return true;
    }

    public override bool Equals(object other) {
      if (other is ISet<T>) {
        return Equals((ISet<T>)other);
      }

      var th = this as ISet<object>;
      var oth = other as ISet<object>;
      if (th != null && oth != null) {
        // We'd like to obtain the more specific type parameter U for oth's type ISet<U>.
        // We do that by making a dynamically dispatched call, like:
        //     oth.Equals(this)
        // The hope is then that its comparison "this is ISet<U>" (that is, the first "if" test
        // above, but in the call "oth.Equals(this)") will be true and the non-virtual Equals
        // can be called. However, such a recursive call to "oth.Equals(this)" could turn
        // into infinite recursion. Therefore, we instead call "oth.EqualsAux(this)", which
        // performs the desired type test, but doesn't recurse any further.
        return oth.EqualsAux(th);
      } else {
        return false;
      }
    }

    public bool EqualsAux(ISet<object> other) {
      var s = other as ISet<T>;
      if (s != null) {
        return Equals(s);
      } else {
        return false;
      }
    }

    public override int GetHashCode() {
      var hashCode = 1;
      if (containsNull) {
        hashCode = hashCode * (Dafny.Helpers.GetHashCode(default(T)) + 3);
      }

      foreach (var t in this.setImpl) {
        hashCode = hashCode * (Dafny.Helpers.GetHashCode(t) + 3);
      }

      return hashCode;
    }

    public override string ToString() {
      var s = "{";
      var sep = "";
      if (containsNull) {
        s += sep + Dafny.Helpers.ToString(default(T));
        sep = ", ";
      }

      foreach (var t in this.setImpl) {
        s += sep + Dafny.Helpers.ToString(t);
        sep = ", ";
      }

      return s + "}";
    }
    public static bool IsProperSubsetOf(ISet<T> th, ISet<T> other) {
      return th.Count < other.Count && IsSubsetOf(th, other);
    }
    public static bool IsSubsetOf(ISet<T> th, ISet<T> other) {
      if (other.Count < th.Count) {
        return false;
      }
      foreach (T t in th.Elements) {
        if (!other.Contains(t)) {
          return false;
        }
      }
      return true;
    }
    public static bool IsDisjointFrom(ISet<T> th, ISet<T> other) {
      ISet<T> a, b;
      if (th.Count < other.Count) {
        a = th; b = other;
      } else {
        a = other; b = th;
      }
      foreach (T t in a.Elements) {
        if (b.Contains(t)) {
          return false;
        }
      }
      return true;
    }
    public bool Contains<G>(G t) {
      return t == null ? containsNull : t is T && this.setImpl.Contains((T)(object)t);
    }
    public static ISet<T> Union(ISet<T> th, ISet<T> other) {
      var a = FromISet(th);
      var b = FromISet(other);
      return new Set<T>(a.setImpl.Union(b.setImpl), a.containsNull || b.containsNull);
    }
    public static ISet<T> Intersect(ISet<T> th, ISet<T> other) {
      var a = FromISet(th);
      var b = FromISet(other);
      return new Set<T>(a.setImpl.Intersect(b.setImpl), a.containsNull && b.containsNull);
    }
    public static ISet<T> Difference(ISet<T> th, ISet<T> other) {
      var a = FromISet(th);
      var b = FromISet(other);
      return new Set<T>(a.setImpl.Except(b.setImpl), a.containsNull && !b.containsNull);
    }
  }

  public interface IMultiSet<out T> {
    bool IsEmpty { get; }
    int Count { get; }
    long LongCount { get; }
    IEnumerable<T> Elements { get; }
    IEnumerable<T> UniqueElements { get; }
    bool Contains<G>(G t);
    BigInteger Select<G>(G t);
    IMultiSet<T> Update<G>(G t, BigInteger i);
    bool EqualsAux(IMultiSet<object> other);
    IMultiSet<U> DowncastClone<U>(Func<T, U> converter);
  }

  public class MultiSet<T> : IMultiSet<T> {
    readonly ImmutableDictionary<T, BigInteger> dict;
    readonly BigInteger occurrencesOfNull;  // stupidly, a Dictionary in .NET cannot use "null" as a key
    MultiSet(ImmutableDictionary<T, BigInteger>.Builder d, BigInteger occurrencesOfNull) {
      dict = d.ToImmutable();
      this.occurrencesOfNull = occurrencesOfNull;
    }
    public static readonly MultiSet<T> Empty = new MultiSet<T>(ImmutableDictionary<T, BigInteger>.Empty.ToBuilder(), BigInteger.Zero);

    private static readonly TypeDescriptor<IMultiSet<T>> _TYPE = new Dafny.TypeDescriptor<IMultiSet<T>>(Empty);
    public static TypeDescriptor<IMultiSet<T>> _TypeDescriptor() {
      return _TYPE;
    }

    public static MultiSet<T> FromIMultiSet(IMultiSet<T> s) {
      return s as MultiSet<T> ?? FromCollection(s.Elements);
    }
    public static MultiSet<T> FromElements(params T[] values) {
      var d = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      var occurrencesOfNull = BigInteger.Zero;
      foreach (T t in values) {
        if (t == null) {
          occurrencesOfNull++;
        } else {
          BigInteger i;
          if (!d.TryGetValue(t, out i)) {
            i = BigInteger.Zero;
          }
          d[t] = i + 1;
        }
      }
      return new MultiSet<T>(d, occurrencesOfNull);
    }

    public static MultiSet<T> FromCollection(IEnumerable<T> values) {
      var d = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      var occurrencesOfNull = BigInteger.Zero;
      foreach (T t in values) {
        if (t == null) {
          occurrencesOfNull++;
        } else {
          BigInteger i;
          if (!d.TryGetValue(t,
            out i)) {
            i = BigInteger.Zero;
          }

          d[t] = i + 1;
        }
      }

      return new MultiSet<T>(d,
        occurrencesOfNull);
    }

    public static MultiSet<T> FromSeq(ISequence<T> values) {
      var d = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      var occurrencesOfNull = BigInteger.Zero;
      foreach (T t in values.Elements) {
        if (t == null) {
          occurrencesOfNull++;
        } else {
          BigInteger i;
          if (!d.TryGetValue(t,
            out i)) {
            i = BigInteger.Zero;
          }

          d[t] = i + 1;
        }
      }

      return new MultiSet<T>(d,
        occurrencesOfNull);
    }
    public static MultiSet<T> FromSet(ISet<T> values) {
      var d = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      var containsNull = false;
      foreach (T t in values.Elements) {
        if (t == null) {
          containsNull = true;
        } else {
          d[t] = BigInteger.One;
        }
      }
      return new MultiSet<T>(d, containsNull ? BigInteger.One : BigInteger.Zero);
    }
    public IMultiSet<U> DowncastClone<U>(Func<T, U> converter) {
      if (this is IMultiSet<U> th) {
        return th;
      } else {
        var d = ImmutableDictionary<U, BigInteger>.Empty.ToBuilder();
        foreach (var item in this.dict) {
          var k = converter(item.Key);
          d.Add(k, item.Value);
        }
        return new MultiSet<U>(d, this.occurrencesOfNull);
      }
    }

    public bool Equals(IMultiSet<T> other) {
      return IsSubsetOf(this, other) && IsSubsetOf(other, this);
    }
    public override bool Equals(object other) {
      if (other is IMultiSet<T>) {
        return Equals((IMultiSet<T>)other);
      }
      var th = this as IMultiSet<object>;
      var oth = other as IMultiSet<object>;
      if (th != null && oth != null) {
        // See comment in Set.Equals
        return oth.EqualsAux(th);
      } else {
        return false;
      }
    }

    public bool EqualsAux(IMultiSet<object> other) {
      var s = other as IMultiSet<T>;
      if (s != null) {
        return Equals(s);
      } else {
        return false;
      }
    }

    public override int GetHashCode() {
      var hashCode = 1;
      if (occurrencesOfNull > 0) {
        var key = Dafny.Helpers.GetHashCode(default(T));
        key = (key << 3) | (key >> 29) ^ occurrencesOfNull.GetHashCode();
        hashCode = hashCode * (key + 3);
      }
      foreach (var kv in dict) {
        var key = Dafny.Helpers.GetHashCode(kv.Key);
        key = (key << 3) | (key >> 29) ^ kv.Value.GetHashCode();
        hashCode = hashCode * (key + 3);
      }
      return hashCode;
    }
    public override string ToString() {
      var s = "multiset{";
      var sep = "";
      for (var i = BigInteger.Zero; i < occurrencesOfNull; i++) {
        s += sep + Dafny.Helpers.ToString(default(T));
        sep = ", ";
      }
      foreach (var kv in dict) {
        var t = Dafny.Helpers.ToString(kv.Key);
        for (var i = BigInteger.Zero; i < kv.Value; i++) {
          s += sep + t;
          sep = ", ";
        }
      }
      return s + "}";
    }
    public static bool IsProperSubsetOf(IMultiSet<T> th, IMultiSet<T> other) {
      return th.Count < other.Count && IsSubsetOf(th, other);
    }
    public static bool IsSubsetOf(IMultiSet<T> th, IMultiSet<T> other) {
      var a = FromIMultiSet(th);
      var b = FromIMultiSet(other);
      if (b.occurrencesOfNull < a.occurrencesOfNull) {
        return false;
      }
      foreach (T t in a.dict.Keys) {
        if (b.dict.ContainsKey(t)) {
          if (b.dict[t] < a.dict[t]) {
            return false;
          }
        } else {
          if (a.dict[t] != BigInteger.Zero) {
            return false;
          }
        }
      }
      return true;
    }
    public static bool IsDisjointFrom(IMultiSet<T> th, IMultiSet<T> other) {
      foreach (T t in th.UniqueElements) {
        if (other.Contains(t)) {
          return false;
        }
      }
      return true;
    }

    public bool Contains<G>(G t) {
      return Select(t) != 0;
    }
    public BigInteger Select<G>(G t) {
      if (t == null) {
        return occurrencesOfNull;
      }
      BigInteger m;
      if (t is T && dict.TryGetValue((T)(object)t, out m)) {
        return m;
      } else {
        return BigInteger.Zero;
      }
    }
    public IMultiSet<T> Update<G>(G t, BigInteger i) {
      if (Select(t) == i) {
        return this;
      } else if (t == null) {
        var r = dict.ToBuilder();
        return new MultiSet<T>(r, i);
      } else {
        var r = dict.ToBuilder();
        r[(T)(object)t] = i;
        return new MultiSet<T>(r, occurrencesOfNull);
      }
    }
    public static IMultiSet<T> Union(IMultiSet<T> th, IMultiSet<T> other) {
      if (th.IsEmpty) {
        return other;
      } else if (other.IsEmpty) {
        return th;
      }
      var a = FromIMultiSet(th);
      var b = FromIMultiSet(other);
      var r = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      foreach (T t in a.dict.Keys) {
        BigInteger i;
        if (!r.TryGetValue(t, out i)) {
          i = BigInteger.Zero;
        }
        r[t] = i + a.dict[t];
      }
      foreach (T t in b.dict.Keys) {
        BigInteger i;
        if (!r.TryGetValue(t, out i)) {
          i = BigInteger.Zero;
        }
        r[t] = i + b.dict[t];
      }
      return new MultiSet<T>(r, a.occurrencesOfNull + b.occurrencesOfNull);
    }
    public static IMultiSet<T> Intersect(IMultiSet<T> th, IMultiSet<T> other) {
      if (th.IsEmpty) {
        return th;
      } else if (other.IsEmpty) {
        return other;
      }
      var a = FromIMultiSet(th);
      var b = FromIMultiSet(other);
      var r = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      foreach (T t in a.dict.Keys) {
        if (b.dict.ContainsKey(t)) {
          r.Add(t, a.dict[t] < b.dict[t] ? a.dict[t] : b.dict[t]);
        }
      }
      return new MultiSet<T>(r, a.occurrencesOfNull < b.occurrencesOfNull ? a.occurrencesOfNull : b.occurrencesOfNull);
    }
    public static IMultiSet<T> Difference(IMultiSet<T> th, IMultiSet<T> other) { // \result == this - other
      if (other.IsEmpty) {
        return th;
      }
      var a = FromIMultiSet(th);
      var b = FromIMultiSet(other);
      var r = ImmutableDictionary<T, BigInteger>.Empty.ToBuilder();
      foreach (T t in a.dict.Keys) {
        if (!b.dict.ContainsKey(t)) {
          r.Add(t, a.dict[t]);
        } else if (b.dict[t] < a.dict[t]) {
          r.Add(t, a.dict[t] - b.dict[t]);
        }
      }
      return new MultiSet<T>(r, b.occurrencesOfNull < a.occurrencesOfNull ? a.occurrencesOfNull - b.occurrencesOfNull : BigInteger.Zero);
    }

    public bool IsEmpty { get { return occurrencesOfNull == 0 && dict.IsEmpty; } }

    public int Count {
      get { return (int)ElementCount(); }
    }
    public long LongCount {
      get { return (long)ElementCount(); }
    }
    private BigInteger ElementCount() {
      // This is inefficient
      var c = occurrencesOfNull;
      foreach (var item in dict) {
        c += item.Value;
      }
      return c;
    }

    public IEnumerable<T> Elements {
      get {
        for (var i = BigInteger.Zero; i < occurrencesOfNull; i++) {
          yield return default(T);
        }
        foreach (var item in dict) {
          for (var i = BigInteger.Zero; i < item.Value; i++) {
            yield return item.Key;
          }
        }
      }
    }

    public IEnumerable<T> UniqueElements {
      get {
        if (!occurrencesOfNull.IsZero) {
          yield return default(T);
        }
        foreach (var key in dict.Keys) {
          if (dict[key] != 0) {
            yield return key;
          }
        }
      }
    }
  }

  public interface IMap<out U, out V> {
    int Count { get; }
    long LongCount { get; }
    ISet<U> Keys { get; }
    ISet<V> Values { get; }
    IEnumerable<IPair<U, V>> ItemEnumerable { get; }
    bool Contains<G>(G t);
    /// <summary>
    /// Returns "true" iff "this is IMap<object, object>" and "this" equals "other".
    /// </summary>
    bool EqualsObjObj(IMap<object, object> other);
    IMap<UU, VV> DowncastClone<UU, VV>(Func<U, UU> keyConverter, Func<V, VV> valueConverter);
  }

  public class Map<U, V> : IMap<U, V> {
    readonly ImmutableDictionary<U, V> dict;
    readonly bool hasNullKey;  // true when "null" is a key of the Map
    readonly V nullValue;  // if "hasNullKey", the value that "null" maps to

    private Map(ImmutableDictionary<U, V>.Builder d, bool hasNullKey, V nullValue) {
      dict = d.ToImmutable();
      this.hasNullKey = hasNullKey;
      this.nullValue = nullValue;
    }
    public static readonly Map<U, V> Empty = new Map<U, V>(ImmutableDictionary<U, V>.Empty.ToBuilder(), false, default(V));

    private Map(ImmutableDictionary<U, V> d, bool hasNullKey, V nullValue) {
      dict = d;
      this.hasNullKey = hasNullKey;
      this.nullValue = nullValue;
    }

    private static readonly TypeDescriptor<IMap<U, V>> _TYPE = new Dafny.TypeDescriptor<IMap<U, V>>(Empty);
    public static TypeDescriptor<IMap<U, V>> _TypeDescriptor() {
      return _TYPE;
    }

    public static Map<U, V> FromElements(params IPair<U, V>[] values) {
      var d = ImmutableDictionary<U, V>.Empty.ToBuilder();
      var hasNullKey = false;
      var nullValue = default(V);
      foreach (var p in values) {
        if (p.Car == null) {
          hasNullKey = true;
          nullValue = p.Cdr;
        } else {
          d[p.Car] = p.Cdr;
        }
      }
      return new Map<U, V>(d, hasNullKey, nullValue);
    }
    public static Map<U, V> FromCollection(IEnumerable<IPair<U, V>> values) {
      var d = ImmutableDictionary<U, V>.Empty.ToBuilder();
      var hasNullKey = false;
      var nullValue = default(V);
      foreach (var p in values) {
        if (p.Car == null) {
          hasNullKey = true;
          nullValue = p.Cdr;
        } else {
          d[p.Car] = p.Cdr;
        }
      }
      return new Map<U, V>(d, hasNullKey, nullValue);
    }
    public static Map<U, V> FromIMap(IMap<U, V> m) {
      return m as Map<U, V> ?? FromCollection(m.ItemEnumerable);
    }
    public IMap<UU, VV> DowncastClone<UU, VV>(Func<U, UU> keyConverter, Func<V, VV> valueConverter) {
      if (this is IMap<UU, VV> th) {
        return th;
      } else {
        var d = ImmutableDictionary<UU, VV>.Empty.ToBuilder();
        foreach (var item in this.dict) {
          var k = keyConverter(item.Key);
          var v = valueConverter(item.Value);
          d.Add(k, v);
        }
        return new Map<UU, VV>(d, this.hasNullKey, (VV)(object)this.nullValue);
      }
    }
    public int Count {
      get { return dict.Count + (hasNullKey ? 1 : 0); }
    }
    public long LongCount {
      get { return dict.Count + (hasNullKey ? 1 : 0); }
    }

    public bool Equals(IMap<U, V> other) {
      if (other == null || LongCount != other.LongCount) {
        return false;
      } else if (this == other) {
        return true;
      }
      if (hasNullKey) {
        if (!other.Contains(default(U)) || !object.Equals(nullValue, Select(other, default(U)))) {
          return false;
        }
      }
      foreach (var item in dict) {
        if (!other.Contains(item.Key) || !object.Equals(item.Value, Select(other, item.Key))) {
          return false;
        }
      }
      return true;
    }
    public bool EqualsObjObj(IMap<object, object> other) {
      if (!(this is IMap<object, object>) || other == null || LongCount != other.LongCount) {
        return false;
      } else if (this == other) {
        return true;
      }
      var oth = Map<object, object>.FromIMap(other);
      if (hasNullKey) {
        if (!oth.Contains(default(U)) || !object.Equals(nullValue, Map<object, object>.Select(oth, default(U)))) {
          return false;
        }
      }
      foreach (var item in dict) {
        if (!other.Contains(item.Key) || !object.Equals(item.Value, Map<object, object>.Select(oth, item.Key))) {
          return false;
        }
      }
      return true;
    }
    public override bool Equals(object other) {
      // See comment in Set.Equals
      var m = other as IMap<U, V>;
      if (m != null) {
        return Equals(m);
      }
      var imapoo = other as IMap<object, object>;
      if (imapoo != null) {
        return EqualsObjObj(imapoo);
      } else {
        return false;
      }
    }

    public override int GetHashCode() {
      var hashCode = 1;
      if (hasNullKey) {
        var key = Dafny.Helpers.GetHashCode(default(U));
        key = (key << 3) | (key >> 29) ^ Dafny.Helpers.GetHashCode(nullValue);
        hashCode = hashCode * (key + 3);
      }
      foreach (var kv in dict) {
        var key = Dafny.Helpers.GetHashCode(kv.Key);
        key = (key << 3) | (key >> 29) ^ Dafny.Helpers.GetHashCode(kv.Value);
        hashCode = hashCode * (key + 3);
      }
      return hashCode;
    }
    public override string ToString() {
      var s = "map[";
      var sep = "";
      if (hasNullKey) {
        s += sep + Dafny.Helpers.ToString(default(U)) + " := " + Dafny.Helpers.ToString(nullValue);
        sep = ", ";
      }
      foreach (var kv in dict) {
        s += sep + Dafny.Helpers.ToString(kv.Key) + " := " + Dafny.Helpers.ToString(kv.Value);
        sep = ", ";
      }
      return s + "]";
    }
    public bool Contains<G>(G u) {
      return u == null ? hasNullKey : u is U && dict.ContainsKey((U)(object)u);
    }
    public static V Select(IMap<U, V> th, U index) {
      // the following will throw an exception if "index" in not a key of the map
      var m = FromIMap(th);
      return index == null && m.hasNullKey ? m.nullValue : m.dict[index];
    }
    public static IMap<U, V> Update(IMap<U, V> th, U index, V val) {
      var m = FromIMap(th);
      var d = m.dict.ToBuilder();
      if (index == null) {
        return new Map<U, V>(d, true, val);
      } else {
        d[index] = val;
        return new Map<U, V>(d, m.hasNullKey, m.nullValue);
      }
    }

    public static IMap<U, V> Merge(IMap<U, V> th, IMap<U, V> other) {
      var a = FromIMap(th);
      var b = FromIMap(other);
      ImmutableDictionary<U, V> d = a.dict.SetItems(b.dict);
      return new Map<U, V>(d, a.hasNullKey || b.hasNullKey, b.hasNullKey ? b.nullValue : a.nullValue);
    }

    public static IMap<U, V> Subtract(IMap<U, V> th, ISet<U> keys) {
      var a = FromIMap(th);
      ImmutableDictionary<U, V> d = a.dict.RemoveRange(keys.Elements);
      return new Map<U, V>(d, a.hasNullKey && !keys.Contains<object>(null), a.nullValue);
    }

    public ISet<U> Keys {
      get {
        if (hasNullKey) {
          return Dafny.Set<U>.FromCollectionPlusOne(dict.Keys, default(U));
        } else {
          return Dafny.Set<U>.FromCollection(dict.Keys);
        }
      }
    }
    public ISet<V> Values {
      get {
        if (hasNullKey) {
          return Dafny.Set<V>.FromCollectionPlusOne(dict.Values, nullValue);
        } else {
          return Dafny.Set<V>.FromCollection(dict.Values);
        }
      }
    }

    public IEnumerable<IPair<U, V>> ItemEnumerable {
      get {
        if (hasNullKey) {
          yield return new Pair<U, V>(default(U), nullValue);
        }
        foreach (KeyValuePair<U, V> kvp in dict) {
          yield return new Pair<U, V>(kvp.Key, kvp.Value);
        }
      }
    }

    public static ISet<_System.Tuple2<U, V>> Items(IMap<U, V> m) {
      var result = new HashSet<_System.Tuple2<U, V>>();
      foreach (var item in m.ItemEnumerable) {
        result.Add(_System.Tuple2<U, V>.create(item.Car, item.Cdr));
      }
      return Dafny.Set<_System.Tuple2<U, V>>.FromCollection(result);
    }
  }

  public interface ISequence<out T> {
    long LongCount { get; }
    int Count { get; }
    T[] Elements { get; }
    IEnumerable<T> UniqueElements { get; }
    T Select(ulong index);
    T Select(long index);
    T Select(uint index);
    T Select(int index);
    T Select(BigInteger index);
    bool Contains<G>(G g);
    ISequence<T> Take(long m);
    ISequence<T> Take(ulong n);
    ISequence<T> Take(BigInteger n);
    ISequence<T> Drop(long m);
    ISequence<T> Drop(ulong n);
    ISequence<T> Drop(BigInteger n);
    ISequence<T> Subsequence(long lo, long hi);
    ISequence<T> Subsequence(long lo, ulong hi);
    ISequence<T> Subsequence(long lo, BigInteger hi);
    ISequence<T> Subsequence(ulong lo, long hi);
    ISequence<T> Subsequence(ulong lo, ulong hi);
    ISequence<T> Subsequence(ulong lo, BigInteger hi);
    ISequence<T> Subsequence(BigInteger lo, long hi);
    ISequence<T> Subsequence(BigInteger lo, ulong hi);
    ISequence<T> Subsequence(BigInteger lo, BigInteger hi);
    bool EqualsAux(ISequence<object> other);
    ISequence<U> DowncastClone<U>(Func<T, U> converter);
  }

  public abstract class Sequence<T> : ISequence<T> {
    public static readonly ISequence<T> Empty = new ArraySequence<T>(new T[0]);

    private static readonly TypeDescriptor<ISequence<T>> _TYPE = new Dafny.TypeDescriptor<ISequence<T>>(Empty);
    public static TypeDescriptor<ISequence<T>> _TypeDescriptor() {
      return _TYPE;
    }

    public static ISequence<T> Create(BigInteger length, System.Func<BigInteger, T> init) {
      var len = (int)length;
      var values = new T[len];
      for (int i = 0; i < len; i++) {
        values[i] = init(new BigInteger(i));
      }
      return new ArraySequence<T>(values);
    }
    public static ISequence<T> FromArray(T[] values) {
      return new ArraySequence<T>(values);
    }
    public static ISequence<T> FromElements(params T[] values) {
      return new ArraySequence<T>(values);
    }
    public static ISequence<char> FromString(string s) {
      return new ArraySequence<char>(s.ToCharArray());
    }
    public ISequence<U> DowncastClone<U>(Func<T, U> converter) {
      if (this is ISequence<U> th) {
        return th;
      } else {
        var values = new U[this.LongCount];
        for (long i = 0; i < this.LongCount; i++) {
          var val = converter(this.Select(i));
          values[i] = val;
        }
        return new ArraySequence<U>(values);
      }
    }
    public static ISequence<T> Update(ISequence<T> sequence, long index, T t) {
      T[] tmp = (T[])sequence.Elements.Clone();
      tmp[index] = t;
      return new ArraySequence<T>(tmp);
    }
    public static ISequence<T> Update(ISequence<T> sequence, ulong index, T t) {
      return Update(sequence, (long)index, t);
    }
    public static ISequence<T> Update(ISequence<T> sequence, BigInteger index, T t) {
      return Update(sequence, (long)index, t);
    }
    public static bool EqualUntil(ISequence<T> left, ISequence<T> right, int n) {
      T[] leftElmts = left.Elements, rightElmts = right.Elements;
      for (int i = 0; i < n; i++) {
        if (!object.Equals(leftElmts[i], rightElmts[i]))
          return false;
      }
      return true;
    }
    public static bool IsPrefixOf(ISequence<T> left, ISequence<T> right) {
      int n = left.Elements.Length;
      return n <= right.Elements.Length && EqualUntil(left, right, n);
    }
    public static bool IsProperPrefixOf(ISequence<T> left, ISequence<T> right) {
      int n = left.Elements.Length;
      return n < right.Elements.Length && EqualUntil(left, right, n);
    }
    public static ISequence<T> Concat(ISequence<T> left, ISequence<T> right) {
      if (left.Count == 0) {
        return right;
      }
      if (right.Count == 0) {
        return left;
      }
      return new ConcatSequence<T>(left, right);
    }
    // Make Count a public abstract instead of LongCount, since the "array size is limited to a total of 4 billion
    // elements, and to a maximum index of 0X7FEFFFFF". Therefore, as a protection, limit this to int32.
    // https://docs.microsoft.com/en-us/dotnet/api/system.array
    public abstract int Count { get; }
    public long LongCount {
      get { return Count; }
    }
    // ImmutableElements cannot be public in the interface since ImmutableArray<T> leads to a
    // "covariant type T occurs in invariant position" error. There do not appear to be interfaces for ImmutableArray<T>
    // that resolve this.
    protected abstract ImmutableArray<T> ImmutableElements { get; }

    public T[] Elements {
      get { return ImmutableElements.ToArray(); }
    }
    public IEnumerable<T> UniqueElements {
      get {
        var st = Set<T>.FromCollection(ImmutableElements);
        return st.Elements;
      }
    }

    public T Select(ulong index) {
      return ImmutableElements[checked((int)index)];
    }
    public T Select(long index) {
      return ImmutableElements[checked((int)index)];
    }
    public T Select(uint index) {
      return ImmutableElements[checked((int)index)];
    }
    public T Select(int index) {
      return ImmutableElements[index];
    }
    public T Select(BigInteger index) {
      return ImmutableElements[(int)index];
    }
    public bool Equals(ISequence<T> other) {
      int n = ImmutableElements.Length;
      return n == other.Elements.Length && EqualUntil(this, other, n);
    }
    public override bool Equals(object other) {
      if (other is ISequence<T>) {
        return Equals((ISequence<T>)other);
      }
      var th = this as ISequence<object>;
      var oth = other as ISequence<object>;
      if (th != null && oth != null) {
        // see explanation in Set.Equals
        return oth.EqualsAux(th);
      } else {
        return false;
      }
    }
    public bool EqualsAux(ISequence<object> other) {
      var s = other as ISequence<T>;
      if (s != null) {
        return Equals(s);
      } else {
        return false;
      }
    }
    public override int GetHashCode() {
      ImmutableArray<T> elmts = ImmutableElements;
      // https://devblogs.microsoft.com/dotnet/please-welcome-immutablearrayt/
      if (elmts.IsDefaultOrEmpty)
        return 0;
      var hashCode = 0;
      for (var i = 0; i < elmts.Length; i++) {
        hashCode = (hashCode << 3) | (hashCode >> 29) ^ Dafny.Helpers.GetHashCode(elmts[i]);
      }
      return hashCode;
    }
    public override string ToString() {
      // This is required because (ImmutableElements is ImmutableArray<char>) is not a valid type check
      var typeCheckTmp = new T[0];
      ImmutableArray<T> elmts = ImmutableElements;
      if (typeCheckTmp is char[]) {
        var s = "";
        foreach (var t in elmts) {
          s += t.ToString();
        }
        return s;
      } else {
        var s = "[";
        var sep = "";
        foreach (var t in elmts) {
          s += sep + Dafny.Helpers.ToString(t);
          sep = ", ";
        }
        return s + "]";
      }
    }
    public bool Contains<G>(G g) {
      if (g == null || g is T) {
        var t = (T)(object)g;
        return ImmutableElements.Contains(t);
      }
      return false;
    }
    public ISequence<T> Take(long m) {
      if (ImmutableElements.Length == m)
        return this;
      int length = checked((int)m);
      T[] tmp = new T[length];
      ImmutableElements.CopyTo(0, tmp, 0, length);
      return new ArraySequence<T>(tmp);
    }
    public ISequence<T> Take(ulong n) {
      return Take((long)n);
    }
    public ISequence<T> Take(BigInteger n) {
      return Take((long)n);
    }
    public ISequence<T> Drop(long m) {
      int startingElement = checked((int)m);
      if (startingElement == 0)
        return this;
      int length = ImmutableElements.Length - startingElement;
      T[] tmp = new T[length];
      ImmutableElements.CopyTo(startingElement, tmp, 0, length);
      return new ArraySequence<T>(tmp);
    }
    public ISequence<T> Drop(ulong n) {
      return Drop((long)n);
    }
    public ISequence<T> Drop(BigInteger n) {
      if (n.IsZero)
        return this;
      return Drop((long)n);
    }
    public ISequence<T> Subsequence(long lo, long hi) {
      if (lo == 0 && hi == ImmutableElements.Length) {
        return this;
      }
      int startingIndex = checked((int)lo);
      int endingIndex = checked((int)hi);
      var length = endingIndex - startingIndex;
      T[] tmp = new T[length];
      ImmutableElements.CopyTo(startingIndex, tmp, 0, length);
      return new ArraySequence<T>(tmp);
    }
    public ISequence<T> Subsequence(long lo, ulong hi) {
      return Subsequence(lo, (long)hi);
    }
    public ISequence<T> Subsequence(long lo, BigInteger hi) {
      return Subsequence(lo, (long)hi);
    }
    public ISequence<T> Subsequence(ulong lo, long hi) {
      return Subsequence((long)lo, hi);
    }
    public ISequence<T> Subsequence(ulong lo, ulong hi) {
      return Subsequence((long)lo, (long)hi);
    }
    public ISequence<T> Subsequence(ulong lo, BigInteger hi) {
      return Subsequence((long)lo, (long)hi);
    }
    public ISequence<T> Subsequence(BigInteger lo, long hi) {
      return Subsequence((long)lo, hi);
    }
    public ISequence<T> Subsequence(BigInteger lo, ulong hi) {
      return Subsequence((long)lo, (long)hi);
    }
    public ISequence<T> Subsequence(BigInteger lo, BigInteger hi) {
      return Subsequence((long)lo, (long)hi);
    }
  }

  internal class ArraySequence<T> : Sequence<T> {
    private readonly ImmutableArray<T> elmts;

    internal ArraySequence(ImmutableArray<T> ee) {
      elmts = ee;
    }
    internal ArraySequence(T[] ee) {
      elmts = ImmutableArray.Create<T>(ee);
    }

    protected override ImmutableArray<T> ImmutableElements {
      get {
        return elmts;
      }
    }
    public override int Count {
      get {
        return elmts.Length;
      }
    }
  }

  internal class ConcatSequence<T> : Sequence<T> {
    // INVARIANT: Either left != null, right != null, and elmts's underlying array == null or
    // left == null, right == null, and elmts's underlying array != null
    private ISequence<T> left, right;
    private ImmutableArray<T> elmts;
    private readonly int count;

    internal ConcatSequence(ISequence<T> left, ISequence<T> right) {
      this.left = left;
      this.right = right;
      this.count = left.Count + right.Count;
    }

    protected override ImmutableArray<T> ImmutableElements {
      get {
        // IsDefault returns true if the underlying array is a null reference
        // https://devblogs.microsoft.com/dotnet/please-welcome-immutablearrayt/
        if (elmts.IsDefault) {
          elmts = ComputeElements();
          // We don't need the original sequences anymore; let them be
          // garbage-collected
          left = null;
          right = null;
        }
        return elmts;
      }
    }

    public override int Count {
      get {
        return count;
      }
    }

    private ImmutableArray<T> ComputeElements() {
      // Traverse the tree formed by all descendants which are ConcatSequences
      var ansBuilder = ImmutableArray.CreateBuilder<T>();
      var toVisit = new Stack<ISequence<T>>();
      toVisit.Push(right);
      toVisit.Push(left);

      while (toVisit.Count != 0) {
        var seq = toVisit.Pop();
        var cs = seq as ConcatSequence<T>;
        if (cs != null && cs.elmts.IsDefault) {
          toVisit.Push(cs.right);
          toVisit.Push(cs.left);
        } else {
          var array = seq.Elements;
          ansBuilder.AddRange(array);
        }
      }
      return ansBuilder.ToImmutable();
    }
  }

  public interface IPair<out A, out B> {
    A Car { get; }
    B Cdr { get; }
  }

  public class Pair<A, B> : IPair<A, B> {
    private A car;
    private B cdr;
    public A Car { get { return car; } }
    public B Cdr { get { return cdr; } }
    public Pair(A a, B b) {
      this.car = a;
      this.cdr = b;
    }
  }

  public class TypeDescriptor<T> {
    private readonly T initValue;
    public TypeDescriptor(T initValue) {
      this.initValue = initValue;
    }
    public T Default() {
      return initValue;
    }
  }

  public partial class Helpers {
    public static int GetHashCode<G>(G g) {
      return g == null ? 1001 : g.GetHashCode();
    }

    public static int ToIntChecked(BigInteger i, string msg) {
      if (i > Int32.MaxValue || i < Int32.MinValue) {
        if (msg == null) msg = "value out of range for a 32-bit int";
        throw new HaltException(msg + ": " + i);
      }
      return (int)i;
    }
    public static int ToIntChecked(long i, string msg) {
      if (i > Int32.MaxValue || i < Int32.MinValue) {
        if (msg == null) msg = "value out of range for a 32-bit int";
        throw new HaltException(msg + ": " + i);
      }
      return (int)i;
    }
    public static int ToIntChecked(int i, string msg) {
      return i;
    }

    public static string ToString<G>(G g) {
      if (g == null) {
        return "null";
      } else if (g is bool) {
        return (bool)(object)g ? "true" : "false";  // capitalize boolean literals like in Dafny
      } else {
        return g.ToString();
      }
    }
    public static void Print<G>(G g) {
      System.Console.Write(ToString(g));
    }

    public static readonly TypeDescriptor<bool> BOOL = new TypeDescriptor<bool>(false);
    public static readonly TypeDescriptor<char> CHAR = new TypeDescriptor<char>('D');  // See CharType.DefaultValue in Dafny source code
    public static readonly TypeDescriptor<BigInteger> INT = new TypeDescriptor<BigInteger>(BigInteger.Zero);
    public static readonly TypeDescriptor<BigRational> REAL = new TypeDescriptor<BigRational>(BigRational.ZERO);
    public static readonly TypeDescriptor<byte> UINT8 = new TypeDescriptor<byte>(0);
    public static readonly TypeDescriptor<ushort> UINT16 = new TypeDescriptor<ushort>(0);
    public static readonly TypeDescriptor<uint> UINT32 = new TypeDescriptor<uint>(0);
    public static readonly TypeDescriptor<ulong> UINT64 = new TypeDescriptor<ulong>(0);

    public static TypeDescriptor<T> NULL<T>() where T : class {
      return new TypeDescriptor<T>(null);
    }

    public static TypeDescriptor<A[]> ARRAY<A>() {
      return new TypeDescriptor<A[]>(new A[0]);
    }

    public static bool Quantifier<T>(IEnumerable<T> vals, bool frall, System.Predicate<T> pred) {
      foreach (var u in vals) {
        if (pred(u) != frall) { return !frall; }
      }
      return frall;
    }
    // Enumerating other collections
    public static IEnumerable<bool> AllBooleans() {
      yield return false;
      yield return true;
    }
    public static IEnumerable<char> AllChars() {
      for (int i = 0; i < 0x10000; i++) {
        yield return (char)i;
      }
    }
    public static IEnumerable<BigInteger> AllIntegers() {
      yield return new BigInteger(0);
      for (var j = new BigInteger(1); ; j++) {
        yield return j;
        yield return -j;
      }
    }
    public static IEnumerable<BigInteger> IntegerRange(Nullable<BigInteger> lo, Nullable<BigInteger> hi) {
      if (lo == null) {
        for (var j = (BigInteger)hi; true;) {
          j--;
          yield return j;
        }
      } else if (hi == null) {
        for (var j = (BigInteger)lo; true; j++) {
          yield return j;
        }
      } else {
        for (var j = (BigInteger)lo; j < hi; j++) {
          yield return j;
        }
      }
    }
    public static IEnumerable<T> SingleValue<T>(T e) {
      yield return e;
    }
    // pre: b != 0
    // post: result == a/b, as defined by Euclidean Division (http://en.wikipedia.org/wiki/Modulo_operation)
    public static sbyte EuclideanDivision_sbyte(sbyte a, sbyte b) {
      return (sbyte)EuclideanDivision_int(a, b);
    }
    public static short EuclideanDivision_short(short a, short b) {
      return (short)EuclideanDivision_int(a, b);
    }
    public static int EuclideanDivision_int(int a, int b) {
      if (0 <= a) {
        if (0 <= b) {
          // +a +b: a/b
          return (int)(((uint)(a)) / ((uint)(b)));
        } else {
          // +a -b: -(a/(-b))
          return -((int)(((uint)(a)) / ((uint)(unchecked(-b)))));
        }
      } else {
        if (0 <= b) {
          // -a +b: -((-a-1)/b) - 1
          return -((int)(((uint)(-(a + 1))) / ((uint)(b)))) - 1;
        } else {
          // -a -b: ((-a-1)/(-b)) + 1
          return ((int)(((uint)(-(a + 1))) / ((uint)(unchecked(-b))))) + 1;
        }
      }
    }
    public static long EuclideanDivision_long(long a, long b) {
      if (0 <= a) {
        if (0 <= b) {
          // +a +b: a/b
          return (long)(((ulong)(a)) / ((ulong)(b)));
        } else {
          // +a -b: -(a/(-b))
          return -((long)(((ulong)(a)) / ((ulong)(unchecked(-b)))));
        }
      } else {
        if (0 <= b) {
          // -a +b: -((-a-1)/b) - 1
          return -((long)(((ulong)(-(a + 1))) / ((ulong)(b)))) - 1;
        } else {
          // -a -b: ((-a-1)/(-b)) + 1
          return ((long)(((ulong)(-(a + 1))) / ((ulong)(unchecked(-b))))) + 1;
        }
      }
    }
    public static BigInteger EuclideanDivision(BigInteger a, BigInteger b) {
      if (0 <= a.Sign) {
        if (0 <= b.Sign) {
          // +a +b: a/b
          return BigInteger.Divide(a, b);
        } else {
          // +a -b: -(a/(-b))
          return BigInteger.Negate(BigInteger.Divide(a, BigInteger.Negate(b)));
        }
      } else {
        if (0 <= b.Sign) {
          // -a +b: -((-a-1)/b) - 1
          return BigInteger.Negate(BigInteger.Divide(BigInteger.Negate(a) - 1, b)) - 1;
        } else {
          // -a -b: ((-a-1)/(-b)) + 1
          return BigInteger.Divide(BigInteger.Negate(a) - 1, BigInteger.Negate(b)) + 1;
        }
      }
    }
    // pre: b != 0
    // post: result == a%b, as defined by Euclidean Division (http://en.wikipedia.org/wiki/Modulo_operation)
    public static sbyte EuclideanModulus_sbyte(sbyte a, sbyte b) {
      return (sbyte)EuclideanModulus_int(a, b);
    }
    public static short EuclideanModulus_short(short a, short b) {
      return (short)EuclideanModulus_int(a, b);
    }
    public static int EuclideanModulus_int(int a, int b) {
      uint bp = (0 <= b) ? (uint)b : (uint)(unchecked(-b));
      if (0 <= a) {
        // +a: a % b'
        return (int)(((uint)a) % bp);
      } else {
        // c = ((-a) % b')
        // -a: b' - c if c > 0
        // -a: 0 if c == 0
        uint c = ((uint)(unchecked(-a))) % bp;
        return (int)(c == 0 ? c : bp - c);
      }
    }
    public static long EuclideanModulus_long(long a, long b) {
      ulong bp = (0 <= b) ? (ulong)b : (ulong)(unchecked(-b));
      if (0 <= a) {
        // +a: a % b'
        return (long)(((ulong)a) % bp);
      } else {
        // c = ((-a) % b')
        // -a: b' - c if c > 0
        // -a: 0 if c == 0
        ulong c = ((ulong)(unchecked(-a))) % bp;
        return (long)(c == 0 ? c : bp - c);
      }
    }
    public static BigInteger EuclideanModulus(BigInteger a, BigInteger b) {
      var bp = BigInteger.Abs(b);
      if (0 <= a.Sign) {
        // +a: a % b'
        return BigInteger.Remainder(a, bp);
      } else {
        // c = ((-a) % b')
        // -a: b' - c if c > 0
        // -a: 0 if c == 0
        var c = BigInteger.Remainder(BigInteger.Negate(a), bp);
        return c.IsZero ? c : BigInteger.Subtract(bp, c);
      }
    }

    public static U CastConverter<T, U>(T t) {
      return (U)(object)t;
    }

    public static Sequence<T> SeqFromArray<T>(T[] array) {
      return new ArraySequence<T>((T[])array.Clone());
    }
    // In .NET version 4.5, it is possible to mark a method with "AggressiveInlining", which says to inline the
    // method if possible.  Method "ExpressionSequence" would be a good candidate for it:
    // [System.Runtime.CompilerServices.MethodImpl(System.Runtime.CompilerServices.MethodImplOptions.AggressiveInlining)]
    public static U ExpressionSequence<T, U>(T t, U u) {
      return u;
    }

    public static U Let<T, U>(T t, Func<T, U> f) {
      return f(t);
    }

    public static A Id<A>(A a) {
      return a;
    }

    public static void WithHaltHandling(Action action) {
      try {
        action();
      } catch (HaltException e) {
        Console.WriteLine("[Program halted] " + e.Message);
      }
    }
  }

  public class BigOrdinal {
    public static bool IsLimit(BigInteger ord) {
      return ord == 0;
    }
    public static bool IsSucc(BigInteger ord) {
      return 0 < ord;
    }
    public static BigInteger Offset(BigInteger ord) {
      return ord;
    }
    public static bool IsNat(BigInteger ord) {
      return true;  // at run time, every ORDINAL is a natural number
    }
  }

  public struct BigRational {
    public static readonly BigRational ZERO = new BigRational(0);

    // We need to deal with the special case "num == 0 && den == 0", because
    // that's what C#'s default struct constructor will produce for BigRational. :(
    // To deal with it, we ignore "den" when "num" is 0.
    BigInteger num, den;  // invariant 1 <= den || (num == 0 && den == 0)
    public override string ToString() {
      int log10;
      if (num.IsZero || den.IsOne) {
        return string.Format("{0}.0", num);
      } else if (IsPowerOf10(den, out log10)) {
        string sign;
        string digits;
        if (num.Sign < 0) {
          sign = "-"; digits = (-num).ToString();
        } else {
          sign = ""; digits = num.ToString();
        }
        if (log10 < digits.Length) {
          var n = digits.Length - log10;
          return string.Format("{0}{1}.{2}", sign, digits.Substring(0, n), digits.Substring(n));
        } else {
          return string.Format("{0}0.{1}{2}", sign, new string('0', log10 - digits.Length), digits);
        }
      } else {
        return string.Format("({0}.0 / {1}.0)", num, den);
      }
    }
    public bool IsPowerOf10(BigInteger x, out int log10) {
      log10 = 0;
      if (x.IsZero) {
        return false;
      }
      while (true) {  // invariant: x != 0 && x * 10^log10 == old(x)
        if (x.IsOne) {
          return true;
        } else if (x % 10 == 0) {
          log10++;
          x /= 10;
        } else {
          return false;
        }
      }
    }
    public BigRational(int n) {
      num = new BigInteger(n);
      den = BigInteger.One;
    }
    public BigRational(BigInteger n, BigInteger d) {
      // requires 1 <= d
      num = n;
      den = d;
    }
    public BigInteger ToBigInteger() {
      if (num.IsZero || den.IsOne) {
        return num;
      } else if (0 < num.Sign) {
        return num / den;
      } else {
        return (num - den + 1) / den;
      }
    }
    /// <summary>
    /// Returns values such that aa/dd == a and bb/dd == b.
    /// </summary>
    private static void Normalize(BigRational a, BigRational b, out BigInteger aa, out BigInteger bb, out BigInteger dd) {
      if (a.num.IsZero) {
        aa = a.num;
        bb = b.num;
        dd = b.den;
      } else if (b.num.IsZero) {
        aa = a.num;
        dd = a.den;
        bb = b.num;
      } else {
        var gcd = BigInteger.GreatestCommonDivisor(a.den, b.den);
        var xx = a.den / gcd;
        var yy = b.den / gcd;
        // We now have a == a.num / (xx * gcd) and b == b.num / (yy * gcd).
        aa = a.num * yy;
        bb = b.num * xx;
        dd = a.den * yy;
      }
    }
    public int CompareTo(BigRational that) {
      // simple things first
      int asign = this.num.Sign;
      int bsign = that.num.Sign;
      if (asign < 0 && 0 <= bsign) {
        return -1;
      } else if (asign <= 0 && 0 < bsign) {
        return -1;
      } else if (bsign < 0 && 0 <= asign) {
        return 1;
      } else if (bsign <= 0 && 0 < asign) {
        return 1;
      }
      BigInteger aa, bb, dd;
      Normalize(this, that, out aa, out bb, out dd);
      return aa.CompareTo(bb);
    }
    public int Sign {
      get {
        return num.Sign;
      }
    }
    public override int GetHashCode() {
      return num.GetHashCode() + 29 * den.GetHashCode();
    }
    public override bool Equals(object obj) {
      if (obj is BigRational) {
        return this == (BigRational)obj;
      } else {
        return false;
      }
    }
    public static bool operator ==(BigRational a, BigRational b) {
      return a.CompareTo(b) == 0;
    }
    public static bool operator !=(BigRational a, BigRational b) {
      return a.CompareTo(b) != 0;
    }
    public static bool operator >(BigRational a, BigRational b) {
      return a.CompareTo(b) > 0;
    }
    public static bool operator >=(BigRational a, BigRational b) {
      return a.CompareTo(b) >= 0;
    }
    public static bool operator <(BigRational a, BigRational b) {
      return a.CompareTo(b) < 0;
    }
    public static bool operator <=(BigRational a, BigRational b) {
      return a.CompareTo(b) <= 0;
    }
    public static BigRational operator +(BigRational a, BigRational b) {
      BigInteger aa, bb, dd;
      Normalize(a, b, out aa, out bb, out dd);
      return new BigRational(aa + bb, dd);
    }
    public static BigRational operator -(BigRational a, BigRational b) {
      BigInteger aa, bb, dd;
      Normalize(a, b, out aa, out bb, out dd);
      return new BigRational(aa - bb, dd);
    }
    public static BigRational operator -(BigRational a) {
      return new BigRational(-a.num, a.den);
    }
    public static BigRational operator *(BigRational a, BigRational b) {
      return new BigRational(a.num * b.num, a.den * b.den);
    }
    public static BigRational operator /(BigRational a, BigRational b) {
      // Compute the reciprocal of b
      BigRational bReciprocal;
      if (0 < b.num.Sign) {
        bReciprocal = new BigRational(b.den, b.num);
      } else {
        // this is the case b.num < 0
        bReciprocal = new BigRational(-b.den, -b.num);
      }
      return a * bReciprocal;
    }
  }

  public class HaltException : Exception {
    public HaltException(object message) : base(message.ToString()) {
    }
  }
}

namespace @_System {
  public class Tuple2<T0, T1> {
    public readonly T0 _0;
    public readonly T1 _1;
    public Tuple2(T0 _0, T1 _1) {
      this._0 = _0;
      this._1 = _1;
    }
    public override bool Equals(object other) {
      var oth = other as _System.Tuple2<T0, T1>;
      return oth != null && object.Equals(this._0, oth._0) && object.Equals(this._1, oth._1);
    }
    public override int GetHashCode() {
      ulong hash = 5381;
      hash = ((hash << 5) + hash) + 0;
      hash = ((hash << 5) + hash) + ((ulong)Dafny.Helpers.GetHashCode(this._0));
      hash = ((hash << 5) + hash) + ((ulong)Dafny.Helpers.GetHashCode(this._1));
      return (int)hash;
    }
    public override string ToString() {
      string s = "";
      s += "(";
      s += Dafny.Helpers.ToString(this._0);
      s += ", ";
      s += Dafny.Helpers.ToString(this._1);
      s += ")";
      return s;
    }
    public static Tuple2<T0, T1> Default(T0 _default_T0, T1 _default_T1) {
      return create(_default_T0, _default_T1);
    }
    public static Dafny.TypeDescriptor<_System.Tuple2<T0, T1>> _TypeDescriptor(Dafny.TypeDescriptor<T0> _td_T0, Dafny.TypeDescriptor<T1> _td_T1) {
      return new Dafny.TypeDescriptor<_System.Tuple2<T0, T1>>(_System.Tuple2<T0, T1>.Default(_td_T0.Default(), _td_T1.Default()));
    }
    public static Tuple2<T0, T1> create(T0 _0, T1 _1) {
      return new Tuple2<T0, T1>(_0, _1);
    }
    public bool is____hMake2 { get { return true; } }
    public T0 dtor__0 {
      get {
        return this._0;
      }
    }
    public T1 dtor__1 {
      get {
        return this._1;
      }
    }
  }

} // end of namespace _System
namespace Dafny {
  internal class ArrayHelpers {
    public static T[] InitNewArray1<T>(T z, BigInteger size0) {
      int s0 = (int)size0;
      T[] a = new T[s0];
      for (int i0 = 0; i0 < s0; i0++) {
        a[i0] = z;
      }
      return a;
    }
  }
} // end of namespace Dafny
namespace _System {


  public partial class nat {
    private static readonly Dafny.TypeDescriptor<BigInteger> _TYPE = new Dafny.TypeDescriptor<BigInteger>(BigInteger.Zero);
    public static Dafny.TypeDescriptor<BigInteger> _TypeDescriptor() {
      return _TYPE;
    }
  }








  public class Tuple0 {
    public Tuple0() {
    }
    public override bool Equals(object other) {
      var oth = other as _System.Tuple0;
      return oth != null;
    }
    public override int GetHashCode() {
      ulong hash = 5381;
      hash = ((hash << 5) + hash) + 0;
      return (int) hash;
    }
    public override string ToString() {
      return "()";
    }
    private static readonly Tuple0 theDefault = create();
    public static Tuple0 Default() {
      return theDefault;
    }
    private static readonly Dafny.TypeDescriptor<_System.Tuple0> _TYPE = new Dafny.TypeDescriptor<_System.Tuple0>(_System.Tuple0.Default());
    public static Dafny.TypeDescriptor<_System.Tuple0> _TypeDescriptor() {
      return _TYPE;
    }
    public static Tuple0 create() {
      return new Tuple0();
    }
    public static System.Collections.Generic.IEnumerable<Tuple0> AllSingletonConstructors {
      get {
        yield return Tuple0.create();
      }
    }
  }
} // end of namespace _System
namespace Seqs_Compile {

} // end of namespace Seqs_Compile
namespace PrivateDLL_Compile {


  public partial class PrivateNode<T> {
    public PrivateNode() {
      this.L = (PrivateDLL_Compile.PrivateNode<T>)null;
      this.R = (PrivateDLL_Compile.PrivateNode<T>)null;
      this.payload = default(T);
    }
    public PrivateDLL_Compile.PrivateNode<T> L;
    public PrivateDLL_Compile.PrivateNode<T> R;
    public T payload;
    public void __ctor(T p)
    {
      (this).payload = p;
    }
  }

  public partial class PrivateDoublyLinkedList<T> {
    public PrivateDoublyLinkedList() {
      this.head = (PrivateDLL_Compile.PrivateNode<T>)null;
      this.tail = (PrivateDLL_Compile.PrivateNode<T>)null;
    }
    public PrivateDLL_Compile.PrivateNode<T> head;
    public PrivateDLL_Compile.PrivateNode<T> tail;
    public void __ctor()
    {
      (this).head = (PrivateDLL_Compile.PrivateNode<T>)null;
      (this).tail = (PrivateDLL_Compile.PrivateNode<T>)null;
    }
    public bool IsEmpty()
    {
      bool b = false;
      b = ((this.head) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) && ((this.tail) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null));
      return b;
    }
    public void Remove(PrivateDLL_Compile.PrivateNode<T> x)
    {
      if (((x.L) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) && ((x.R) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null))) {
        (this).head = (PrivateDLL_Compile.PrivateNode<T>)null;
        (this).tail = (PrivateDLL_Compile.PrivateNode<T>)null;
      } else if ((x.L) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) {
        var _obj0 = x.R;
        _obj0.L = (PrivateDLL_Compile.PrivateNode<T>)null;
        (this).head = x.R;
      } else if ((x.R) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) {
        var _obj1 = x.L;
        _obj1.R = (PrivateDLL_Compile.PrivateNode<T>)null;
        (this).tail = x.L;
      } else {
        var _obj2 = x.R;
        _obj2.L = x.L;
        var _obj3 = x.L;
        _obj3.R = x.R;
      }
    }
    public T RemoveHead()
    {
      T h = default(T);
      h = this.head.payload;
      (this).Remove(this.head);
      return h;
    }
    public T RemoveTail()
    {
      T t = default(T);
      t = this.tail.payload;
      (this).Remove(this.tail);
      return t;
    }
    public void InsertHead(T v)
    {
      PrivateDLL_Compile.PrivateNode<T> _432_x;
      PrivateDLL_Compile.PrivateNode<T> _nw0 = new PrivateDLL_Compile.PrivateNode<T>();
      _nw0.__ctor(v);
      _432_x = _nw0;
      if ((this.head) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) {
        (this).head = _432_x;
        (this).tail = _432_x;
        (_432_x).L = (PrivateDLL_Compile.PrivateNode<T>)null;
        (_432_x).R = (PrivateDLL_Compile.PrivateNode<T>)null;
      } else {
        (_432_x).R = this.head;
        (_432_x).L = (PrivateDLL_Compile.PrivateNode<T>)null;
        var _obj4 = this.head;
        _obj4.L = _432_x;
        (this).head = _432_x;
      }
    }
    public void InsertTail(T v)
    {
      PrivateDLL_Compile.PrivateNode<T> _433_x;
      PrivateDLL_Compile.PrivateNode<T> _nw1 = new PrivateDLL_Compile.PrivateNode<T>();
      _nw1.__ctor(v);
      _433_x = _nw1;
      if ((this.tail) == (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) {
        (this).head = _433_x;
        (this).tail = _433_x;
        (_433_x).L = (PrivateDLL_Compile.PrivateNode<T>)null;
        (_433_x).R = (PrivateDLL_Compile.PrivateNode<T>)null;
      } else {
        (_433_x).L = this.tail;
        (_433_x).R = (PrivateDLL_Compile.PrivateNode<T>)null;
        var _obj5 = this.tail;
        _obj5.R = _433_x;
        (this).tail = _433_x;
      }
    }
    public T PeekHead()
    {
      T v = default(T);
      v = this.head.payload;
      return v;
    }
    public T PeekTail()
    {
      T v = default(T);
      v = this.tail.payload;
      return v;
    }
    public void Clear()
    {
      (this).head = (PrivateDLL_Compile.PrivateNode<T>)null;
      (this).tail = (PrivateDLL_Compile.PrivateNode<T>)null;
    }
  }

  public partial class DllIterator<T> {
    public DllIterator() {
      this.ptr = (PrivateDLL_Compile.PrivateNode<T>)null;
      this.d = default(PrivateDLL_Compile.PrivateDoublyLinkedList<T>);
    }
    public PrivateDLL_Compile.PrivateNode<T> ptr;
    public PrivateDLL_Compile.PrivateDoublyLinkedList<T> d;
    public void __ctor(PrivateDLL_Compile.PrivateDoublyLinkedList<T> d_k)
    {
      (this).d = d_k;
      (this).ptr = d_k.head;
    }
    public T GetVal()
    {
      T v = default(T);
      v = this.ptr.payload;
      return v;
      return v;
    }
    public bool MoveNext()
    {
      bool good = false;
      (this).ptr = this.ptr.R;
      if ((this.ptr) != (object) ((PrivateDLL_Compile.PrivateNode<T>)null)) {
        good = true;
      } else {
        good = false;
      }
      return good;
    }
  }

  public partial class __default {
    public static void InsertBeforeIter<__T>(PrivateDLL_Compile.PrivateDoublyLinkedList<__T> d, PrivateDLL_Compile.DllIterator<__T> iter, __T v)
    {
      if ((iter.ptr) == (object) (d.head)) {
        (d).InsertHead(v);
      } else {
        PrivateDLL_Compile.PrivateNode<__T> _434_x;
        PrivateDLL_Compile.PrivateNode<__T> _nw2 = new PrivateDLL_Compile.PrivateNode<__T>();
        _nw2.__ctor(v);
        _434_x = _nw2;
        (_434_x).L = iter.ptr.L;
        (_434_x).R = iter.ptr;
        var _obj6 = iter.ptr.L;
        _obj6.R = _434_x;
        var _obj7 = iter.ptr;
        _obj7.L = _434_x;
      }
    }
    public static bool RemoveIter<__T>(PrivateDLL_Compile.PrivateDoublyLinkedList<__T> d, PrivateDLL_Compile.DllIterator<__T> iter)
    {
      bool good = false;
      good = (iter.ptr.R) != (object) ((PrivateDLL_Compile.PrivateNode<__T>)null);
      PrivateDLL_Compile.PrivateNode<__T> _435_tmp;
      _435_tmp = iter.ptr.R;
      (d).Remove(iter.ptr);
      if (good) {
        (iter).ptr = _435_tmp;
      }
      return good;
    }
  }
} // end of namespace PrivateDLL_Compile
namespace PrivateDLLTests_Compile {


  public partial class PrivateDoublyLinkedListTests {
    public PrivateDoublyLinkedListTests() {
    }
    [Xunit.Fact]
    public static void TestIsEmptyTrue()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _436_list;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out0;
      _out0 = PrivateDLLTests_Compile.__default.GetEmptyList<BigInteger>();
      _436_list = _out0;
      bool _437_empty;
      bool _out1;
      _out1 = (_436_list).IsEmpty();
      _437_empty = _out1;
      if (!(_437_empty)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(132,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestIsEmptyFalse()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _438_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _439___v0;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out2;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out3;
      PrivateDLLTests_Compile.__default.GetListWithOneNode<BigInteger>(new BigInteger(5), out _out2, out _out3);
      _438_list = _out2;
      _439___v0 = _out3;
      bool _440_empty;
      bool _out4;
      _out4 = (_438_list).IsEmpty();
      _440_empty = _out4;
      if (!(!(_440_empty))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(138,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveOnly()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _441_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _442_node;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out5;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out6;
      PrivateDLLTests_Compile.__default.GetListWithOneNode<BigInteger>(new BigInteger(5), out _out5, out _out6);
      _441_list = _out5;
      _442_node = _out6;
      (_441_list).Remove(_442_node);
      bool _443_empty;
      bool _out7;
      _out7 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_441_list, Dafny.Sequence<BigInteger>.FromElements());
      _443_empty = _out7;
      if (!(_443_empty)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(145,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveFirst()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _444_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _445_head;
      PrivateDLL_Compile.PrivateNode<BigInteger> _446___v2;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out8;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out9;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out10;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(5), new BigInteger(6), out _out8, out _out9, out _out10);
      _444_list = _out8;
      _445_head = _out9;
      _446___v2 = _out10;
      (_444_list).Remove(_445_head);
      bool _447_correct;
      bool _out11;
      _out11 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_444_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(6)));
      _447_correct = _out11;
      if (!(_447_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(152,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveLast()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _448_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _449___v4;
      PrivateDLL_Compile.PrivateNode<BigInteger> _450_tail;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out12;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out13;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out14;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(5), new BigInteger(6), out _out12, out _out13, out _out14);
      _448_list = _out12;
      _449___v4 = _out13;
      _450_tail = _out14;
      (_448_list).Remove(_450_tail);
      bool _451_correct;
      bool _out15;
      _out15 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_448_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(5)));
      _451_correct = _out15;
      if (!(_451_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(159,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveMiddle()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _452_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _453___v6;
      PrivateDLL_Compile.PrivateNode<BigInteger> _454_node;
      PrivateDLL_Compile.PrivateNode<BigInteger> _455___v7;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out16;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out17;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out18;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out19;
      PrivateDLLTests_Compile.__default.GetListWithThreeNodes<BigInteger>(new BigInteger(5), new BigInteger(6), new BigInteger(7), out _out16, out _out17, out _out18, out _out19);
      _452_list = _out16;
      _453___v6 = _out17;
      _454_node = _out18;
      _455___v7 = _out19;
      (_452_list).Remove(_454_node);
      bool _456_correct;
      bool _out20;
      _out20 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_452_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(5), new BigInteger(7)));
      _456_correct = _out20;
      if (!(_456_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(166,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveHead()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _457_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _458___v9;
      PrivateDLL_Compile.PrivateNode<BigInteger> _459___v10;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out21;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out22;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out23;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(5), new BigInteger(6), out _out21, out _out22, out _out23);
      _457_list = _out21;
      _458___v9 = _out22;
      _459___v10 = _out23;
      BigInteger _460_head;
      BigInteger _out24;
      _out24 = (_457_list).RemoveHead();
      _460_head = _out24;
      if (!((_460_head) == (new BigInteger(5)))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(172,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
      bool _461_correct;
      bool _out25;
      _out25 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_457_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(6)));
      _461_correct = _out25;
      if (!(_461_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(174,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveTail()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _462_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _463___v11;
      PrivateDLL_Compile.PrivateNode<BigInteger> _464___v12;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out26;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out27;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out28;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(5), new BigInteger(6), out _out26, out _out27, out _out28);
      _462_list = _out26;
      _463___v11 = _out27;
      _464___v12 = _out28;
      BigInteger _465_tail;
      BigInteger _out29;
      _out29 = (_462_list).RemoveTail();
      _465_tail = _out29;
      if (!((_465_tail) == (new BigInteger(6)))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(180,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
      bool _466_correct;
      bool _out30;
      _out30 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_462_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(5)));
      _466_correct = _out30;
      if (!(_466_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(182,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestInsertHeadEmpty()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _467_list;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out31;
      _out31 = PrivateDLLTests_Compile.__default.GetEmptyList<BigInteger>();
      _467_list = _out31;
      (_467_list).InsertHead(new BigInteger(5));
      bool _468_correct;
      bool _out32;
      _out32 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_467_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(5)));
      _468_correct = _out32;
      if (!(_468_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(189,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestInsertHeadNonEmpty()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _469_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _470___v13;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out33;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out34;
      PrivateDLLTests_Compile.__default.GetListWithOneNode<BigInteger>(new BigInteger(6), out _out33, out _out34);
      _469_list = _out33;
      _470___v13 = _out34;
      (_469_list).InsertHead(new BigInteger(5));
      bool _471_correct;
      bool _out35;
      _out35 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_469_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(5), new BigInteger(6)));
      _471_correct = _out35;
      if (!(_471_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(196,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestInsertTailEmpty()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _472_list;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out36;
      _out36 = PrivateDLLTests_Compile.__default.GetEmptyList<BigInteger>();
      _472_list = _out36;
      (_472_list).InsertTail(new BigInteger(5));
      bool _473_correct;
      bool _out37;
      _out37 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_472_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(5)));
      _473_correct = _out37;
      if (!(_473_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(203,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestInsertTailNonEmpty()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _474_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _475___v14;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out38;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out39;
      PrivateDLLTests_Compile.__default.GetListWithOneNode<BigInteger>(new BigInteger(6), out _out38, out _out39);
      _474_list = _out38;
      _475___v14 = _out39;
      (_474_list).InsertTail(new BigInteger(5));
      bool _476_correct;
      bool _out40;
      _out40 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_474_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(6), new BigInteger(5)));
      _476_correct = _out40;
      if (!(_476_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(210,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestPeekHead()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _477_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _478___v15;
      PrivateDLL_Compile.PrivateNode<BigInteger> _479___v16;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out41;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out42;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out43;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(3), new BigInteger(4), out _out41, out _out42, out _out43);
      _477_list = _out41;
      _478___v15 = _out42;
      _479___v16 = _out43;
      BigInteger _480_head;
      BigInteger _out44;
      _out44 = (_477_list).PeekHead();
      _480_head = _out44;
      if (!((_480_head) == (new BigInteger(3)))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(216,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestPeekTail()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _481_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _482___v17;
      PrivateDLL_Compile.PrivateNode<BigInteger> _483___v18;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out45;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out46;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out47;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(3), new BigInteger(4), out _out45, out _out46, out _out47);
      _481_list = _out45;
      _482___v17 = _out46;
      _483___v18 = _out47;
      BigInteger _484_tail;
      BigInteger _out48;
      _out48 = (_481_list).PeekTail();
      _484_tail = _out48;
      if (!((_484_tail) == (new BigInteger(4)))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(222,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestClear()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _485_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _486___v19;
      PrivateDLL_Compile.PrivateNode<BigInteger> _487___v20;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out49;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out50;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out51;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(new BigInteger(3), new BigInteger(4), out _out49, out _out50, out _out51);
      _485_list = _out49;
      _486___v19 = _out50;
      _487___v20 = _out51;
      (_485_list).Clear();
      bool _488_empty;
      bool _out52;
      _out52 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_485_list, Dafny.Sequence<BigInteger>.FromElements());
      _488_empty = _out52;
      if (!(_488_empty)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(229,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
  }

  public partial class DllIteratorTests {
    public DllIteratorTests() {
    }
    [Xunit.Fact]
    public static void TestGetVal()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _489_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _490___v21;
      PrivateDLL_Compile.PrivateNode<BigInteger> _491___v22;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out53;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out54;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out55;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(BigInteger.One, new BigInteger(2), out _out53, out _out54, out _out55);
      _489_list = _out53;
      _490___v21 = _out54;
      _491___v22 = _out55;
      PrivateDLL_Compile.DllIterator<BigInteger> _492_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out56;
      _out56 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _492_iter = _out56;
      (_492_iter).d = _489_list;
      (_492_iter).ptr = _489_list.tail;
      BigInteger _493_payload;
      BigInteger _out57;
      _out57 = (_492_iter).GetVal();
      _493_payload = _out57;
      if (!((_493_payload) == (new BigInteger(2)))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(243,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestMoveNextValid()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _494_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _495___v23;
      PrivateDLL_Compile.PrivateNode<BigInteger> _496_tail;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out58;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out59;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out60;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(BigInteger.One, new BigInteger(2), out _out58, out _out59, out _out60);
      _494_list = _out58;
      _495___v23 = _out59;
      _496_tail = _out60;
      PrivateDLL_Compile.DllIterator<BigInteger> _497_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out61;
      _out61 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _497_iter = _out61;
      (_497_iter).d = _494_list;
      (_497_iter).ptr = _494_list.head;
      bool _498_valid;
      bool _out62;
      _out62 = (_497_iter).MoveNext();
      _498_valid = _out62;
      if (!(_498_valid)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(253,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
      if (!((_497_iter.ptr) == (object) (_494_list.tail))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(254,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestMoveNextNotValid()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _499_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _500___v24;
      PrivateDLL_Compile.PrivateNode<BigInteger> _501_tail;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out63;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out64;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out65;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(BigInteger.One, new BigInteger(2), out _out63, out _out64, out _out65);
      _499_list = _out63;
      _500___v24 = _out64;
      _501_tail = _out65;
      PrivateDLL_Compile.DllIterator<BigInteger> _502_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out66;
      _out66 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _502_iter = _out66;
      (_502_iter).d = _499_list;
      (_502_iter).ptr = _499_list.tail;
      bool _503_valid;
      bool _out67;
      _out67 = (_502_iter).MoveNext();
      _503_valid = _out67;
      if (!(!(_503_valid))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(264,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
      if (!((_502_iter.ptr) == (object) ((PrivateDLL_Compile.PrivateNode<BigInteger>)null))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(265,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestInsertBeforeIterHead()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _504_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _505___v25;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out68;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out69;
      PrivateDLLTests_Compile.__default.GetListWithOneNode<BigInteger>(new BigInteger(2), out _out68, out _out69);
      _504_list = _out68;
      _505___v25 = _out69;
      PrivateDLL_Compile.DllIterator<BigInteger> _506_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out70;
      _out70 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _506_iter = _out70;
      (_506_iter).d = _504_list;
      (_506_iter).ptr = _504_list.head;
      PrivateDLL_Compile.__default.InsertBeforeIter<BigInteger>(_504_list, _506_iter, BigInteger.One);
      bool _507_correct;
      bool _out71;
      _out71 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_504_list, Dafny.Sequence<BigInteger>.FromElements(BigInteger.One, new BigInteger(2)));
      _507_correct = _out71;
      if (!(_507_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(276,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestInsertBeforeIterInside()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _508_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _509___v26;
      PrivateDLL_Compile.PrivateNode<BigInteger> _510___v27;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out72;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out73;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out74;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(BigInteger.One, new BigInteger(3), out _out72, out _out73, out _out74);
      _508_list = _out72;
      _509___v26 = _out73;
      _510___v27 = _out74;
      PrivateDLL_Compile.DllIterator<BigInteger> _511_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out75;
      _out75 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _511_iter = _out75;
      (_511_iter).d = _508_list;
      (_511_iter).ptr = _508_list.tail;
      PrivateDLL_Compile.__default.InsertBeforeIter<BigInteger>(_508_list, _511_iter, new BigInteger(2));
      bool _512_correct;
      bool _out76;
      _out76 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_508_list, Dafny.Sequence<BigInteger>.FromElements(BigInteger.One, new BigInteger(2), new BigInteger(3)));
      _512_correct = _out76;
      if (!(_512_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(288,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveIterGood()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _513_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _514___v28;
      PrivateDLL_Compile.PrivateNode<BigInteger> _515___v29;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out77;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out78;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out79;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(BigInteger.One, new BigInteger(3), out _out77, out _out78, out _out79);
      _513_list = _out77;
      _514___v28 = _out78;
      _515___v29 = _out79;
      PrivateDLL_Compile.DllIterator<BigInteger> _516_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out80;
      _out80 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _516_iter = _out80;
      (_516_iter).d = _513_list;
      (_516_iter).ptr = _513_list.head;
      bool _517_good;
      bool _out81;
      _out81 = PrivateDLL_Compile.__default.RemoveIter<BigInteger>(_513_list, _516_iter);
      _517_good = _out81;
      bool _518_correct;
      bool _out82;
      _out82 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_513_list, Dafny.Sequence<BigInteger>.FromElements(new BigInteger(3)));
      _518_correct = _out82;
      if (!(_517_good)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(299,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
      if (!(_518_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(300,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
    [Xunit.Fact]
    public static void TestRemoveIterNotGood()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _519_list;
      PrivateDLL_Compile.PrivateNode<BigInteger> _520___v30;
      PrivateDLL_Compile.PrivateNode<BigInteger> _521___v31;
      PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out83;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out84;
      PrivateDLL_Compile.PrivateNode<BigInteger> _out85;
      PrivateDLLTests_Compile.__default.GetListWithTwoNodes<BigInteger>(BigInteger.One, new BigInteger(3), out _out83, out _out84, out _out85);
      _519_list = _out83;
      _520___v30 = _out84;
      _521___v31 = _out85;
      PrivateDLL_Compile.DllIterator<BigInteger> _522_iter;
      PrivateDLL_Compile.DllIterator<BigInteger> _out86;
      _out86 = PrivateDLLTests_Compile.__default.GetFreshDllIterator<BigInteger>();
      _522_iter = _out86;
      (_522_iter).d = _519_list;
      (_522_iter).ptr = _519_list.tail;
      bool _523_good;
      bool _out87;
      _out87 = PrivateDLL_Compile.__default.RemoveIter<BigInteger>(_519_list, _522_iter);
      _523_good = _out87;
      bool _524_correct;
      bool _out88;
      _out88 = PrivateDLLTests_Compile.__default.ListIs<BigInteger>(_519_list, Dafny.Sequence<BigInteger>.FromElements(BigInteger.One));
      _524_correct = _out88;
      if (!(!(_523_good))) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(311,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
      if (!(_524_correct)) {
        throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(312,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
      }
    }
  }

  public partial class __default {
    public static PrivateDLL_Compile.PrivateDoublyLinkedList<__T> GetFreshPrivateDoublyLinkedList<__T>()
    {
      return new PrivateDLL_Compile.PrivateDoublyLinkedList<__T>();
    }
    public static PrivateDLL_Compile.PrivateNode<__T> GetFreshPrivateNode<__T>()
    {
      return new PrivateDLL_Compile.PrivateNode<__T>();
    }
    public static PrivateDLL_Compile.DllIterator<__T> GetFreshDllIterator<__T>()
    {
      return new PrivateDLL_Compile.DllIterator<__T>();
    }
    public static PrivateDLL_Compile.PrivateDoublyLinkedList<__T> GetEmptyList<__T>()
    {
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list = default(PrivateDLL_Compile.PrivateDoublyLinkedList<__T>);
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out89;
      _out89 = PrivateDLLTests_Compile.__default.GetFreshPrivateDoublyLinkedList<__T>();
      list = _out89;
      (list).head = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (list).tail = (PrivateDLL_Compile.PrivateNode<__T>)null;
      return list;
    }
    public static void GetListWithOneNode<__T>(__T payload, out PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list, out PrivateDLL_Compile.PrivateNode<__T> node)
    {
      list = default(PrivateDLL_Compile.PrivateDoublyLinkedList<__T>);
      node = default(PrivateDLL_Compile.PrivateNode<__T>);
      PrivateDLL_Compile.PrivateNode<__T> _out90;
      _out90 = PrivateDLLTests_Compile.__default.GetFreshPrivateNode<__T>();
      node = _out90;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out91;
      _out91 = PrivateDLLTests_Compile.__default.GetFreshPrivateDoublyLinkedList<__T>();
      list = _out91;
      (node).payload = payload;
      (node).L = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (node).R = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (list).head = node;
      (list).tail = node;
    }
    public static void GetListWithTwoNodes<__T>(__T payload1, __T payload2, out PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list, out PrivateDLL_Compile.PrivateNode<__T> node1, out PrivateDLL_Compile.PrivateNode<__T> node2)
    {
      list = default(PrivateDLL_Compile.PrivateDoublyLinkedList<__T>);
      node1 = default(PrivateDLL_Compile.PrivateNode<__T>);
      node2 = default(PrivateDLL_Compile.PrivateNode<__T>);
      PrivateDLL_Compile.PrivateNode<__T> _out92;
      _out92 = PrivateDLLTests_Compile.__default.GetFreshPrivateNode<__T>();
      node1 = _out92;
      PrivateDLL_Compile.PrivateNode<__T> _out93;
      _out93 = PrivateDLLTests_Compile.__default.GetFreshPrivateNode<__T>();
      node2 = _out93;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out94;
      _out94 = PrivateDLLTests_Compile.__default.GetFreshPrivateDoublyLinkedList<__T>();
      list = _out94;
      (node1).payload = payload1;
      (node1).L = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (node1).R = node2;
      (node2).payload = payload2;
      (node2).L = node1;
      (node2).R = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (list).head = node1;
      (list).tail = node2;
    }
    public static void GetListWithThreeNodes<__T>(__T payload1, __T payload2, __T payload3, out PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list, out PrivateDLL_Compile.PrivateNode<__T> node1, out PrivateDLL_Compile.PrivateNode<__T> node2, out PrivateDLL_Compile.PrivateNode<__T> node3)
    {
      list = default(PrivateDLL_Compile.PrivateDoublyLinkedList<__T>);
      node1 = default(PrivateDLL_Compile.PrivateNode<__T>);
      node2 = default(PrivateDLL_Compile.PrivateNode<__T>);
      node3 = default(PrivateDLL_Compile.PrivateNode<__T>);
      PrivateDLL_Compile.PrivateNode<__T> _out95;
      _out95 = PrivateDLLTests_Compile.__default.GetFreshPrivateNode<__T>();
      node1 = _out95;
      PrivateDLL_Compile.PrivateNode<__T> _out96;
      _out96 = PrivateDLLTests_Compile.__default.GetFreshPrivateNode<__T>();
      node2 = _out96;
      PrivateDLL_Compile.PrivateNode<__T> _out97;
      _out97 = PrivateDLLTests_Compile.__default.GetFreshPrivateNode<__T>();
      node3 = _out97;
      PrivateDLL_Compile.PrivateDoublyLinkedList<__T> _out98;
      _out98 = PrivateDLLTests_Compile.__default.GetFreshPrivateDoublyLinkedList<__T>();
      list = _out98;
      (node1).payload = payload1;
      (node1).L = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (node1).R = node2;
      (node2).payload = payload2;
      (node2).L = node1;
      (node2).R = node3;
      (node3).payload = payload3;
      (node3).L = node2;
      (node3).R = (PrivateDLL_Compile.PrivateNode<__T>)null;
      (list).head = node1;
      (list).tail = node3;
    }
    public static bool ListIs<__T>(PrivateDLL_Compile.PrivateDoublyLinkedList<__T> list, Dafny.ISequence<__T> elements)
    {
      bool b = false;
      PrivateDLL_Compile.PrivateNode<__T> _525_curr;
      _525_curr = list.head;
      PrivateDLL_Compile.PrivateNode<__T> _526_currOld;
      _526_currOld = (PrivateDLL_Compile.PrivateNode<__T>)null;
      BigInteger _hi0 = new BigInteger((elements).Count);
      for (BigInteger _527_i = BigInteger.Zero; _527_i < _hi0; _527_i++) {
        if (((_525_curr) == (object) ((PrivateDLL_Compile.PrivateNode<__T>)null)) || (!object.Equals(_525_curr.payload, (elements).Select(_527_i)))) {
          b = false;
          return b;
        }
        _526_currOld = _525_curr;
        _525_curr = _525_curr.R;
        if (((_525_curr) != (object) ((PrivateDLL_Compile.PrivateNode<__T>)null)) && ((_525_curr.L) != (object) (_526_currOld))) {
          b = false;
          return b;
        }
      }
      b = (_525_curr) == (object) ((PrivateDLL_Compile.PrivateNode<__T>)null);
      return b;
      return b;
    }
  }
} // end of namespace PrivateDLLTests_Compile
namespace _module {




} // end of namespace _module
