@echo off
if "%OS%" == "Windows_NT" setlocal

set JAVA_OPTS=-server -Xms128m -Xmx256m -XX:PermSize=64M -XX:MaxPermSize=128m 
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

set BASEDIR=%FELIX_HOME%
call "%FELIX_HOME%\bin\setclasspath.bat" %1
if errorlevel 1 goto end
rem Add on extra jar files to CLASSPATH
if "%JSSE_HOME%" == "" goto noJsse
set CLASSPATH=%CLASSPATH%;%JSSE_HOME%\lib\jcert.jar;%JSSE_HOME%\lib\jnet.jar;%JSSE_HOME%\lib\jsse.jar
:noJsse
::set CLASSPATH=%CLASSPATH%;%FELIX_HOME%\bin\felix.jar
rem ----- Execute The Requested Command ---------------------------------------
echo Using FELIX_HOME:      %FELIX_HOME%

if ""%1"" == ""debug"" goto use_jdk
echo Using JRE_HOME:        %JRE_HOME%
goto java_dir_displayed
:use_jdk
echo Using JAVA_HOME:       %JAVA_HOME%
:java_dir_displayed

set _EXECJAVA=%_RUNJAVA%
set MAINCLASS=bin\felix.jar
set ACTION=start
set SECURITY_POLICY_FILE=
set DEBUG_OPTS=
set JPDA=

if ""%1"" == ""debug"" goto doDebug
if ""%1"" == ""start"" goto doStart
goto end

:doDebug
shift
set _EXECJAVA=%_RUNJDB%
set DEBUG_OPTS=-sourcepath "%FELIX_HOME%\..\..\java"
if not ""%1"" == ""-security"" goto execCmd
shift
echo Using Security Manager
set SECURITY_POLICY_FILE=%FELIX_HOME%\conf\catalina.policy
goto execCmd

:doStart
shift
if not "%OS%" == "Windows_NT" goto noTitle
set _EXECJAVA=start "Felix" %_RUNJAVA%
goto gotTitle
:noTitle
set _EXECJAVA=start %_RUNJAVA%
:gotTitle
if not ""%1"" == ""-security"" goto execCmd
shift
echo Using Security Manager
set SECURITY_POLICY_FILE=%FELIX_HOME%\conf\catalina.policy
goto execCmd

:execCmd
rem Get remaining unshifted command line arguments and save them in the
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:doneSetArgs

rem Execute Java with the applicable properties
echo %_EXECJAVA% -jar %JAVA_OPTS% %DEBUG_OPTS% -Djava.endorsed.dirs="%JAVA_ENDORSED_DIRS%" -classpath "%CLASSPATH%" -Dfelix.home="%FELIX_HOME%" bin\felix.jar %CMD_LINE_ARGS%
cd %FELIX_HOME%
%_EXECJAVA% -jar %JAVA_OPTS% %DEBUG_OPTS% -Djava.endorsed.dirs="%JAVA_ENDORSED_DIRS%" -classpath "%CLASSPATH%" -Dfelix.home="%FELIX_HOME%" bin\felix.jar %CMD_LINE_ARGS%
:end