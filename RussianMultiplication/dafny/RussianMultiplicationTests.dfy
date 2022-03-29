include "RussianMultiplication.dfy"
include "Utils.dfy"

module RussianMultiplicationTests {

    import opened RussianMultiplication
    import opened Utils

    class RussianMultiplicationTests {

        method {:test} test_mult_should_keepSigns_when_n0IsPositive()
        {
            var n0 := 5;
            var m0 := 3;

            var res := mult(n0, m0);

            assert(res == n0 * m0);
            Assertions.assertEquals(res, n0 * m0);
        }

        method {:test} test_mult_should_switchSigns_when_n0IsNegative()
        {
            var n0 := -5;
            var m0 := 3;

            var res := mult(n0, m0);

            assert(res == n0 * m0);
            Assertions.assertEquals(res, n0 * m0);
        }
    }
}