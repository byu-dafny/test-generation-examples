include "RussianMultiplication.dfy"

module RussianMultiplicationTests {

    import opened RussianMultiplication

    method mult_should_keepSignsWhenN0IsPositive()
    {
        var n0 := 5;
        var m0 := 3;

        var res := mult(n0, m0);

        assert res == n0 * m0;
    }

    method mult_should_switchSigns_when_n0IsNegative()
    {
        var n0 := -5;
        var m0 := 3;

        var res := mult(n0, m0);

        assert res == n0 * m0;
    }

    method mult2_should_reachBothTypesOfRecursiveCalls()
    {
        var n0 := 10;
        var m0 := 3;

        var res := mult2(n0, m0);

        assert res == n0 * m0;
    }
}