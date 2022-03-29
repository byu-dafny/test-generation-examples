#!/bin/sh

MODULENAME=PrivateDLL
# DOTNET="/usr/local/share/dotnet"
DAFNY="/Users/cassidywaldrip/Documents/vvlab/BASE-DIRECTORY/dafny/Scripts/dafny"
MODEL="./dafny/${MODULENAME}Tests.dfy"
ARGS="/compileVerbose:1 /compile:2 /spillTargetCode:3 /compileTarget:java /noVerify /out:${MODULENAME}"

# Generate Java from Dafny model and move srcs
${DAFNY} ${MODEL} ${ARGS}