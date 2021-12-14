include "sha3.dfy"

module Sha3Tests {
    import opened Sha3

    class Sha3Tests {
        predicate equal_arr(a : array2<bv64>, b : array2<bv64>) 
            reads a, b
            requires is_5x5(a) && is_5x5(b)
            {
                forall i :: 0 <= i < 25 ==> a[i / 5, i % 5] == b[i / 5, i % 5]
        }

        predicate p_initialState(state : array2<bv64>) 
            reads state 
            {
            is_5x5(state)
            
            && state[0,0] == 0xe9e0000000000000
            && state[0,1] == 0x0000000000000000
            && state[0,2] == 0x0000000000000000
            && state[0,3] == 0x0000000000000000
            && state[0,4] == 0x0000000000000000

            && state[1,0] == 0x0000000000000000
            && state[1,1] == 0x0000000000000000
            && state[1,2] == 0x0000000000000000
            && state[1,3] == 0x0000000000000000
            && state[1,4] == 0x0000000000000000
            
            && state[2,0] == 0x0000000000000000
            && state[2,1] == 0x0000000000000000
            && state[2,2] == 0x0000000000000000
            && state[2,3] == 0x0000000000000000
            && state[2,4] == 0x0000000000000000
            
            && state[3,0] == 0x0000000000000000
            && state[3,1] == 0x0000000000000000
            && state[3,2] == 0x0000000000000000
            && state[3,3] == 0x0000000000000000
            && state[3,4] == 0x0000000000000000
            
            && state[4,0] == 0x0000000000000001
            && state[4,1] == 0x0000000000000000
            && state[4,2] == 0x0000000000000000
            && state[4,3] == 0x0000000000000000
            && state[4,4] == 0x0000000000000000
        }
        method initialState() returns (out : array2<bv64>) 
            ensures is_5x5(out)
            ensures p_initialState(out) {
            out := new bv64[5, 5];
            out[0,0] := 0xe9e0000000000000;
            out[0,1] := 0x0000000000000000;
            out[0,2] := 0x0000000000000000;
            out[0,3] := 0x0000000000000000;
            out[0,4] := 0x0000000000000000;
            
            out[1,0] := 0x0000000000000000;
            out[1,1] := 0x0000000000000000;
            out[1,2] := 0x0000000000000000;
            out[1,3] := 0x0000000000000000;
            out[1,4] := 0x0000000000000000;

            out[2,0] := 0x0000000000000000;
            out[2,1] := 0x0000000000000000;
            out[2,2] := 0x0000000000000000;
            out[2,3] := 0x0000000000000000;
            out[2,4] := 0x0000000000000000;

            out[3,0] := 0x0000000000000000;
            out[3,1] := 0x0000000000000000;
            out[3,2] := 0x0000000000000000;
            out[3,3] := 0x0000000000000000;
            out[3,4] := 0x0000000000000000;

            out[4,0] := 0x0000000000000001;
            out[4,1] := 0x0000000000000000;
            out[4,2] := 0x0000000000000000;
            out[4,3] := 0x0000000000000000;
            out[4,4] := 0x0000000000000000;
        } 

        // method thetaFinalState() returns (out : array2<bv64>) 
        //     ensures out.Length0 == 5 && out.Length1 == 5 {
            // out := new bv64[5, 5];
        // }
        //method testTheta() { }

        predicate p_rhoFinalState(state : array2<bv64>) 
            reads state
            {
            is_5x5(state)
            
            && state[0,0] == 0xe9e0000000000000
            && state[0,1] == 0x0000000000000000
            && state[0,2] == 0x0000000000000000
            && state[0,3] == 0x0000000000000000
            && state[0,4] == 0x0000000000000000

            && state[1,0] == 0x0000000000000000
            && state[1,1] == 0x0000000000000000
            && state[1,2] == 0x0000000000000000
            && state[1,3] == 0x0000000000000000
            && state[1,4] == 0x0000000000000000
            
            && state[2,0] == 0x0000000000000000
            && state[2,1] == 0x0000000000000000
            && state[2,2] == 0x0000000000000000
            && state[2,3] == 0x0000000000000000
            && state[2,4] == 0x0000000000000000
            
            && state[3,0] == 0x0000000000000000
            && state[3,1] == 0x0000000000000000
            && state[3,2] == 0x0000000000000000
            && state[3,3] == 0x0000000000000000
            && state[3,4] == 0x0000000000000000
            
            && state[4,0] == 0x0000000000040000
            && state[4,1] == 0x0000000000000000
            && state[4,2] == 0x0000000000000000
            && state[4,3] == 0x0000000000000000
            && state[4,4] == 0x0000000000000000
        }
        method rhoFinalState() returns (out : array2<bv64>) 
            ensures is_5x5(out) 
            ensures p_rhoFinalState(out) {
            out := new bv64[5, 5];
            out[0,0] := 0xe9e0000000000000;
            out[0,1] := 0x0000000000000000;
            out[0,2] := 0x0000000000000000;
            out[0,3] := 0x0000000000000000;
            out[0,4] := 0x0000000000000000;
            
            out[1,0] := 0x0000000000000000;
            out[1,1] := 0x0000000000000000;
            out[1,2] := 0x0000000000000000;
            out[1,3] := 0x0000000000000000;
            out[1,4] := 0x0000000000000000;
            
            out[2,0] := 0x0000000000000000;
            out[2,1] := 0x0000000000000000;
            out[2,2] := 0x0000000000000000;
            out[2,3] := 0x0000000000000000;
            out[2,4] := 0x0000000000000000;
            
            out[3,0] := 0x0000000000000000;
            out[3,1] := 0x0000000000000000;
            out[3,2] := 0x0000000000000000;
            out[3,3] := 0x0000000000000000;
            out[3,4] := 0x0000000000000000;
            
            out[4,0] := 0x0000000000040000;
            out[4,1] := 0x0000000000000000;
            out[4,2] := 0x0000000000000000;
            out[4,3] := 0x0000000000000000;
            out[4,4] := 0x0000000000000000;
        }
        method testRho() {
            var inState : array2<bv64> := initialState();
            var rhoState : array2<bv64> := rho(inState);
            var outState : array2<bv64> := rhoFinalState();
            assert(equal_arr(rhoState, outState));
        }

        method chiFinalState() returns (out : array2<bv64>) 
            ensures is_5x5(out) {
            out := new bv64[5, 5];
        }
        method testChi() {
            var state : array2<bv64> := initialState();
            
        }

        method piFinalState() returns (out : array2<bv64>) 
            ensures is_5x5(out) {
            out := new bv64[5, 5];
        }
        method testPi() {
            var state : array2<bv64> := initialState();
            
        }

        method iotaFinalState() returns (out : array2<bv64>) 
            ensures is_5x5(out) {
            out := new bv64[5, 5];
        }
        method testIota() {
            var state : array2<bv64> := initialState();
            
        }
    }
}