# Dafny Unit Test Interface

**Assertion Library**: provides basic assertions.
Need to include both tags. Not just the one. But I think it better to just have the one.
Explore what happens if you give a name for the `:extern` annotator.

```dafny
method {extern:} {:test "JUnit5", "XUnit", ...} test_constructor_should_doNothing_when_inputValid()
{
  var lowerBound : int := 0;
  var upperBound : int := 1;

  var testSubject : BoundedResponse<int> :=
    new BoundedResponse.boundedResponse(lowerBound, upperBound);
    
  Assertions<int>.assertEquals(testSubject.ALERT, upperBound + 1);
  Assertions<int>.assertEquals(testSubject.LOWERBOUND, lowerBound);
  Assertions<int>.assertEquals(testSubject.UPPERBOUND, upperBound);
  Assertions<int>.assertEquals(testSubject.state, testSubject.INIT);
  Assertions<bool>.assertFalse(testSubject.isLatched);
  Assertions<bool>.assertFalse(testSubject.policy);
  Assertions<bool>.assertFalse(testSubject.alert);
}
```

The Assertions library `requires` the expected condition so Dafny proves out.

```dafny
class Assertions<T> {
  static method {:extern} assertEquals(expected : T, actual : T)
  requires expected == actual

  static method {:extern} assertTrue(condition : bool)
  requires condition

  static method {:extern} assertFalse(condition : bool)
  requires !condition

  ...

}
```

The is a Java implementation existing for `JUnit5`.

Add an `Assertions.assertEnsures("method")` that automatically includes assertions for the contract on the method.

**Method Annotation** `{:test <framework>}`: indicates a method is a unit test and should be annotated as such in the generated Java file. The annotation for the test depends on the indicated framework. 

```dafny
method {:test "JUnit5"} test_constructor_should_throwException_when_lowerBoundLessThanZero() 
{
  BoundedResponseTestSupport.checkRequires_boundedResponse(-1, 0);
}
```

**Method Annotation** `{:fresh}`: indicates the method produces a fresh instance of some object. The object is unconstrained.

```dafny
static method {:fresh} fresh_IdStation() returns (idStation : IdStation)
    ensures fresh(idStation)
```

**Method Annotation** `{:mock <framework>}`: indicates a method creates a mock.

```dafny
static method {:mock "Mockito"} mock_Token_OpenVersion0_NotIsValid() returns (token : Token) 
  ensures fresh(token)
  ensures forall fingerprint : int :: token.f_isValid(fingerprint) == false;
```

A method annotated with `{:mock}` may take some parameters, `x,y,...`. Post-conditions define the behavior of the mock using universal (or existential) quantifiers.

 ```
 forall a,b,... :: (func1(a,b,...) => object.method(a,b,...) == func2(a,b,...,x,y,...))
 ```
 
Here, `object` is the mocked object, `method` is one of the method being defined in the mock, `func1` defines allowed inputs parameters, and `func2` is the return. 

Only methods that do not side-effect can be mocked.

{:mockNew }
# Test Generation Algorithms

  * Block coverage
  * Path coverage
  * Branch coverage
  * MC/DC coverage
  * Input partitioning (see example)

# Oracle Generation

Synthesize oracles from ensures-statements on contracts.
