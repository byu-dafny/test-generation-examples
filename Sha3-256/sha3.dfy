/*
    Implements Sha3-256 round functions
    TODO: Finish 3 part theta function
    -Write a functional method equivalent to what is in the cryptol implementation
    -Get it to prove equal to an imperative method
    TODO: Check that our "ensures" are strong enough to prove out
    TODO: Could lemmas help the proof speed? 
*/

module Sha3 {
    type uint8   = i:int | 0 <= i < 0x100
    type uint16  = i:int | 0 <= i < 0x10000
    type uint32  = i:int | 0 <= i < 0x1_0000_0000
    type uint64  = i:int | 0 <= i < 0x1_0000_0000_0000_0000
    type uint128 = i:int | 0 <= i < 0x1_00000000_00000000_00000000_00000000

    predicate is_5x5(a : array2<bv64>)
    {
        a.Length0 == 5 && a.Length1 == 5 
    }

    // method theta_d(c : array<bv64>) returns (d: array<bv64>)
    //     requires c.Length == 5
    //     ensures d.Length == 5
    //     ensures forall x : int :: 0 <= x < 5 ==> d[x] == c[(x - 1) % 5] ^ ((c[(x + 1) % 5] << 1) | (c[(x + 1) % 5] >> 63))
    //     {
    //         d := new bv64[5];
    //         for x : int := 0 to 4 
    //             modifies d 
    //             invariant d.Length == 5 
    //             invariant forall j : int :: 0 <= j < x ==> d[j] == c[(j - 1) % 5] ^ ((c[(j + 1) % 5] << 1) | (c[(j + 1) % 5] >> 63)) {
    //             d[x] := c[(x - 1) % 5] ^ ((c[(x + 1) % 5] << 1) | (c[(x + 1) % 5] >> 63));
    //         }
    // }
    // function f_theta_c(state : array2<bv64>, i : int, x : int) : (c : seq<bv64>)
    //     reads state
    //     requires is_5x5(state)
    //     ensures |c| == x - i
    //     requires 0 <= i <= x <= 5
    //     decreases x-i
    //     {
    //         if i == x then []
    //         else var k : int := (i+1)%5; 
    //             [state[0, k] ^ state[1, k] ^ state[2, k] ^ state[3, k] ^ state[4, k]] + f_theta_c(state, i + 1, x)
    // }
    // method theta_c(state : array2<bv64>) returns (c: array<bv64>)
    //     requires is_5x5(state)
    //     ensures c.Length == 5
    //     {
    //         c := new bv64[5];
    //         for x : int := 0 to 5 
    //             modifies c 
    //             invariant c.Length == 5 
    //             invariant var l : seq<bv64> := f_theta_c(state, 0, x); 
    //                 forall j : int :: 0 <= j < x ==> c[j] == l[j]
    //             {
    //             var k : int := (x+1)%5;
    //             c[x] := state[0, k] ^ state[1, k] ^ state[2, k] ^ state[3, k] ^ state[4, k];
    //         }
    // }
    // method theta_c(state : array2<bv64>) returns (out : array2<bv64>)
    //     requires is_5x5(state)
    //     ensures is_5x5(out)
    //     ensures f_theta(state, out, 25)
    //     {
    //     out := new bv64[5, 5];
    //     for i : int := 0 to 25
    //         modifies out
    //         invariant is_5x5(out)
    //         invariant f_theta(state, out, i)
    //         {
    //             var y : int := i / 5;
    //             var x : int := i % 5;
    //             out[y, x] := state[y,x] ^
    //     state[(x - 1) % 5, 0] ^ state[(x - 1) % 5, 1] ^ state[(x - 1) % 5, 2] ^ state[(x - 1) % 5, 3] ^ state[(x - 1) % 5, 4]
    //         ^ (((state[(x + 1) % 5, 0] ^ state[(x + 1) % 5, 1] ^ state[(x + 1) % 5, 2] ^ state[(x + 1) % 5, 3] ^ state[(x + 1) % 5, 4]) << 1)
    //         | ((state[(x + 1) % 5, 0] ^ state[(x + 1) % 5, 1] ^ state[(x + 1) % 5, 2] ^ state[(x + 1) % 5, 3] ^ state[(x + 1) % 5, 4]) >> 63));
    //     }
    // }

    function f_rhotates(i : int) : (out : int)
        requires 0 <= i < 25
        ensures 0 <= out <= 64
        {
        if i == 0 then 0
        else if i == 1 then 1
        else if i == 2 then 62
        else if i == 3 then 28
        else if i == 4 then 27
        else if i == 5 then 36
        else if i == 6 then 44
        else if i == 7 then 6
        else if i == 8 then 55
        else if i == 9 then 20
        else if i == 10 then 3
        else if i == 11 then 10
        else if i == 12 then 43
        else if i == 13 then 25
        else if i == 14 then 39
        else if i == 15 then 41
        else if i == 16 then 45
        else if i == 17 then 15
        else if i == 18 then 21
        else if i == 19 then 8
        else if i == 20 then 18
        else if i == 21 then 2
        else if i == 22 then 61
        else if i == 23 then 56
        else 14
    }
    method rhotates(i : int) returns (out : int)
        requires 0 <= i < 25
        ensures out == f_rhotates(i)
        ensures 0 <= out <= 64
        {   
        if i == 0 { return  0; }
        else if i == 1 { return 1; }
        else if i == 2 { return 62; }
        else if i == 3 { return 28; }
        else if i == 4 { return 27; }
        else if i == 5 { return 36; }
        else if i == 6 { return 44; }
        else if i == 7 { return 6; }
        else if i == 8 { return 55; }
        else if i == 9 { return 20; }
        else if i == 10 { return 3; }
        else if i == 11 { return 10; }
        else if i == 12 { return 43; }
        else if i == 13 { return 25; }
        else if i == 14 { return 39; }
        else if i == 15 { return 41; }
        else if i == 16 { return 45; }
        else if i == 17 { return 15; }
        else if i == 18 { return 21; }
        else if i == 19 { return 8; }
        else if i == 20 { return 18; }
        else if i == 21 { return 2; }
        else if i == 22 { return 61;}
        else if i == 23 { return 56;}
        else { return 14; }
    }

    function f_lcycle(b : bv64, i : int) : bv64
        requires 0 <= i <= 64
        {
        (b << i) | (b >> (64 - i))
    }
    method lcycle(b : bv64, i : int) returns (out : bv64)
        requires 0 <= i <= 64
        ensures out == f_lcycle(b, i)
        {
        out := (b << i) | (b >> (64 - i));
    }

    predicate p_rho(state : array2<bv64>, out : array2<bv64>, i : int)
        reads state, out
        requires is_5x5(state)
        requires is_5x5(out)
        requires i <= 25
        {
        forall j : int :: 0 <= j < i ==> out[j/5, j%5] == f_lcycle(state[j/5, j%5], f_rhotates(j))
    }
    method rho(state : array2<bv64>) returns (out : array2<bv64>)
        requires is_5x5(state)
        ensures is_5x5(out)
        ensures p_rho(state, out, 25)
        {
        out := new bv64[5, 5];
        for i : int := 0 to 25
            modifies out
            invariant is_5x5(out)
            invariant p_rho(state, out, i)
            {
                var y : int := i / 5;
                var x : int := i % 5;
                var rhot : int := rhotates(i);
                out[y, x] :=  lcycle(state[y, x], rhot);
        }
    }

    predicate p_pi(state : array2<bv64>, out : array2<bv64>, i : int)
        reads state, out
        requires is_5x5(state)
        requires is_5x5(out)
        requires i <= 25
        {
        forall j : int :: 0 <= j < i ==> out[j/5, j%5] == state[j%5, (j%5 + 3*(j/5)) % 5] 
    }
    method pi(state : array2<bv64>) returns (out : array2<bv64>)
        requires is_5x5(state)
        ensures is_5x5(out)
        ensures p_pi(state, out, 25)
        {
        out := new bv64[5, 5];
        for i : int := 0 to 25
            modifies out
            invariant is_5x5(out)
            invariant p_pi(state, out, i)
            {
                var y : int := i / 5;
                var x : int := i % 5;
                out[y, x] := state[x, (x + 3*y) % 5];
        }
    } 

    predicate p_chi(state : array2<bv64>, out : array2<bv64>, i : int)
        reads state, out
        requires is_5x5(state)
        requires is_5x5(out)
        requires i <= 25
        {
        forall j : int :: 0 <= j < i ==> 
        out[j/5, j%5] == state[j%5, j/5] ^ ((state[j/5, (j%5 + 1) % 5] ^ 0xffffffffffffffff) & state[j/5, (j%5 + 2) % 5])  
    }
    method chi(state : array2<bv64>) returns (out : array2<bv64>)
        requires is_5x5(state)
        ensures is_5x5(out)
        ensures p_chi(state, out, 25)
        {
        out := new bv64[5, 5];
        for i : int := 0 to 25
            modifies out
            invariant is_5x5(out)
            invariant p_chi(state, out, i)
            {
                var y : int := i / 5;
                var x : int := i % 5;
            out[y, x] := state[x, y] ^ ((state[y, (x + 1) % 5] ^ 0xffffffffffffffff) & state[y, (x + 2) % 5]);
        }
    }

    function f_iotas(i : int) : bv64 
        requires 0 <= i < 24
        {
        if i == 0 then 0x0000000000000001
        else if i == 1 then 0x0000000000008082
        else if i == 2 then 0x800000000000808a
        else if i == 3 then 0x8000000080008000
        else if i == 4 then 0x000000000000808b
        else if i == 5 then 0x0000000080000001

        else if i == 6 then 0x8000000080008081
        else if i == 7 then 0x8000000000008009
        else if i == 8 then 0x000000000000008a
        else if i == 9 then 0x0000000000000088
        else if i == 10 then 0x0000000080008009
        else if i == 11 then 0x000000008000000a

        else if i == 12 then 0x000000008000808b
        else if i == 13 then 0x800000000000008b
        else if i == 14 then 0x8000000000008089
        else if i == 15 then 0x8000000000008003
        else if i == 16 then 0x8000000000008002
        else if i == 17 then 0x8000000000000080

        else if i == 18 then 0x000000000000800a
        else if i == 19 then 0x800000008000000a
        else if i == 20 then 0x8000000080008081
        else if i == 21 then 0x8000000000008080
        else if i == 22 then 0x0000000080000001
        else 0x8000000080008008
    }

    method iotas() returns (out : array<bv64>)
        ensures out.Length == 24
        ensures forall i : int :: 0 <= i < 24 ==> out[i] == f_iotas(i)
        {   
        out := new bv64[24];
        out[0]:=0x0000000000000001;
        out[1]:=0x0000000000008082;
        out[2]:=0x800000000000808a;
        out[3]:=0x8000000080008000;
        out[4]:=0x000000000000808b;
        out[5]:=0x0000000080000001;

        out[6]:=0x8000000080008081;
        out[7]:=0x8000000000008009;
        out[8]:=0x000000000000008a;
        out[9]:=0x0000000000000088;
        out[10]:=0x0000000080008009;
        out[11]:=0x000000008000000a;

        out[12]:=0x000000008000808b;
        out[13]:=0x800000000000008b;
        out[14]:=0x8000000000008089;
        out[15]:=0x8000000000008003;
        out[16]:=0x8000000000008002;
        out[17]:=0x8000000000000080;

        out[18]:=0x000000000000800a;
        out[19]:=0x800000008000000a;
        out[20]:=0x8000000080008081;
        out[21]:=0x8000000000008080;
        out[22]:=0x0000000080000001;
        out[23]:=0x8000000080008008;
    }

    predicate p_eq(state : array2<bv64>, out : array2<bv64>, a : int, b : int)
        requires is_5x5(state)
        requires is_5x5(out)
        requires 0 <= a <= b <= 25
        reads state, out
        {
        forall j : int :: a <= j < b ==> out[j/5, j%5] == state[j/5, j%5]
    }
    predicate p_iota(state : array2<bv64>, out : array2<bv64>, i : int)
        requires is_5x5(state)
        requires is_5x5(out)
        requires 0 <= i < 24
        reads state, out
        {
        out[0,0] == f_iotas(i) ^ state[0,0] && p_eq(state, out, 1, 25)
    }
    method iota(state : array2<bv64>, i : int) returns (out : array2<bv64>)
        requires is_5x5(state)
        requires 0 <= i < 24
        ensures is_5x5(out)
        ensures p_iota(state, out, i)
        {
        out := new bv64[5, 5];
        
        for i : int := 1 to 25
            modifies out
            invariant is_5x5(out)
            invariant p_eq(state, out, 1, i)
            {
            var y : int := i / 5;
            var x : int := i % 5;
            out[y, x] := state[y, x];
        }
        var iots : array<bv64> := iotas();
        out[0,0] := iots[i] ^ state[0,0];
    }


    method Main() {
        // var state := new bv64[5, 5];
        // state := theta(state);
        // print state[0, 0];
    }

    // (pad ((0xe9) # 0b11) (0:[256]))
    //[[0xe9e0000000000000, 0x0000000000000000, 0x0000000000000000,
    //   0x0000000000000000, 0x0000000000000000],
    //  [0x0000000000000000, 0x0000000000000000, 0x0000000000000000,
    //   0x0000000000000000, 0x0000000000000000],
    //  [0x0000000000000000, 0x0000000000000000, 0x0000000000000000,
    //   0x0000000000000000, 0x0000000000000000],
    //  [0x0000000000000000, 0x0000000000000000, 0x0000000000000000,
    //   0x0000000000000000, 0x0000000000000000],
    //  [0x0000000000000001, 0x0000000000000000, 0x0000000000000000,
    //   0x0000000000000000, 0x0000000000000000]]
}