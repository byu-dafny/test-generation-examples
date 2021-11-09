include "DynamicArray.dfy"

module Utils {
    import opened DynamicArray

    class JUnit5 {
        static method {:axiom} assertEquals<T>(left : T, right : T)
        ensures true

        static method {:axiom} assertTrue(value : bool)
        ensures true

        static method {:axiom} assertFalse(value : bool)
        ensures true
    }

    class DynamicArrayUtils {
        static method {:axiom} fresh_DynamicArray() returns (vector : Vector)
        ensures vector.Valid()
        ensures fresh(vector.buffer)
        ensures vector.current_size == 0
        ensures vector.current_capacity == vector.DEFAULT_SIZE 
        ensures vector.current_capacity as int == vector.buffer.Length
    }
}