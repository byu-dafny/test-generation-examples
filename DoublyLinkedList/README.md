# Tests for Dafny libraries

The following directory contains tests written manually for the implementation of Doubly Linked Lists found in the [QUIC library]((https://github.com/secure-foundations/everquic-dafny)).

With the exception of the implementation for the three methods prefixed with `GetFresh`, the code in `PrivateDLLTests.cs` is generated automatically by Dafny compiler. 

To run the tests using XUnit, execute `dotnet test DafnyTests.csproj`
