include "PrivateDLL.dfy"

module PrivateDLLTests {

    import opened PrivateDLL

    // The three methods below have to be implemented in the target language

    method {:extern} {:fresh} GetFreshPrivateDoublyLinkedList<T>() 
        returns (list:PrivateDoublyLinkedList<T>) 
        ensures fresh(list)

    method {:extern} {:fresh} GetFreshPrivateNode<T>() 
        returns (node:PrivateNode<T>) 
        ensures fresh(node)

    method {:extern} {:fresh} GetFreshDllIterator<T>() 
        returns (iter:DllIterator<T>) 
        ensures fresh(iter)

    // The four helper methods below help to avoid repetition.
    // While these can be merged into one method, I split them for readability

    method GetEmptyList<T> ()
        returns (list:PrivateDoublyLinkedList<T>)
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

    method GetListWithOneNode<T> (payload:T)
        returns (list:PrivateDoublyLinkedList<T>, node:PrivateNode<T>)
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

    method GetListWithTwoNodes<T> (payload1:T, payload2:T)
        returns (list:PrivateDoublyLinkedList<T>, 
                 node1:PrivateNode<T>,
                 node2:PrivateNode<T>)
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

    method GetListWithThreeNodes<T> (payload1:T, payload2:T, payload3:T)
        returns (list:PrivateDoublyLinkedList<T>, 
                 node1:PrivateNode<T>,
                 node2:PrivateNode<T>,
                 node3:PrivateNode<T>)
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

    // A method for сhecking list content at runtime

    method ListIs<T(==)>(list:PrivateDoublyLinkedList<T>, elements:seq<T>) returns (b:bool) {
        var curr:PrivateNode?<T> := list.head;
        var currOld:PrivateNode?<T> := null;
        for i := 0 to |elements| {
            if curr == null || curr.payload != elements[i] {
                return false;
            }
            currOld := curr;
            curr := curr.R;
            if ((curr != null) && (curr.L != currOld)) {
                return false;
            }
        }
        return curr == null;
    }

    // Below are the tests proper

    class PrivateDoublyLinkedListTests {

        static method {:test} TestIsEmptyTrue() {
            var list := GetEmptyList<int>();    
            var empty := list.IsEmpty();
            expect empty;
        }

        static method {:test} TestIsEmptyFalse() {
            var list, _ := GetListWithOneNode<int>(5);
            var empty := list.IsEmpty();
            expect !empty;
        }

        static method {:test} TestRemoveOnly() {
            var list, node := GetListWithOneNode<int>(5);
            var _ := list.Remove(node);
            var empty := ListIs(list, []);
            expect empty;
        }

        static method {:test} TestRemoveFirst() {
            var list, head, _ := GetListWithTwoNodes<int>(5, 6);
            var _ := list.Remove(head);
            var correct := ListIs(list, [6]);
            expect correct;
        }

        static method {:test} TestRemoveLast() {
            var list, _, tail := GetListWithTwoNodes<int>(5, 6);
            var _ := list.Remove(tail);
            var correct := ListIs(list, [5]);
            expect correct;
        }

        static method {:test} TestRemoveMiddle() {
            var list, _, node, _ := GetListWithThreeNodes<int>(5, 6, 7);
            var _ := list.Remove(node);
            var correct := ListIs(list, [5, 7]);
            expect correct;
        }

        static method {:test} TestRemoveHead() {
            var list, _, _ := GetListWithTwoNodes<int>(5, 6);
            var head := list.RemoveHead();
            expect head == 5;
            var correct := ListIs(list, [6]);
            expect correct;
        }

        static method {:test} TestRemoveTail() {
            var list, _, _ := GetListWithTwoNodes<int>(5, 6);
            var tail := list.RemoveTail();
            expect tail == 6;
            var correct := ListIs(list, [5]);
            expect correct;
        }

        static method {:test} TestInsertHeadEmpty() {
            var list := GetEmptyList<int>();    
            list.InsertHead(5);
            var correct := ListIs(list, [5]);
            expect correct;
        }

        static method {:test} TestInsertHeadNonEmpty() {
            var list, _ := GetListWithOneNode<int>(6);
            list.InsertHead(5); 
            var correct := ListIs(list, [5, 6]);
            expect correct;
        }

        static method {:test} TestInsertTailEmpty() {
            var list := GetEmptyList<int>();    
            list.InsertTail(5);
            var correct := ListIs(list, [5]);
            expect correct;
        }

        static method {:test} TestInsertTailNonEmpty() {
            var list, _ := GetListWithOneNode<int>(6);
            list.InsertTail(5); 
            var correct := ListIs(list, [6, 5]);
            expect correct;
        }

        static method {:test} TestPeekHead() {
            var list, _, _ := GetListWithTwoNodes<int>(3, 4);    
            var head := list.PeekHead();
            expect head == 3;
        }

        static method {:test} TestPeekTail() {
            var list, _, _ := GetListWithTwoNodes<int>(3, 4);    
            var tail := list.PeekTail();
            expect tail == 4;
        }

        static method {:test} TestClear() {
            var list, _, _ := GetListWithTwoNodes<int>(3, 4);    
            list.Clear();
            var empty := ListIs(list, []);
            expect empty;
        }

    }

    class DllIteratorTests {

        static method {:test} TestGetVal() {
            var list, _, _ :=  GetListWithTwoNodes<int>(1, 2);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.tail;
            iter.index := 1;
            var payload := iter.GetVal();
            expect payload == 2;
        }

        static method {:test} TestMoveNextValid() {
            var list, _, tail :=  GetListWithTwoNodes<int>(1, 2);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.head;
            iter.index := 0;
            var valid := iter.MoveNext();
            expect valid;
            expect iter.ptr == list.tail;
        }

        static method {:test} TestMoveNextNotValid() {
            var list, _, tail :=  GetListWithTwoNodes<int>(1, 2);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.tail;
            iter.index := 1;
            var valid := iter.MoveNext();
            expect !valid;
            expect iter.ptr == null;
        }

        static method {:test} TestInsertBeforeIterHead() {
            var list, _ :=  GetListWithOneNode<int>(2);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.head;
            iter.index := 0;
            InsertBeforeIter(list, iter, 1);
            var correct := ListIs(list, [1, 2]);
            expect correct;
            // expect iter.ptr == list.head would be appropriate and would fail
        }

        static method {:test} TestInsertBeforeIterInside() {
            var list, _, _ :=  GetListWithTwoNodes<int>(1, 3);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.tail;
            iter.index := 1;
            InsertBeforeIter(list, iter, 2);
            var correct := ListIs(list, [1, 2, 3]);
            expect correct;
        }

        static method {:test} TestRemoveIterGood() {
            var list, _, _ :=  GetListWithTwoNodes<int>(1, 3);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.head;
            iter.index := 0;
            var good := RemoveIter(list, iter);
            var correct := ListIs(list, [3]);
            expect good;
            expect correct;
        }

        static method {:test} TestRemoveIterNotGood() {
            var list, _, _ :=  GetListWithTwoNodes<int>(1, 3);
            var iter :=  GetFreshDllIterator();
            iter.d := list;
            iter.ptr := list.tail;
            iter.index := 1;
            var good := RemoveIter(list, iter);
            var correct := ListIs(list, [1]);
            expect !good;
            expect correct;
        }

    }


}