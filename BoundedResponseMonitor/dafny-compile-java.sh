#!/bin/sh

MODULENAME=BoundedResponseMonitor
DOTNET=/usr/local/share/dotnet/dotnet
DAFNY=${HOME}/.vscode/extensions/correctnesslab.dafny-vscode-2.0.2/out/resources/dafny/Dafny.dll
MODEL=${HOME}/Documents/byu-dafny/test-generation-examples/${MODULENAME}/dafny/${MODULENAME}Tests.dfy
ARGS="/verifyAllModules /compileTarget:java /compile:1 /spillTargetCode:1 /out:${MODULENAME}"

# Create Maven directory structure
rm -rf src
mkdir src
mkdir src/main
mkdir src/main/java
mkdir src/test
mkdir src/test/java

# Generate Java from Dafny model and move srcs
${DOTNET} ${DAFNY} ${MODEL} $ARGS

# Clean build files
find ./${MODULENAME}-java -name "*.class" | xargs rm -rf

# Move generated source files into Maven structure
mv ./${MODULENAME}-java/${MODULENAME}_Compile src/main/java/.
mv ./${MODULENAME}-java/${MODULENAME}Tests_Compile src/test/java/.
mv ./${MODULENAME}-java/dafny src/main/java/.
# TODO: figure out when (if) these are needed
# mv ./${MODULENAME}-java/_System src/main/java/.

# Clean the output directory
rm -rf ./${MODULENAME}-java

# Create symbolic links to test support files
ln -s ../../../java/Utils_Compile src/test/java/

# Add the JUnit5 Import to the file with the @Test annotation
sed -i ''                                                                     \
    -E                                                                        \
    -e '/^package*/a\'$'\n''import org.junit.jupiter.api.Test;'               \
    -e '/^[[:space:]]+public[[:space:]]+void[[:space:]]+test*/i\'$'\n''@Test' \
    src/test/java/${MODULENAME}Tests_Compile/BoundedResponseTest.java

##############################################################################
# Do not move these files as they are "external"                             #
# and will clobber the test support code.                                    # 
#                                                                            #
# rm -rf src/test/java/Utils_Compile                                         #
# mv ./${MODULENAME}-java/Utils_Compile src/test/java/.                      #
##############################################################################
