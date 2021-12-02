#!/bin/sh

DOTNET="/usr/bin/dotnet"
DAFNY="/home/deant4/.vscode-server/extensions/correctnesslab.dafny-vscode-2.0.2/out/resources/dafny/Dafny.dll"
MODEL="./dafny/DynamicArrayTests.dfy"
ARGS="/verifyAllModules /compileTarget:java /compile:1 /spillTargetCode:1 /out:DynamicArray"

${DOTNET} ${DAFNY} ${MODEL} $ARGS

rm -rf src/main/java/DynamicArray_Compile
mv ./DynamicArray-java/DynamicArray_Compile src/main/java/.

rm -rf src/test/java/DynamicArrayTests_Compile
mv ./DynamicArray-java/DynamicArrayTests_Compile src/test/java/.

##############################################################################
# Do not move these files as they are "external"                             #
# and will clobber the test support code.                                    # 
#                                                                            #
rm -rf src/test/java/Utils_Compile                                         #
mv ./DynamicArray-java/Utils_Compile src/test/java/.                           #
rm -rf src/main/java/NativeTypes_Compile                                         #
mv ./DynamicArray-java/NativeTypes_Compile src/main/java/.   
##############################################################################

# TODO: figure out when (if) these are needed
# rm -rf src/main/java/_System
# mv ./DynamicArray-java/_System src/main/java/.
#
# rm -rf src/main/java/dafny
# mv ./DynamicArray-java/dafny src/main/java/.

find src/ -name "*.class" | xargs rm -rf
rm -rf ./DynamicArray-java
