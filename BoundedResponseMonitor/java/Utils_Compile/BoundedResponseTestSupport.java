package Utils_Compile;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;

import dafny.DafnyHaltException;

public class BoundedResponseTestSupport {
  static public void checkRequires__boundedResponse(BigInteger lowerBound, BigInteger upperBound) {
    BoundedResponseMonitor_Compile.BoundedResponse<java.math.BigInteger> testSubject = 
      new BoundedResponseMonitor_Compile.BoundedResponse<java.math.BigInteger>(dafny.TypeDescriptor.BIG_INTEGER);
    Assertions.assertThrows(DafnyHaltException.class, 
      () -> testSubject.boundedResponse(lowerBound, upperBound));
  }
}
