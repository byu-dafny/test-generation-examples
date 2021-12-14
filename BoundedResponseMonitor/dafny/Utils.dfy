module Utils {
  class Assertions<T> {
    static method {:extern} assertEquals(expected : T, actual : T)
    requires expected == actual

    static method {:extern} assertTrue(condition : bool)
    requires condition

    static method {:extern} assertFalse(condition : bool)
    requires !condition
  }

  class BoundedResponseTestSupport {
    static method {:extern} 
    checkRequires_boundedResponse(lowerBound: int, upperBound: int)
    ensures true
  }
}