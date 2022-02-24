include "Utils.dfy"


module Param {

    export reveals Calculator
            provides Calculator.add, Calculator.mult, Calculator.arrayEqual, Calculator.seqPrefix

    class Calculator {

        static method mult(a : int, b : int) returns (res : int)
        ensures a * b == res {
            return a * b;
        }

        static method add(a : string, b : string) returns (res : string)
        ensures res == a + b {
            return a + b;
        }

        static method arrayEqual(a : array<int>, b : array<int>) returns (res : bool)
        ensures if a == b then res else !res {
            if (a == b) {
                return true;
            }
            else {
                return false;
            }
        }

        static method seqPrefix(a : seq<char>, b : seq<char>) returns (res : bool)
        ensures if a < b then res else !res {
            if (a < b) {
                return true;
            }
            else {
                return false;
            }
        }
    }

}