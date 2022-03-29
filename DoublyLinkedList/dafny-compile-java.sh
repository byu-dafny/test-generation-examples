#!/bin/sh

MODULENAME=PrivateDLL
DAFNY="/Users/cassidywaldrip/Documents/vvlab/BASE-DIRECTORY/dafny/Scripts/dafny"
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
${DAFNY} ${MODEL} ${ARGS}

# Clean build files
find ./${MODULENAME}-java -name "*.class" | xargs rm -rf

# Move generated source files into Maven structure
mv /${MODULENAME}-java/${MODULENAME}_Compile src/main/java/
mv /${MODULENAME}-java/${MODULENAME}Tests_Compile src/test/java/
mv /${MODULENAME}-java/dafny src/main/java/

##############################################################################
# Do not move these files as they are "external"                             #
# and will clobber the test support code.                                    # 
#                                                                            #
mv ./${MODULENAME}-java/Utils_Compile src/test/java/.
cp -r ../Utils_Compile src/test/java/
rm src/test/java/Utils_Compile/Assertions.cs
##############################################################################


# TODO: figure out when (if) these are needed
# mv ./${MODULENAME}-java/_System src/main/java/.

# Clean the output directory
rm -rf ./${MODULENAME}-java

# Create symbolic links to test support files
#ln -s ../../../java/Utils_Compile src/test/java/