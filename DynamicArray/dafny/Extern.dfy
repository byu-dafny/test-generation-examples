/* 
    The following code is originally authored by the Secure Foundations Lab.
    It is part of a project to implement the QUIC protocol layer in Dafny.
    The original source can be found here:
    https://github.com/secure-foundations/everquic-dafny/tree/master/src
*/

include "NativeTypes.dfy"

module {:extern "Extern"} Extern {
  import opened NativeTypes

method {:extern "Extern", "newArrayFill"} newArrayFill<T>(n: uint32, t: T) returns (ar: array<T>)
  ensures ar.Length == n as int
  ensures forall i | 0 <= i < n :: ar[i] == t
  ensures fresh(ar)
// {
//   var arr : array<T>;
//   arr := new T[n](i => t);
//   return arr;
// }


  method {:extern "Extern", "fatal"} fatal(m:string)
    ensures false

  method {:extern "Extern", "fatal_assume"} fatal_assume(ghost b:bool)
    ensures b;
}
