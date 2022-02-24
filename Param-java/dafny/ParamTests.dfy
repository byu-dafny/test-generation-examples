include "Param.dfy"
include "Utils.dfy"



module ParamTests {

    import opened Param
    import opened Utils

    class CalculatorTests {

        static method AddSource() returns (testInputs : seq<(string, string, string)>)
        {
            return [
                ("a", "b", "ab"),
                ("loss", "love", "losslove")
            ];
        }

        method {:test "MethodSource", "AddSource"} test_add_shouldAddTwoArguments(a : string, b : string, expected : string) 
        requires expected == a + b {
            var sum := Calculator.add(a, b);
            Assertions.assertEquals(expected, sum);
        }

        static method MultSource() returns (testInputs : seq<(int, int, int)>)
        {
            return [
                (2, 3, 6),
                (40, -2, -80),
                (-7, -7, 49)
            ];
        }

        method {:test "MethodSource", "MultSource"} test_mult_shouldMultTwoArguments(a : int, b : int, expected : int) 
        requires expected == a * b {
            var product := Calculator.mult(a, b);
            Assertions.assertEquals(expected, product);
        }

        static method ArrayEqualSource() returns (testInputs : seq<(array<int>, array<int>, bool)>)
        {
            var a := new int[2] [3, 5];
            var b := new int[3] [3, 5, 6];
            return [
                (a, a, true),
                (a, b, false)
            ];
        }

        method {:test "MethodSource", "ArrayEqualSource"} test_arrayEqual_shouldCompareTwoArgs(a : array<int>, b : array<int>, expected : bool) 
        requires if a == b then expected else !expected {
            var result := Calculator.arrayEqual(a, b);
            Assertions.assertEquals(expected, result);
        }

        static method SeqPrefixSource() returns (testInputs : seq<(seq<char>, seq<char>, bool)>)
        {
            return [
                (['a', 'g'], ['j', 'p'], false),
                (['j'], ['j', 'k'], true)
            ];
        }

        method {:test "MethodSource", "SeqPrefixSource"} test_seqPrefix_shouldSeeIfAIsPrefixOfB(a : seq<char>, b : seq<char>, expected : bool) 
        requires if a < b then expected else !expected {
            var result := Calculator.seqPrefix(a, b);
            Assertions.assertEquals(expected, result);
        }
    }

}
    