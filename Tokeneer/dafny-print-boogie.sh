#!/bin/sh

DOTNET="/usr/local/share/dotnet/dotnet"
DAFNY="/Users/egm/.vscode/extensions/correctnesslab.dafny-vscode-1.8.0/out/resources/dafny/Dafny.dll"
MODEL="/Users/egm/Documents/byu-dafny/test-generation-examples/Tokeneer/dafny/TokeneerTests.dfy"
ARGS="/verifyAllModules /print:./dafny/Tokeener.bpl"

${DOTNET} ${DAFNY} ${MODEL} $ARGS
