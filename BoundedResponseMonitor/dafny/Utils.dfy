module Utils {
  class Assertions {
    static method {:extern} assertEquals(expected : bool, actual : bool)
    ensures true

    static method {:extern} assertTrue(condition : bool)
    ensures true

    static method {:extern} assertFalse(condition : bool)
    ensures true
  }
}