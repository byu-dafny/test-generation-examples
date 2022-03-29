include "DynamicArray.dfy"
include "NativeTypes.dfy"
include "Utils.dfy"

module DynamicArrayTests {

    import opened DynamicArray
    import opened NativeTypes
    import opened Utils

    class VectorTests {

        method {:test} test_get_size_should_returnCurrentSize() 
        {
            var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);
            var result := arr.get_size();

            assert(result == 0);
            Assertions.assertEquals(result as int, 0);
        }

        method {:test} test_at_index_should_returnValueAtGivenIndex() 
        {
            var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);
            var oracleValue := 2;
            arr.push_back(oracleValue);
            var index := 0;

            var result := arr.at_index(index);

            assert(result == arr.buffer[index]);
            Assertions.assertEquals(result, arr.buffer[index]);
            assert(result == oracleValue);
            Assertions.assertEquals(result, oracleValue);
        }

        method {:test} test_extend_buffer_should_extendBufferThenStop_when_CapacityStaysUnderMax()
        {
            var arr := DynamicArrayUtils.fresh_DynamicArray(0);
            var currentSizeBeforeCall := arr.current_size;

            arr.extend_buffer(4);

            assert(arr.current_size < arr.current_capacity);
            Assertions<bool>.assertTrue(arr.current_size < arr.current_capacity);
            assert(arr.current_size == currentSizeBeforeCall);
            Assertions.assertEquals(arr.current_size as int, currentSizeBeforeCall as int);
        }


        method {:test} test_push_back_should_notExtendBuffer_when_sizeIsNotOneLessThanCapacity()
        {
            var arr := DynamicArrayUtils.fresh_DynamicArray(0);
            var currentSizeBeforeCall := arr.current_size;
            var oracleValue := 7;

            arr.push_back(oracleValue);

            assert(currentSizeBeforeCall as int < arr.buffer.Length);
            Assertions<bool>.assertTrue(currentSizeBeforeCall as int < arr.buffer.Length);
            assert(arr.buffer[currentSizeBeforeCall] == oracleValue);
            Assertions<bool>.assertTrue(arr.buffer[currentSizeBeforeCall] == oracleValue);
            assert(arr.current_size == currentSizeBeforeCall + 1);
            Assertions<bool>.assertTrue(arr.current_size == currentSizeBeforeCall + 1);
        }

        method {:test} test_push_back_should_extendBuffer_when_sizeIsOneLessThanCapacity()
        {
            var arr := DynamicArrayUtils.fresh_DynamicArray(0);
            var oracleValue := 7;
            for i : int := 0 to arr.current_capacity as int - 1
            invariant arr.Valid()
            invariant fresh(arr.buffer)
            {
                arr.push_back(oracleValue);
            }
            var currentSizeBeforeCall := arr.current_size;

            arr.push_back(oracleValue);

            assert(currentSizeBeforeCall as int < arr.buffer.Length);
            Assertions<bool>.assertTrue(currentSizeBeforeCall as int < arr.buffer.Length);
            assert(arr.buffer[currentSizeBeforeCall] == oracleValue);
            Assertions<bool>.assertTrue(arr.buffer[currentSizeBeforeCall] == oracleValue);
            assert(arr.current_size == currentSizeBeforeCall + 1);
            Assertions<bool>.assertTrue(arr.current_size == currentSizeBeforeCall + 1);
        }

        // method {:test} test_push_back_should_throwException_when_capacityAboveMax() 
        // {
        //     var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);
        //     var value := 7;
        //     for i : int := 0 to UINT16_MAX_JAVA as int / 2
        //     invariant arr.Valid()
        //     invariant fresh(arr.buffer)
        //     {
        //         arr.push_back(value);
        //     }

        //     JUnit5.assertThrowsAfterPushBack(arr);
        // }

        method {:test} test_clear_should_modifyCurrentSizeToZero() 
        {
            var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);

            arr.clear();

            assert(arr.current_size == 0);
            Assertions.assertEquals(arr.current_size, 0);
        }
    }
}