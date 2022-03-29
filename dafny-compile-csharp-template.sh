#!/bin/sh

###################################################################################################################
#                                                                                                                 #
#  Copy this file into the base directory of your code. Example: cp dafny-compile-csharp-template.sh IntegerSet/  #
#  There are TWO things to add to this script after you copy it. They are found on lines 10 and 11.               #
#                                                                                                                 #
###################################################################################################################

MODULENAME= # TODO: Set the module name. Example: MODULENAME=RussianMultiplication
DAFNY= # TODO: Add the path to your clone of BYU Dafny. Example: DAFNY="/Users/cassidywaldrip/BYU-DAFNY-BASE-DIRECTORY/dafny"
MODEL="./dafny/${MODULENAME}Tests.dfy"
ARGS="/compileVerbose:1 /compile:2 /spillTargetCode:3 /noVerify /out:${MODULENAME}.cs"

${DAFNY}/Scripts/dafny ${MODEL} $ARGS