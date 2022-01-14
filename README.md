# Dafny Unit Test Interface

## Tests with no input

Tests with no input correspond to a `[Fact]` in the XUnit framework. 

The `{:test}` annotation with no arguments is a test that takes no input. The C# cross-compiler inserts the `[Xunit.Fact]` annotation on each method with the `{:test}` attribute. The Java, Go, and other cross-compilers do nothing.

```dafny
static method {:test} TestIsEmptyTrue() {
  var list := GetEmptyList<int>();    
  var empty := list.IsEmpty();
  expect empty;
}
```

The cross-compiler renders the following in C#

```csharp
[Xunit.Fact]
public static void TestIsEmptyTrue()
{
  PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _436_list;
  PrivateDLL_Compile.PrivateDoublyLinkedList<BigInteger> _out0;
  _out0 = PrivateDLLTests_Compile.__default.GetEmptyList<BigInteger>();
  _436_list = _out0;
  bool _437_empty;
  bool _out1;
  _out1 = (_436_list).IsEmpty();
  _437_empty = _out1;
  if (!(_437_empty)) {
    throw new Dafny.HaltException("/home/sasha/Desktop/QUIC-Dafny-Tests/QUIC/PrivateDLLTests.dfy(132,12): " + Dafny.Sequence<char>.FromString("expectation violation"));
  }
}
```

Here the test method uses the `expect`-statement for run-time checks. Dafny *assumes* `empty` to be true in the verification. The run-time check throws the exception if `empty` is false. 

The `{test:}` attribute needs support for Java and Go. It might consider allowing the user to specify the target framework as in `{test: "JUnit5", "XUnit2.4.1"}`. 

## Tests with Input

Tests that take input correspond to a `[Theory]` in the XUnit framework.

The `{test: "methodSource"}` annotation indicates the provider for the test method arguments. The provider should be a static method that returns a sequence of tuples. Each tuple is an input to the annotated test method.

The below example uses the `assert`-based methods forcing Dafny to prove out the test method. The `requires` clause satisfies the proof.

```Dafny
static method paramterized_assert_provider() returns (testInputs : seq<(int, int, int)>)
{
  testInputs := [
    (0, 0, 0),
    (1, 1, 2),
    (4, 7, 11)
  ];
}

method {:test "parameterized_assert_provider"} parameterized_assert(x : int, y : int, expected : int)
requires expected == x + y
{
  var sum : int := x + y;
  Assertions.assertEquals(expected, sum);
}
```

The same thing can be accomplished using `expect`-based tests that bypass the Dafny proof (see below).

```Dafny
static method paramterized_expect_provider() returns (testInputs : seq<(int, int, int)>)
{
  testInputs := paramterized_assert_provider();
}

method {:test "parameterized_expect_provider"} parameterized_expect(x : int, y : int, expected : int)
{
  var sum : int := x + y;
  Assertions.expectEquals(expected, sum);
}
```

Dafny does not prove anything about `parameterized_expect` in the above example.

The automation for parameterized tests is missing at the moment, but for Java, it does require some effort. The Dafny sequence of tuples is converted to a `Stream` of `Arguments` for the JUnit 5 support. Also, Dafny does not prove out each individual test. Only the cross-compiled code recognizes each input as a separate test.

## Assertion Library

Dafny unit testing needs two types of assertion library: one that can be proved out and another that assumes correctness. The first lets Dafny actual prove the assertion and works in codes with relatively strong contracts on method calls. The second lets Dafny assume the assertion without proving it and works in codes with weak contracts on method calls. Both libraries provide run-time checks.

There is no consensus on naming conventions in assertion libraries amongst the various test frameworks. All frameworks provide a relatively uniform set of assertions but each has a slightly different naming convention and use. The current library adopts a JUnit5 naming convention, but it could just as easily adopt an XUnit convention.

```dafny
method {:test} test_constructor_should_doNothing_when_inputValid()
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

The **assert**-based methods `requires` the expected condition so Dafny proves out while the **expect**-based methods `ensures` the conditions effectively *assuming* the condition. 

```dafny
class Assertions<T> {
  static method {:extern} assertEquals(expected : T, actual : T)
  requires expected == actual

  static method {:extern} expectEquals(expected : T, actual : T)
  ensures expected == actual
  
  static method {:extern} assertTrue(condition : bool)
  requires condition

  static method {:extern} expectTrue(condition : bool)
  ensures condition
  
  static method {:extern} assertFalse(condition : bool)
  requires !condition

  static method {:extern} expectFalse(condition : bool)
  ensures !condition
}
```

The assuming behavior of the **expect**-based version of the methods match the behavior of the `expect`-statement in Dafny. The `expect cond` statement `assumes cond` and inserts a runtime check that throws an exception if `cond` is ever false at run-time in the cross-compiled program.

The following is an example of the **expect**-based methods. Here it expects `m` to be true even though `m` is declared to be `false`.

```Dafny
method {:test} test_expect_behavior()
{
  var m : bool := false;

  Assertions<bool>.expectTrue(m);
  assert(m);
}
```

Dafny proves the file correct. This behavior, assuming the condition, matches the equivalent Dafny code using the `expect`-statement.

```Dafny
method {:test} test_expect_behavior()
{
  var m : bool := false;

  expect m;
  assert(m);
}
```

The library should include some means to support an `Assertions.assertEnsures("method")` that automatically includes assertions for the contract on the method.

## Created Fresh Instances (zero-argument constructors)

 `{:fresh}`: indicates the method produces a fresh instance of some object. The object is unconstrained.

```dafny
static method {:fresh} fresh_IdStation() returns (idStation : IdStation)
    ensures fresh(idStation)
```

## Creating Mocks

`{:mock}`: indicates a method creates a mock.

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

## Mocking with Fresh

`{:mockNew }`

# Test Generation Algorithms

  * Block coverage
  * Path coverage
  * Branch coverage
  * MC/DC coverage
  * Input partitioning (see example)

# Oracle Generation

Synthesize oracles from ensures-statements on contracts.

# Summary of the testing framework

| Dafny Syntax                                      | Meaning                                                                                    | Java (JUnit/Mockito)                                   | C# (XUnit/Moq)                    | Go               |
|---------------------------------------------------|--------------------------------------------------------------------------------------------|--------------------------------------------------------|-----------------------------------|------------------|
| `{:test}` attribute                               | Method can be run as a test case.  Method name must start with `Test` and be in PascalCase | `@Test`                                                | `[Fact]`                          |                  |
| `{:test M}` attribute with parameter              | Method is a parameterized test case, with `M` being the provider.                          | `@ParameterizedTest` with `@MethodSource`              | `[Theory]` with `[MemberData]`    |                  |
| `{:fresh}` attribute                              | Method returns an unconstrained fresh object (`:fresh` implies `:extern`)                  | Zero-constructor                                       | Zero-constructor                  | Zero-constructor |
| `{:mock} M() returns (o:Object) requires...`      | Creating a mock (`:mock` implies `:extern`)                                                | `Mockito.mock(Object.class)`                           | `var m = new Mock<Object>()`      |                  |
| `...o.Do() == 0`                                  | Stubbing a method                                                                          | `Mockito.doReturn(0).when(o).Do()`                     | `m.Setup(o => o.Do()).Returns(0)` |                  |
| `...forall a:int :: ((a == 0) => (o.Do(a) == 0))` | Stubbing a method for certain inputs                                                       | Custom `ArgumentMatcher` needed for multiple arguments | Similar to Java                   |                  |
| `...forall a:int :: (o.Do(a) == a)`               | Stubbing a method with a return value that depends on the arguments                        | Mockito's `thenAnswer`                                 | `.Returns<int>(x => x);`          |                  |
