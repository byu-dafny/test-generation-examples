#!/bin/sh

MODULENAME=SatelliteUplink
DOTNET="/usr/local/homebrew/bin/dotnet"
DAFNY="${HOME}/Documents/School/Winter-2022/Research/byu-dafny-git/Scripts/dafny"
MODEL="./dafny/${MODULENAME}Tests.dfy"
ARGS="/verifyAllModules /compileTarget:java /compile:1 /spillTargetCode:1 /out:${MODULENAME}"

# Generate Java from Dafny model and move srcs
${DAFNY} ${MODEL} $ARGS

# Clean build files
find ./${MODULENAME}-java -name "*.class" | xargs rm -rf

# Move Satellite Uplink to appropriate location in system
mv ./${MODULENAME}-java/${MODULENAME}_Compile/SatelliteUplink.java ./src/main/java/instruments/satellite/

# Move Satellite Uplink tests to appropriate location in system
mv ./${MODULENAME}-java/${MODULENAME}Tests_Compile/ ./src/test/java/

##############################################################################
# Do not move these files as they are "external"                             #
# and will clobber the test support code.                                    # 
#                                                                            #
mv ./${MODULENAME}-java/Utils_Compile src/test/java/.
mv ./${MODULENAME}-java/Extern_Compile src/test/java/.
##############################################################################


# TODO: figure out when (if) these are needed
# mv ./${MODULENAME}-java/_System src/main/java/.

# Remove SatConn and SatelliteDataCache from Extern_Compile
rm src/test/java/Extern_Compile/SatConn.java
rm src/test/java/Extern_Compile/SatelliteDataCache.java

# Clean the output directory
rm -rf ./${MODULENAME}-java

# Create symbolic links to test support files
#ln -s ../../../java/Utils_Compile src/test/java/

#Add the JUnit5 Import to the file with the @Test annotation
sed -i                                                                      \
    -E                                                                        \
    -e '/^package*/a\'$'\n''import org.junit.jupiter.api.Test;'               \
    -e '/^[[:space:]]+public[[:space:]]+void[[:space:]]+test*/i\'$'\n''@Test' \
    src/test/java/${MODULENAME}Tests_Compile/${MODULENAME}Tests.java