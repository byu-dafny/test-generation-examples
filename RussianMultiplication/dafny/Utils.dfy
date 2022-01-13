module Utils {

    class JUnit5 {

        static method {:axiom} assertEquals<T>(left : T, right : T)
        requires left == right

        static method {:axiom} assertNotEquals<T>(left : T, right : T)
        requires left != right

        static method {:axiom} assertTrue(value : bool)
        requires value

        static method {:axiom} assertFalse(value : bool)
        requires !value
    }
}