include "../src/DynamicArray.dfy"
include "DynamicArrayMock.dfy"
include "../src/NativeTypes.dfy"

module DynamicArrayTest {
    
    import opened DynamicArray
    import opened Extern
    import opened NativeTypes
    import opened DynamicArrayMock

        method get_size_should_returnCurrentSize() 
        {
            var arr := mock_dynamicArray();
            assume arr.current_size == 0;
            when_push_back(arr, 4);

            var result := arr.get_size();

            assert result == 1;
        }

        method at_index_should_returnValueAtGivenIndex() 
        {
            var arr := mock_dynamicArray();
            var oracleValue := 4;
            when_push_back(arr, oracleValue);
            var index := 2;
            assume index < arr.current_size;

            var result := arr.at_index(index);

            assert result == arr.buffer[index];
        }

        method extend_buffer_should_throwFatal_when_CapacityIsExtendedToMax()
        {
            var arr := mock_dynamicArray();
            assume arr.current_capacity == UINT32_MAX;

            arr.extend_buffer(4);
        }

        method extend_buffer_should_extendBufferThenStop_when_CapacityStaysUnderMax()
        {
            var arr := mock_dynamicArray();
            var currentSizeBeforeCall := arr.current_size;

            arr.extend_buffer(4);

            assert fresh(arr.buffer);
            assert arr.current_size < arr.current_capacity;
            assert arr.current_size == currentSizeBeforeCall;
        }


        method push_back_should_notExtendBuffer_when_sizeIsNotOneLessThanCapacity()
        {
            var arr := mock_dynamicArray();
            assume arr.current_capacity == 32;
            assume arr.current_size == 16;
            var currentSizeBeforeCall := arr.current_size;
            var oracleValue := 7;

            arr.push_back(oracleValue);

            assert fresh(arr.buffer) || arr.buffer == old(arr.buffer);
            assert arr.Valid();
            assert currentSizeBeforeCall as int < arr.buffer.Length;
            assert arr.buffer[currentSizeBeforeCall] == oracleValue;
            assert arr.current_size == currentSizeBeforeCall + 1;
        }

        method push_back_should_extendBuffer_when_sizeIsOneLessThanCapacity()
        {
            var arr := mock_dynamicArray();
            assume arr.current_capacity == 32;
            assume arr.current_size == arr.current_capacity - 1;
            var currentSizeBeforeCall := arr.current_size;

            arr.push_back(7);

            assert fresh(arr.buffer) || arr.buffer == old(arr.buffer);
            assert arr.Valid();
            assert currentSizeBeforeCall as int < arr.buffer.Length;
            assert arr.buffer[currentSizeBeforeCall] == 7;
        }

        method clear_should_ModifyCurrentSizeToZero() 
        {
            var arr := mock_dynamicArray();
            when_push_back(arr, 'c');

            arr.clear();

            assert arr.Valid();
            assert arr.current_size == 0;
        }
}