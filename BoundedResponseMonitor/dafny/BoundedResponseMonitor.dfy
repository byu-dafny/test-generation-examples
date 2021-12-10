 module BoundedResponseMonitor {
  trait Monitor<T> {
    const isLatched : bool;
    var policy : bool;
    var alert : bool;
  
    method step(req : bool, rsp : bool, input : T)
      returns (alert : bool, hasOutput : bool, output : T)
      modifies `policy, `alert
      ensures this.alert == ((isLatched && old(this.alert)) || !this.policy)
      ensures alert == this.alert
      ensures hasOutput == (rsp && !this.alert)
      ensures hasOutput ==> (output == input)
  }

  class BoundedResponse<T> extends Monitor<T> {
    const INIT : int := 0;
    const ALERT : int;
    const LOWERBOUND : int;
    const UPPERBOUND : int;

    var state : int;

    constructor boundedResponse(lowerBound : int, upperBound : int)
      requires lowerBound >= 0
      requires upperBound >= 0
      requires lowerBound <= upperBound
      ensures this.ALERT == upperBound + 1
      ensures this.LOWERBOUND == lowerBound
      ensures this.UPPERBOUND == upperBound
      ensures this.state == INIT
      ensures this.isLatched == false
      ensures this.policy == false
      ensures this.alert == false
    {
      this.ALERT := upperBound + 1;
      this.LOWERBOUND := lowerBound;
      this.UPPERBOUND := upperBound;
      this.state := this.INIT;
      this.isLatched := false;
      this.policy := false;
      this.alert := false;
    }
 
    function method isINIT(curState : int) : bool
    {
      curState == this.INIT
    }

    function method isINC(curState : int) : bool
    {
      1 <= curState && curState <= this.UPPERBOUND
    }

    function method isALERT(curState : int) : bool
    {
      curState == ALERT
    }

    function method isBounded(latency : int) : bool 
    {
      this.LOWERBOUND <= latency && latency <= this.UPPERBOUND
    }

    function method isValidBounds(curState : int) : bool
    {
         this.UPPERBOUND >= 0
      && this.LOWERBOUND >= 0
      && this.LOWERBOUND <= this.UPPERBOUND
    }

    function method nextState(curState : int, req : bool, rsp : bool) : int 
    {
      if (!isValidBounds(curState)) then
        this.ALERT
      else if (isINIT(curState) && req == rsp && this.LOWERBOUND == 0) then 
        this.INIT
      else if (isINIT(curState) && req && !rsp ) then
        1
      else if (isINC(curState) && !req && !rsp) then
        curState + 1
      else if (isINC(curState) && !req && rsp && isBounded(curState)) then
        this.INIT
      else
        this.ALERT
    }

    method step(req : bool, rsp : bool, input : T)
      returns (alert : bool, hasOutput : bool, output : T)
      modifies `state, `policy, `alert
      ensures this.state == nextState(old(this.state), req, rsp)
      ensures this.policy == (this.state != ALERT)
      ensures hasOutput ==> isBounded(old(this.state))
      // ensures from the trait
      ensures this.alert == ((isLatched && old(this.alert)) || !policy)
      ensures alert == this.alert
      ensures hasOutput == (rsp && !this.alert)
      ensures hasOutput ==> (output == input)
    {
      this.state := nextState(this.state, req, rsp);
      this.policy := (this.state != this.ALERT);
      this.alert := (isLatched && this.alert) || !this.policy;
      alert := this.alert;
      hasOutput := (rsp && !this.alert);
      output := input;
    }
  }

  class OnePending<T> extends Monitor<T> {
    var pending : int;

    constructor onePending(isLatched: bool) 
      ensures this.pending == 0
      ensures this.isLatched == isLatched
      ensures this.policy == false
      ensures this.alert == false
    {
      this.isLatched := isLatched;
      this.policy :=  false;
      this.alert := false;
      this.pending := 0;
    }

    function method update(req : bool, rsp : bool) : int {
      if (req == rsp) then 0 else (if req then 1 else -1)
    }

    method step(req : bool, rsp : bool, input : T)
      returns (alert : bool, hasOutput : bool, output : T)
      modifies `pending, `policy, `alert
      ensures this.pending == (old(this.pending) + update(req, rsp))
      ensures this.policy == (0 <= pending && pending <= 1)
      // ensures from the trait
      ensures this.alert == ((isLatched && old(this.alert)) || !this.policy)
      ensures alert == this.alert
      ensures hasOutput == (rsp && !this.alert)
      ensures hasOutput ==> (output == input)
    {
      var update : int := update(req, rsp);
      this.pending := this.pending + update;
      this.policy := (0 <= pending && pending <= 1);
      this.alert := (isLatched && this.alert) || !this.policy;
      alert := this.alert;
      hasOutput := (rsp && !this.alert);
      output := input;
    }
  }

  class OnePendingAutomata<T> extends Monitor<T> {
    const NOTHING : int := 0
    const PENDING : int := 1
    const ALERT : int := 2

    var state : int;

    constructor onePendingAutomata(isLatched: bool) 
      ensures this.state == NOTHING
      ensures this.isLatched == isLatched
      ensures this.policy == false
      ensures this.alert == false
    {
      this.isLatched := isLatched;
      this.policy :=  false;
      this.alert := false;
      this.state := NOTHING;
    }

    function method nextState(curState : int, req : bool, rsp : bool) : int
    decreases curState
    {
      if (curState == NOTHING && req == rsp) then 
        NOTHING 
      else if (curState == NOTHING && req && !rsp) then
        PENDING
      else if (curState == PENDING && req && rsp) then
        PENDING
      else if (curState == PENDING && !req && rsp) then
        NOTHING
      else if (curState == ALERT && !isLatched) then
        nextState(NOTHING, req, rsp)
      else
        ALERT 
    }

    method step(req : bool, rsp : bool, input : T)
      returns (alert : bool, hasOutput : bool, output : T)
      modifies `state, `policy, `alert
      ensures this.state == nextState(old(this.state), req, rsp)
      ensures this.policy == (this.state != ALERT)
      ensures this.alert == ((isLatched && old(this.alert)) || !policy)
      ensures alert == this.alert
      ensures hasOutput == (rsp && !this.alert)
      ensures hasOutput ==> (output == input)
    {
      this.state := nextState(this.state, req, rsp);
      this.policy := (this.state != ALERT);
      this.alert := (isLatched && this.alert) || !this.policy;
      alert := this.alert;
      hasOutput := (rsp && !this.alert);
      output := input;
    }
  }

  class OnePendingNoOverlapAutomata<T> extends Monitor<T> {
    const NOTHING : int := 0
    const PENDING : int := 1
    const ALERT : int := 2

    var state : int;

    constructor onePendingNoOverlapAutomata(isLatched: bool) 
      ensures this.state == NOTHING
      ensures this.isLatched == isLatched
      ensures this.policy == false
      ensures this.alert == false
    {
      this.isLatched := isLatched;
      this.policy :=  false;
      this.alert := false;
      this.state := NOTHING;
    }

    function method nextState(curState : int, req : bool, rsp : bool) : int
    decreases curState
    {
      if (curState == NOTHING && req == rsp) then 
        NOTHING 
      else if (curState == NOTHING && req && !rsp) then
        PENDING
      else if (curState == PENDING && !req && rsp) then
        NOTHING
      else if (curState == ALERT && !isLatched) then
        nextState(NOTHING, req, rsp)
      else
        ALERT 
    }

    method step(req : bool, rsp : bool, input : T)
      returns (alert : bool, hasOutput : bool, output : T)
      modifies `state, `policy, `alert
      ensures this.state == nextState(old(this.state), req, rsp)
      ensures this.policy == (this.state != ALERT)
      ensures this.alert == ((isLatched && old(this.alert)) || !policy)
      ensures alert == this.alert
      ensures hasOutput == (rsp && !this.alert)
      ensures hasOutput ==> (output == input)
    {
      this.state := nextState(this.state, req, rsp);
      this.policy := (this.state != ALERT);
      this.alert := (isLatched && this.alert) || !this.policy;
      alert := this.alert;
      hasOutput := (rsp && !this.alert);
      output := input;
    }
  }
}


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