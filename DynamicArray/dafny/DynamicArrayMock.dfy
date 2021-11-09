// This file is only meant to be illustrative.
// The DynamicArray class should not have a mock when it is the 
// object under test.

include "DynamicArray.dfy"

module {:axiom "DynamicArrayMock"} DynamicArrayMock {

    import opened DynamicArray

    method {:extern "DynamicArrayMock", "mock_dynamicArray"} mock_dynamicArray<T>() returns (arr : Vector<T>)
        ensures arr.Valid()
        ensures fresh(arr)
        ensures fresh(arr.buffer)

    method {:extern "DynamicArrayMock", "when_push_back"} when_push_back<T>(arr : Vector<T>, val:T)
        ensures arr.Valid()
        ensures 0 < arr.current_size as int < arr.buffer.Length
        ensures arr.buffer[arr.current_size as int - 1] == val
        ensures arr.current_size as int == old(arr.current_size) as int + 1

}