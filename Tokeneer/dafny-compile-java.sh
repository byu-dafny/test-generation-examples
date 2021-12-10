#!/bin/sh

DOTNET=/usr/local/share/dotnet/dotnet
DAFNY=${HOME}/.vscode/extensions/correctnesslab.dafny-vscode-2.0.2/out/resources/dafny/Dafny.dll
MODEL=${HOME}/Documents/byu-dafny/test-generation-examples/Tokeneer/dafny/TokeneerTests.dfy
ARGS="/verifyAllModules /compileTarget:java /compile:1 /spillTargetCode:1 /out:Tokeneer"

${DOTNET} ${DAFNY} ${MODEL} $ARGS

rm -rf src/main/java/Tokeneer_Compile
mv ./Tokeneer-java/Tokeneer_Compile src/main/java/.

rm -rf src/test/java/TokeneerTests_Compile
mv ./Tokeneer-java/TokeneerTests_Compile src/test/java/.

##############################################################################
# Do not move these files as they are "external"                             #
# and will clobber the test support code.                                    # 
#                                                                            #
# rm -rf src/test/java/Utils_Compile                                         #
# mv ./Tokeneer-java/Utils_Compile src/test/java/.                           #
##############################################################################

# TODO: figure out when (if) these are needed
# rm -rf src/main/java/_System
# mv ./Tokeneer-java/_System src/main/java/.
#
# rm -rf src/main/java/dafny
# mv ./Tokeneer-java/dafny src/main/java/.

find src/ -name "*.class" | xargs rm -rf
rm -rf ./Tokeneer-java
