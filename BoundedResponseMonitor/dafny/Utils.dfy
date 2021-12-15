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
    // Add requires that says the requires on the original method should be violated. 
    // Do it in the same way as done for assertions.
    static method {:extern} 
    checkRequires_boundedResponse(lowerBound: int, upperBound: int)
    requires !(lowerBound >= 0 && lowerBound <= upperBound)
  }
}