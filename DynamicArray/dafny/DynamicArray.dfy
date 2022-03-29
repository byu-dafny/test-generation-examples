/* 
    The following code is originally authored by the Secure Foundations Lab.
    It is part of a project to implement the QUIC protocol layer in Dafny.
    The original source can be found here:
    https://github.com/secure-foundations/everquic-dafny/tree/master/src

    For testing purposes, we have made modifications that strengthen 
    certain postconditions.
*/

include "NativeTypes.dfy"
include "Extern.dfy"

module DynamicArray {
    
    import opened NativeTypes
    import opened Extern

    export
        reveals Vector, Vector.DEFAULT_SIZE
        provides Vector._ctor, Vector.Valid, Vector.buffer, Vector.current_capacity, 
            Vector.extend_buffer, Vector.current_size, Vector.push_back, Vector.get_size,
            Vector.at_index, Vector.clear
        provides NativeTypes


    class Vector<T>
    {
        static const DEFAULT_SIZE :uint16 := 16
        var buffer :array<T>
        var current_capacity :uint16
        var current_size :uint16

        constructor(default_val:T)
            ensures Valid()
            ensures fresh(buffer)
            ensures current_size == 0
            ensures current_capacity == DEFAULT_SIZE 
            ensures current_capacity as int == buffer.Length
        {
            current_size := 0;
            current_capacity := DEFAULT_SIZE;
            new;
            buffer := newArrayFill(DEFAULT_SIZE, default_val);
        }

        predicate Valid()
            reads this, buffer
        {
            && current_capacity >= DEFAULT_SIZE
            && current_capacity as int == buffer.Length
            && current_size < current_capacity
        }

        method get_size() returns (x:uint16)
            ensures x == current_size
            ensures current_size == old(current_size)
        {
            return current_size;
        }

        method at_index(index:uint16) returns (x:T)
            requires Valid()
            requires index < current_size
            ensures x == buffer[index]
        {
            return buffer[index];
        }

        method extend_buffer(value: T)
            requires Valid()
            ensures Valid()
            ensures fresh(buffer)
            ensures current_size as int < current_capacity as int - 1
            ensures forall i : int :: 0 <= i < old(current_size) as int ==> buffer[i] == old(buffer[i])
            ensures current_size == old(current_size)
            ensures buffer.Length == old(buffer.Length) * 2
            modifies this`current_capacity, this`buffer
        {
            if current_capacity >= UINT16_MAX_JAVA / 2 {
              fatal("at max capacity");
            }
            var old_buffer := this.buffer;
            var old_size := this.current_capacity;


            current_capacity := old_size * 2;
            buffer := newArrayFill(current_capacity, value);

            var i:= 0;
            while i < old_size
            invariant Valid();
            invariant current_capacity > old_size;
            invariant i < current_capacity;
            invariant i <= old_size;
            invariant fresh(buffer)
            invariant current_size < current_capacity - 1;
            invariant current_size == old(current_size)
            invariant current_capacity == old(current_capacity) * 2
            invariant forall k : int :: 0 <= k < i as int ==> buffer[k] == old_buffer[k] == old(buffer[k])
            {
                buffer[i] := old_buffer[i];

                i := i + 1;
            }
        }

        method push_back(value:T)
            requires Valid()
            ensures Valid();
            ensures old(current_size as int) < buffer.Length
            ensures buffer[old(current_size)] == value
            ensures current_size == old(current_size) + 1
            ensures if old(current_size) + 1 == old(current_capacity) then fresh(buffer) else buffer == old(buffer)
            ensures forall i : int :: 0 <= i < old(current_size) as int ==> buffer[i] == old(buffer[i])
            ensures forall i : int :: current_size as int <= i < old(buffer.Length) ==> buffer[i] == old(buffer[i])
            ensures if old(current_size) + 1 == old(current_capacity) then fresh(buffer) else !fresh(buffer) && buffer == old(buffer)
            modifies this, this.buffer, this`current_size
        {
            if (current_size + 1 == current_capacity)
            {
                extend_buffer(value);
            }
            buffer[current_size] := value;
            current_size := current_size + 1;
        }

        method clear()
            requires Valid()
            modifies this`current_size
            ensures Valid()
            ensures current_size == 0
        {
            current_size := 0;
        }
    }
}
