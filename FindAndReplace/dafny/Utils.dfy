module Utils {

    class JUnit5 {

        static method {:axiom} assertEquals<T>(left : T, right : T)
        ensures true

        static method {:axiom} assertNotEquals<T>(left : T, right : T)
        ensures true

        static method {:axiom} assertTrue(value : bool)
        ensures true

        static method {:axiom} assertFalse(value : bool)
        ensures true
    }
}