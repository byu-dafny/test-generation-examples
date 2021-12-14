/*
Running into issues with the remove function.
TODO: Change use of singly linked list without remove function to doubly linked list within same repository
*/
module Hashtable {
    class Integer {
        var val:int;
        constructor(val:int) 
            ensures this.val == val
        {
            this.val := val;
        }
    }

    class HashEntry {
        var key: int;
        var value: int;
        constructor(key:int, value:int)
            ensures this.key == key && this.value == value
        {
            this.key := key;
            this.value := value;
        }
    }

    class ListNode {
        var next: ListNode?;
        var entry: HashEntry;
        var size: int;

        ghost var nodes: set<ListNode>
        ghost var entries: seq<HashEntry>

        // ghost var values: seq<int>
        // var value: int;

        predicate Valid() 
            reads this, nodes
            decreases nodes + {this}
        {
            size == |nodes| &&
            this in nodes &&
            (next == null ==> entries == [entry]) &&
            (next != null ==> next in nodes && next.nodes <= nodes &&
            this !in next.nodes && entry in entries && next.entries <= entries && 
            entries == next.entries + [entry] && next.Valid())
        }

        constructor (key : int, val : int)
            ensures next == null
            ensures entry.key == key && entry.value == val
            ensures entries == [entry]
            ensures nodes == {this}
            ensures size == 1
            ensures Valid()
        {
            next := null;
            entry := new HashEntry(key, val);
            entries := [entry];
            nodes := {this};
            size := 1;
        }

        method insert(key: int, value: int) returns (node: ListNode)
            requires Valid()
            ensures node.Valid()
            ensures Valid()
            ensures |entries| == old(|entries|)
            ensures |nodes| == old(|nodes|)
            ensures size == old(size)
            ensures fresh(node)
            ensures node.size == old(size) + 1
            ensures node.next == old(this)
            ensures node.entry.key == key && node.entry.value == value
            ensures node.entry in node.entries
            ensures node.entries == entries + [node.entry]
        {
            node := new ListNode(key, value);
            node.next := this;
            node.entries := this.entries + [node.entry];
            node.nodes := this.nodes + {node};
            node.size := this.size + 1;
        }

        method listSize() returns (size: int)
            requires Valid()
            ensures size == this.size
            ensures Valid()
        {
            size := this.size;
        }

        predicate p_contains(key:int, entries:seq<HashEntry>, out:bool)
        reads entries
        {
        !p_contains_neg(key, entries, out) ==> out==true
        }
        predicate p_contains_neg(key:int, entries:seq<HashEntry>, out:bool)
        reads entries
        {
        (forall e :: e in entries ==> e.key != key) ==> out==false
        }

        method {:tailrecursion true} contains(key: int) returns (out: bool) 
            requires Valid()
            ensures p_contains(key, entries, out)
            ensures p_contains_neg(key, entries, out)
            ensures Valid()
            decreases nodes + {this}
        {
            if (this.entry.key == key) {
                out := true;
                return;
            } 
        
            if (this.next == null) {
                out := false;
                return;
            } 
    
            out := this.next.contains(key);
        }

        method {:tailrecursion true} containedBy(other:ListNode?) returns (out:bool)
            requires Valid()
            requires other==null || other.Valid()
            ensures Valid()
            decreases nodes + {this}
        {
            if (other == null) {
                return false;
            }
            var other_contains:bool:=other.contains(entry.key);
            if (!other_contains) {
                return false;
            }
        
            if (this.next == null) {
                return true;
            }
        
            out := this.next.containedBy(other);
        }
    }

    class LlHashMap {
        var buffer:array<ListNode?>;
        var size:int;
        //HashEntry[] buffer;

        predicate Valid() 
            reads this, this.buffer
            reads set m | 0 <= m < this.buffer.Length && this.buffer[m] != null :: buffer[m]
            reads set m, n | 0 <= m < this.buffer.Length && this.buffer[m] != null 
                && n in this.buffer[m].nodes :: n
        {
            this.buffer.Length > 0 &&
            forall i : int :: 0 <= i < this.buffer.Length ==> (buffer[i] != null ==> buffer[i].Valid())
        }

        constructor (nrBuckets:int)
            requires nrBuckets > 0
            ensures this.buffer.Length == nrBuckets
            ensures this.size == 0;
            ensures this.Valid();
        {
            this.buffer := new ListNode?[nrBuckets](_ => null);
            this.size := 0;
        }

        method put(key:int, value:int)
            requires this.Valid()
            requires this.buffer.Length > 0
            modifies this.buffer, this
            modifies set m | 0 <= m < this.buffer.Length && this.buffer[m] != null :: buffer[m]
            modifies set m, n | 0 <= m < this.buffer.Length && this.buffer[m] != null 
                && n in this.buffer[m].nodes :: n
            ensures this.Valid()
            ensures (this.buffer[abs_f(key)] == null) ==> old(size) + 1 == size
            ensures (this.buffer[abs_f(key)] != null &&
                forall n : ListNode :: n in this.buffer[abs_f(key)].nodes ==> n.entry.key != key)
                    ==> old(size) + 1 == size
        {
            var index:int:= hashOf(key);
            if(this.buffer[index] == null) {
                this.buffer[index] := new ListNode(key, value);
                this.size := this.size + 1;
            } else {
                var el:ListNode? := this.buffer[index].insert(key, value);
                if(el != null) {
                    this.size := this.size + 1;
                }
            }
        }

        method find(key:int) returns (out:ListNode?)
            requires this.Valid()
            requires this.buffer.Length > 0
            modifies this.buffer
        {
            var index:int:= hashOf(key);
            var el:ListNode?:= this.buffer[index];
            if (el == null || el.entry.key == key) {
                return el;
            }
            while (el.next != null && el.next.entry.key != key) 
                invariant el.Valid()
                decreases el.nodes + {el}
            {
                el := el.next;
            }
            return el;
        }

        method contains(key:int) returns (out:bool)
            requires this.Valid()
            requires this.buffer.Length > 0
            modifies this.buffer
        {
            var node : ListNode? := find(key);
            out:= node != null;
        }

    /**
    * Gets the value for a key from the table if it exists.
    * 
    * @param key   the key to search for
    * @return
    */
        method get(key:int) returns (out:Integer?)
            requires this.Valid() 
            requires this.buffer.Length > 0
            modifies this.buffer
        {
            var found : ListNode? := find(key);
            if (found == null) {
                return null;
            } else {
                return new Integer(found.entry.value);
            }
        }

    /**
    * Takes a key out of the table.
    * 
    * @param key the key to remove
    */
        // method remove(key:int)
        //     requires this.Valid()
        //     requires this.buffer.Length > 0
        //     modifies this.buffer
        //     requires forall m:int, n:ListNode :: 0 <= m < this.buffer.Length && this.buffer[m] != null 
        //         && n in this.buffer[m].nodes ==> n.next in this.buffer[m].nodes
        //     modifies set m, n | 0 <= m < this.buffer.Length && this.buffer[m] != null && n in buffer[m].nodes :: n.next
        // {
        //     var index:int:= hashOf(key);
        //     var el:ListNode? := this.buffer[index];
        //     if(el != null) {
        //         if(el.entry.key == key) {
        //             this.buffer[index] := el.next;
        //         } else {
        //             while (el.next != null) 
        //                 invariant el != null && el.Valid()
        //                 invariant el.next in el.nodes
        //                 decreases el.nodes
        //                 modifies el, el.next
        //                 modifies set n | n in el.nodes
        //             {
        //                 if (el.next.entry.key == key) {
        //                     el.next := el.next.next;
        //                     return;
        //                 }
        //                 el := el.next;
        //             }
        //         }
        //     }
        // }
        function method abs_f(key:int) : int
            reads this
            requires this.buffer.Length > 0 {
            (if key >= 0 then 1 else -1) * key % this.buffer.Length
        }

        method Abs(x: int) returns (y: int)
        ensures 0 <= y;
        ensures 0 <= x ==> x == y;
        ensures x < 0 ==> y == -x;
        {
            if (x < 0) {
                return -x;
            }
            return x;
        }

        method hashOf(key:int) returns (out:int)
            requires this.buffer.Length > 0
            ensures 0 <= out < this.buffer.Length
            ensures out == (if key >= 0 then 1 else -1) * key % buffer.Length
            ensures old(this.buffer.Length) == this.buffer.Length
        {
            var new_key:int:=Abs(key);
            out:= new_key % this.buffer.Length;
        }
    }
}