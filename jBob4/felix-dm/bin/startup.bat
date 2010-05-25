@ECHO OFF
if "%OS%" == "Windows_NT" setlocal
SET JAR_HOME=D:\jre6
SET JAVA_HOME=D:\jdk6
set CURRENT_DIR=%cd%

if not "%FELIX_HOME%" == "" goto gotHome
set FELIX_HOME=%CURRENT_DIR%
if exist "%FELIX_HOME%\bin\felix.bat" goto okHome
cd ..
set FELIX_HOME=%cd%

cd %CURRENT_DIR%

:gotHome

if exist "%FELIX_HOME%\bin\felix.bat" goto okHome
echo The FELIX_HOME environment variable is not defined correctly
echo This environment variable is needed to run this program
goto end
:okHome

set EXECUTABLE=%FELIX_HOME%\bin\felix.bat

rem Check that target executable exists
if exist "%EXECUTABLE%" goto okExec
echo Cannot find %EXECUTABLE%
echo This file is needed to run this program
goto end
:okExec
rem Get remaining unshifted command line arguments and save them in the
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:doneSetArgs

call "%EXECUTABLE%" start %CMD_LINE_ARGS%
:end