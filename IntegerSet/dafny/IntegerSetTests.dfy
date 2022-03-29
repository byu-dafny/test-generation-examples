include "IntegerSet.dfy"
include "Utils.dfy"

module IntegerSetTests {

    import opened IntegerSet
    import opened Utils

    class IntegerSetTests {

        // get size of set
        method {:test} test_GetSize() {
            
            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // get size
            var size := testSet.size();

            // check ensures

            // size is correct
            assert(3 == size);
            Assertions.assertEquals(3, size);

        }
        
        // add an element
        method {:test} test_AddElementNotInSet() {

            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // add new element
            testSet.addElement(4);

            // check ensures

            // old elements are still in set
            assert(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);
            Assertions<bool>.assertTrue(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);

            // new element is in set
            assert(4 in testSet.elements);
            Assertions<bool>.assertTrue(4 in testSet.elements);

            // new length is correct
            var size := testSet.size();
            assert(4 == size);
            Assertions.assertEquals(4, size);

            // no duplicate values
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
        }

        // add a duplicate
        method {:test} test_AddElementAlreadyInSet() {

            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // attempt to add a duplicate element
            testSet.addElement(3);

            // check ensures

            // old elements still in set
            assert(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);
            Assertions<bool>.assertTrue(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);

            // length has not changed
            var size := testSet.size();
            assert(3 == size);
            Assertions.assertEquals(3, size);

            // no duplicate values
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
        }

        // remove an element that is in the set
        method {:test} test_RemoveElementInSet() {

            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // remove element
            testSet.removeElement(3);

            // check ensures

            // element is no longer in set
            assert(3 !in testSet.elements);
            Assertions<bool>.assertTrue(3 !in testSet.elements);

            // all other elements still in set
            assert(1 in testSet.elements && 2 in testSet.elements);
            Assertions<bool>.assertTrue(1 in testSet.elements && 2 in testSet.elements);

            // length has decreased
            var size := testSet.size();
            assert(2 == size);
            Assertions.assertEquals(2, size);

            // no duplicates
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);

            // remove element: we remove one more element to ensure branch coverage
            testSet.removeElement(1);

            // check ensures

            // element is no longer in set
            assert(1 !in testSet.elements);
            Assertions<bool>.assertTrue(1 !in testSet.elements);

            // all other elements still in set
            assert(2 in testSet.elements);
            Assertions<bool>.assertTrue(2 in testSet.elements);

            // length has decreased
            size := testSet.size();
            assert(1 == size);
            Assertions.assertEquals(1, size);

            // no duplicates
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
        }

        // remove an element that is not in the set
        method {:test} test_RemoveElementNotInSet() {

            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // remove element
            testSet.removeElement(4);

            // check ensures

            // all other elements still in set
            assert(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);
            Assertions<bool>.assertTrue(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);

            // length is the same
            var size := testSet.size();
            assert(3 == size);
            Assertions.assertEquals(3, size);

            // no duplicates
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
        }
        
        // check if contains returns true if element is in set
        method {:test} test_ContainsElementInSet() {

            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // check if 3 is in the set
            var contains := testSet.contains(3);

            // check ensures

            // contains is true
            assert(contains);
            Assertions<bool>.assertTrue(contains);

            // set still contains all original elements
            assert(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);
            Assertions<bool>.assertTrue(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);

        }

        // check if contains returns false if element is not in set
        method {:test} test_ContainsElementNotInSet() {

            // set up

            // initialize set
            var elems := [1, 2, 3];
            var testSet := new Set.Set(elems);

            // check if 4 is in the set
            var contains := testSet.contains(4);

            // check ensures

            // contains is false
            assert(!contains);
            Assertions<bool>.assertTrue(!contains);

            // set still contains all original elements
            assert(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);
            Assertions<bool>.assertTrue(1 in testSet.elements && 2 in testSet.elements && 3 in testSet.elements);

        }

        // intersect 2 sets
        method {:test} test_IntersectSetsWithCommonElement() {

            // set up

            // initialize sets
            var elems1 := [1, 2, 3];
            var testSet := new Set.Set(elems1);
            var elems2 := [1];
            var intersectSet := new Set.Set(elems2);

            // intersect sets
            var finalSet := testSet.intersect(intersectSet);

            // check ensures

            // common element is in the final set
            assert(1 in finalSet.elements);
            Assertions<bool>.assertTrue(1 in finalSet.elements);

            // length is 1
            var size := finalSet.size();
            expect(1 == size);
            Assertions.expectEquals(size, 1);

            // no duplicates
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: finalSet.elements[i] != finalSet.elements[j]);

        }

        method {:test} test_IntersectSetsWithNoCommonElement() {
            
            // set up

            // initialize sets
            var elems1 := [1, 2, 3];
            var testSet := new Set.Set(elems1);
            var elems2 := [4, 5, 6];
            var intersectSet := new Set.Set(elems2);

            // intersect sets
            var finalSet := testSet.intersect(intersectSet);

            // check ensures

            // length is 0
            var size := finalSet.size();
            expect(0 == size);
            Assertions.expectEquals(size, 0);

            // no duplicates
            assert(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: testSet.elements[i] != testSet.elements[j]);
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: finalSet.elements[i] != finalSet.elements[j]);

        }

        // union 2 sets

        method {:test} test_UnionSetsWithCommonElement() {

            // set up
            
            // initialize sets
            var elems1 := [1, 2, 3];
            var testSet := new Set.Set(elems1);
            var elems2 := [3, 5, 6];
            var unionSet := new Set.Set(elems2);

            // union sets
            var finalSet := testSet.union(unionSet);

            // check ensures

            // correct elements in final set
            assert(1 in finalSet.elements && 2 in finalSet.elements && 3 in finalSet.elements && 5 in finalSet.elements && 6 in finalSet.elements);
            Assertions<bool>.assertTrue(1 in finalSet.elements && 2 in finalSet.elements && 3 in finalSet.elements && 5 in finalSet.elements && 6 in finalSet.elements);

            // length is 5
            var size := finalSet.size();
            expect(5 == size);
            Assertions.expectEquals(size, 5);

            // no duplicates
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: finalSet.elements[i] != finalSet.elements[j]);

        }

        method {:test} test_UnionSetsWithNoCommonElement() {

            // set up
            
            // initialize sets
            var elems1 := [1, 2, 3];
            var testSet := new Set.Set(elems1);
            var elems2 := [4, 5, 6];
            var intersectSet := new Set.Set(elems2);

            // union sets
            var finalSet := testSet.union(intersectSet);

            // check ensures

            // correct elements are in the final set
            assert(1 in finalSet.elements && 2 in finalSet.elements && 3 in finalSet.elements && 4 in finalSet.elements && 5 in finalSet.elements && 6 in finalSet.elements);
            Assertions<bool>.assertTrue(1 in finalSet.elements && 2 in finalSet.elements && 3 in finalSet.elements && 4 in finalSet.elements && 5 in finalSet.elements && 6 in finalSet.elements);

            // length is 6
            var size := finalSet.size();
            expect(6 == size);
            Assertions.expectEquals(size, 6);

            // no duplicates
            Assertions<bool>.assertTrue(forall i, j | 0 <= i < size && 0 <= j < size && j != i :: finalSet.elements[i] != finalSet.elements[j]);
        }
        
        

    }

}