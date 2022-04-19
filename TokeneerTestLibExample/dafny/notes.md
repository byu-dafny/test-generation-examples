
shell game --> at some point you have to have assurance that what is written is what is wanted and is correct.
]
Contract can be 
  * hard to understand
  * Underspecified: key behavior can be whatever!
  * Implementation can be over specified: a => b What is a is always false? What if the code never exercises some part of the contract? How would you ever know that?
  * Contract is not consistent: says an output is true and false at the same time. It can prove anything from there.
  * Contract is over specified: cannot prove anything or it becomes to complicated to deal with.
  * Have a proof? What was actually proven? Algebraic properties? Computation? Somebody wrote two versions of the same thing because the proof shows equivalence. But are either correct computation?

Always, at some point, input to output wants to be tested. Tell story of theorem proving friend. In the end, had to write a test harness, even after proofs where done, to check that input to output behavior to be sure the specification actually said what you thought it did.

Tons of thought. Tons of code review. But people are blind and miss things. Princess bride, I don't think that word means what you think it means---inconceible.

Not solving the problem of assurance, moving the problem.

method {:extern} _f(a : int) returns (y : int);

method f(a : int) returns (y :int) 
  requires a > 0
{
    expect a > 0
    _f(a)
}

method {:test "shouldThrow"} () {
    f(0) // dafny should error -- violates pre-condition 
}