include "Tokeneer.dfy"

module TokeneerTests {

  import opened Tokeneer

  class IdStationTests {

    method {:axiom} freshIdStation() returns (idStation : IdStation)
    ensures fresh(idStation)

    method {:axiom} mockTokenPath0() returns (token : Token) 
    ensures true


    // pc: pc: !a_0 /\ !s_0 /\ t.isF_0 /\ l_0 >= t.getL_0
    // SAT(pc): a = false, s = false, l == 0, t.isF(f) == true, t.getL() = 0
    //
    // Important: no side-effects in contract but still need to capture since the method
    // side-effect and change the later call
    method test_path0() {
      var clearanceLevel : ClearanceLevel := Confidential;
      var i: IdStation := new IdStation.idStation(clearanceLevel);
      i.access := false;
      i.alarm := false;
      i.requiredClearanceLevel := Secret;

      var t : Token;
      var f : int;
      assert(true);
      // assume(t.isValid(f));
      // assume(t.getClearanceLevel() == Confidential);

      // var old_isF := t.isF(f);
      // i.o(t, f);
      // assert(i.s == (old_isF && i.l >= t.getL()));
      // assert(!(old_isF && i.l >= t.getL()) ==> (i.a == t.isF(f)));
    }

// // pc: !a_0 /\ !s_0 /\ t.isF_0 /\ !(l_0 >= t.getL_0)
// // SAT(pc): a = false, s = false, l == 0, t.isF(f) == true, t.getL() = 1
// // Dependency: t.isF(f) (see frame for t.setV(f))
// // SAT(t.v && (f == t.f)): t.v = true, t.f = 0, f = 0 (l is unconstrained)
// method test_path1() {
//    var i: IdStation := new IdStation;
//   i.a := false;
//   i.s := false;
//   i.l := 0;
//   var t: Token := new Token;
//   t.v := true;
//   t.f := 0;
//   var f: int := 0;
//   assume (t.isF(f));
//   assume (t.getL() == 0);
//   var old_isF := t.isF(f);
//   i.o(t, f);
//   assert(i.s == (old_isF && i.l >= t.getL()));
//   assert(!(old_isF && i.l >= t.getL()) ==> (i.a == t.isF(f)));
// }
  }
}