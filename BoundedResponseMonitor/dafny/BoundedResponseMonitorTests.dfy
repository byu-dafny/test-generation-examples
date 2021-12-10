include "BoundedResponseMonitor.dfy"
include "Utils.dfy"

module BoundedResponseMonitorTests {

  import opened BoundedResponseMonitor
  import opened Utils

  class BoundedResponseTest {
    method testBoundedResponse() {
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