@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del ACTUAL.TXT

REM compile the code into the bin folder
cd ..\src\main\java
javac *.java

REM delete all the class files in the bin folder
del ../../../bin/*.class

REM move all class files to bin now
move *.class ../../../bin

REM move the data file to the bin folder
REM move dukeDATA.txt ../../../bin

REM navigate to the bin folder now
cd ../../../bin

java Duke < ../text-ui-test/input.txt > ../text-ui-test/ACTUAL.txt
FC ../text-ui-test/ACTUAL.txt ../text-ui-test/EXPECTED.txt

REM move the data file back

REM return to the working directory
cd ../text-ui-test