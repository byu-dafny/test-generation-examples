include "Hashtable.dfy"


module HashtableTests {
    import opened Hashtable

    class LLHashMapTests {
        method testHash() {
            var table : LlHashMap := new LlHashMap(16);
            assert(table.buffer.Length == 16);
            assert(table.size == 0);

            var p20 : int := table.hashOf(20);
            var p10 : int := table.hashOf(10);
            var n10 : int := table.hashOf(-10);

            assert(table.buffer.Length == 16);
            assert(p10 == n10);
            assert(p20 != p10);
        }

        // Put appears to violate a modifies clause.
        // Currently, the only parts that could be modified are:
        // -The array of buckets
        // -Linked List nodes in the buckets
        // As far as I know, they are both accounted for in the modifes clause of "put"
        method testPut() {
            var table : LlHashMap := new LlHashMap(16);
            assert(table.buffer.Length == 16);
            assert(table.size == 0);

            assert(table.Valid() && table.buffer.Length > 0);
            table.put(10, 10);
        }
        
        method testGet() {
            
        }
        
        method testContains() {
            
        }
    }
}