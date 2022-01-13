include "BoundedResponseMonitor.dfy"
include "Utils.dfy"

module BoundedResponseMonitorTests {

  import opened BoundedResponseMonitor
  import opened Utils

  class BoundedResponseTest {

    method {:test} test_constructor_should_throwException_when_lowerBoundLessThanZero() 
    {
      BoundedResponseTestSupport.checkRequires_boundedResponse(-1, 0);
    }

    method {:test} test_constructor_should_throwException_when_upperBoundGreaterThanLowerBound() 
    {
      BoundedResponseTestSupport.checkRequires_boundedResponse(1, 0);
    }

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

    static method paramterized_expect_provider() returns (testInputs : seq<(int, int, int)>)
    {
      testInputs := paramterized_assert_provider();
    }

    method {:test "parameterized_expect_provider"} parameterized_expect(x : int, y : int, expected : int)
    {
      var sum : int := x + y;
      Assertions.expectEquals(expected, sum);
    }

    method {:test} test_expect_behavior()
    {
      var m : bool := false;

      Assertions<bool>.expectTrue(m);
      assert(true);
    }

    method {:test "JUnit5"} testBoundedResponse() {
      var m : BoundedResponseMonitor.BoundedResponse<int> := 
          new BoundedResponseMonitor.BoundedResponse<int>.boundedResponse(0, 2);

      var alert, hasOutput, output := m.step(true, true, 0);
      assert(!alert);
      assert(hasOutput);
      assert(output == 0);
      alert, hasOutput, output := m.step(false, false, 1);
      assert(!alert);
      assert(!hasOutput);

      alert, hasOutput, output := m.step(true, false, 2);
      assert(!alert);
      assert(!hasOutput);
      alert, hasOutput, output := m.step(false, true, 3);
      assert(!alert);
      assert(hasOutput);
      assert(output == 3);

      alert, hasOutput, output := m.step(true, false, 2);
      assert(!alert);
      assert(!hasOutput);
      alert, hasOutput, output := m.step(false, false, 2);
      assert(!alert);
      assert(!hasOutput);
      alert, hasOutput, output := m.step(false, true, 3);
      assert(!alert);
      assert(hasOutput);
      assert(output == 3);
      
      alert, hasOutput, output := m.step(false, true, 4);
      assert(alert);
      assert(!hasOutput);
      alert, hasOutput, output := m.step(false, true, 4);
      assert(alert);
      assert(!hasOutput);
    }
  }
}