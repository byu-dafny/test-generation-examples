#!/bin/sh

#################################################################################################################
#                                                                                                               #
#  Copy this file into the base directory of your code. Example: cp dafny-compile-java-template.sh IntegerSet/  #
#  There are TWO things to add to this script after you copy it. They are found on lines 10 and 11.             #
#                                                                                                               #
#################################################################################################################

MODULENAME=PrivateDLL
DAFNY="/Users/cassidywaldrip/Documents/vvlab/BASE-DIRECTORY/dafny"
MODEL="./dafny/${MODULENAME}Tests.dfy"
ARGS="/compileVerbose:1 /compile:2 /spillTargetCode:3 /compileTarget:java /noVerify /out:${MODULENAME}"

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

# Add the external Assertions library to the test directory
mv ./${MODULENAME}-java/Utils_Compile src/test/java/.
cp ../Utils_Compile/Assertions.java src/test/java/Utils_Compile/

# Move left over files to the main directory
mv ./${MODULENAME}-java/* src/main/java/.

# Remove unneccessary files
rm -r src/main/java/_System
rm src/main/java/${MODULENAME}.java

# Clean the output directory
rm -rf ./${MODULENAME}-java