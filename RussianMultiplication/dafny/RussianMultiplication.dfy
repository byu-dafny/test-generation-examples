module RussianMultiplication {
    
    export provides mult, mult2

    method mult(n0 : int, m0 : int) returns (res : int)
    ensures res == (n0 * m0);
    {
        var n, m : int;
        res := 0;
        if (n0 >= 0) {
            n,m := n0, m0;
        } 
        else {
            n,m := -n0, -m0;
        }
        while (0 < n)
        invariant (m * n + res) == (m0 * n0);
        decreases n; 
        { 
            res := res + m; 
            n := n - 1; 
        }
    }

    /*
        Originally authored by Matt Pope.  Some assertions were added for verification.
    */

    method mult2(n0 : int, m0 : int) returns (res:int) 
    ensures res == (n0 * m0)
    decreases n0
    {
        if (n0 == 0) {
            return 0;
        }
        if (n0 % 2 == 0) {
            var inner := mult2(n0 / 2, m0); // TODO: unable to prove termination, even though n0 = 1 / 2 should give our base case
            assert inner == (n0 / 2) * m0;
            return 2 * inner;
        } else {
            var inner := mult2((n0 - 1) / 2, m0);
            assert inner == ((n0 - 1) / 2) * m0;
            return m0 + 2 * inner;
        }
    }
}