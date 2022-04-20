#!/bin/sh

#################################################################################################################
#                                                                                                               #
#  Copy this file into the base directory of your code. Example: cp dafny-compile-java-template.sh IntegerSet/  #
#  There are TWO things to add to this script after you copy it. They are found on lines 10 and 11.             #
#                                                                                                               #
#################################################################################################################

MODULENAME=IdStationImplementation
DAFNY="/workspaces/dafny"
MODEL="./dafny/${MODULENAME}Tests.dfy"
ARGS="/compileVerbose:1 /compile:2 /spillTargetCode:3 /compileTarget:java /noVerify /out:${MODULENAME}"

# Clear out the old mvn build
rm -rf target

# Create the library for the project
rm -rf lib
mkdir lib
ln -s ../../test-library-common/DafnyRuntime.jar ./lib/

# Create Maven directory structure
rm -rf src
mkdir src
mkdir src/main
mkdir src/main/java
mkdir src/test
mkdir src/test/java

# Generate Java from Dafny model and move srcs
${DAFNY}/Scripts/dafny ${MODEL} $ARGS

# Clean build files
find ./${MODULENAME}-java -name "*.class" | xargs rm -rf

# Move generated source files into Maven structure
mv ./${MODULENAME}-java/${MODULENAME}_Compile src/main/java/.
mv ./${MODULENAME}-java/${MODULENAME}Tests_Compile src/test/java/.
mv ./${MODULENAME}-java/dafny src/main/java/.

mkdir src/main/java/ExternFingerprint_Compile
ln -s ../../../../java/Fingerprint.java src/main/java/ExternFingerprint_Compile/
mkdir src/main/java/ExternSecurityClearance_Compile
ln -s ../../../../java/SecurityClearance.java src/main/java/ExternSecurityClearance_Compile/
mkdir src/main/java/ExternToken_Compile
ln -s ../../../../java/Token.java src/main/java/ExternToken_Compile/

# Add the external Assertions library to the test directory
mkdir src/test/java/Utils_Compile
ln -s ../../../../../test-library-common/Assertions.java src/test/java/Utils_Compile/

# Move left over files to the main directory
mv ./${MODULENAME}-java/* src/main/java/.

# Remove unneccessary files
rm -r src/main/java/_System
rm src/main/java/${MODULENAME}.java

# Clean the output directory
rm -rf ./${MODULENAME}-java