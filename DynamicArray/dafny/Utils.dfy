include "DynamicArray.dfy"

module Utils {
  import opened DynamicArray
  class Assertions<T> {
    static method {:extern} assertEquals(expected : T, actual : T)
    requires expected == actual

    static method {:extern} expectEquals(expected : T, actual : T)
    ensures expected == actual

    static method {:extern} assertTrue(condition : bool)
    requires condition

    static method {:extern} expectTrue(condition : bool)
    ensures condition
    
    static method {:extern} assertFalse(condition : bool)
    requires !condition

    static method {:extern} expectFalse(condition : bool)
    ensures !condition
  }

    class DynamicArrayUtils<T> {
        static method fresh_DynamicArray(t : T) returns (vector : Vector<T>)
        ensures vector.Valid()
        ensures fresh(vector.buffer)
        ensures vector.current_size == 0
        ensures vector.current_capacity == vector.DEFAULT_SIZE 
        ensures vector.current_capacity as int == vector.buffer.Length
        {
            return new Vector(t);
        }
    }
}