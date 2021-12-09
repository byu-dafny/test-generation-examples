include "DynamicArray.dfy"
include "NativeTypes.dfy"
include "Utils.dfy"

module DynamicArrayTests {

    import opened DynamicArray
    import opened NativeTypes
    import opened Utils

    class VectorTests {

        method get_size_should_returnCurrentSize() 
        {
            var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);

            var result := arr.get_size();

            assert result == 0;
            JUnit5.assertEquals(result as int, 0);
        }

        method at_index_should_returnValueAtGivenIndex() 
        {
            var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);
            var oracleValue := 2;
            arr.push_back(oracleValue);
            var index := 0;

            var result := arr.at_index(index);

            assert result == arr.buffer[index];
            JUnit5.assertEquals(result, arr.buffer[index]);
            assert result == oracleValue;
            JUnit5.assertEquals(result, oracleValue);
        }

        method extend_buffer_should_extendBufferThenStop_when_CapacityStaysUnderMax()
        {
            var arr := DynamicArrayUtils.fresh_DynamicArray(0);
            var currentSizeBeforeCall := arr.current_size;

            arr.extend_buffer(4);

            assert fresh(arr.buffer);
            assert arr.current_size < arr.current_capacity;
            JUnit5.assertTrue(arr.current_size < arr.current_capacity);
            assert arr.current_size == currentSizeBeforeCall;
            JUnit5.assertEquals(arr.current_size as int, currentSizeBeforeCall as int);
        }


        method push_back_should_notExtendBuffer_when_sizeIsNotOneLessThanCapacity()
        {
            var arr := DynamicArrayUtils.fresh_DynamicArray(0);
            var currentSizeBeforeCall := arr.current_size;
            var oracleValue := 7;

            arr.push_back(oracleValue);

            assert arr.Valid();
            assert currentSizeBeforeCall as int < arr.buffer.Length;
            JUnit5.assertTrue(currentSizeBeforeCall as int < arr.buffer.Length);
            assert arr.buffer[currentSizeBeforeCall] == oracleValue;
            JUnit5.assertTrue(arr.buffer[currentSizeBeforeCall] == oracleValue);
            assert arr.current_size == currentSizeBeforeCall + 1;
            JUnit5.assertTrue(arr.current_size == currentSizeBeforeCall + 1);
        }

        method push_back_should_extendBuffer_when_sizeIsOneLessThanCapacity()
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

            assert arr.Valid();
            assert currentSizeBeforeCall as int < arr.buffer.Length;
            JUnit5.assertTrue(currentSizeBeforeCall as int < arr.buffer.Length);
            assert arr.buffer[currentSizeBeforeCall] == oracleValue;
            JUnit5.assertTrue(arr.buffer[currentSizeBeforeCall] == oracleValue);
            assert arr.current_size == currentSizeBeforeCall + 1;
            JUnit5.assertTrue(arr.current_size == currentSizeBeforeCall + 1);
        }

        method clear_should_modifyCurrentSizeToZero() 
        {
            var arr : Vector<int> := DynamicArrayUtils.fresh_DynamicArray(0);

            arr.clear();

            assert arr.Valid();
            assert arr.current_size == 0;
            JUnit5.assertEquals(arr.current_size, 0);
        }
    }
}