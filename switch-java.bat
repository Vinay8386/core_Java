@echo off

echo =========================
echo Select Java Version
echo =========================
echo 1. Java 11
echo 2. Java 17
echo 3. Java 21
echo 4. Java 25
echo.

set /p choice=Enter choice:

if "%choice%"=="1" set "JAVA_HOME=C:\Program Files\Microsoft\jdk-11.0.30.7-hotspot"
if "%choice%"=="2" set "JAVA_HOME=C:\Program Files\Microsoft\jdk-17.0.18.8-hotspot"
if "%choice%"=="3" set "JAVA_HOME=C:\Program Files\Microsoft\jdk-21.0.10.7-hotspot"
if "%choice%"=="4" set "JAVA_HOME=C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot"

set "PATH=%JAVA_HOME%\bin;%SystemRoot%\System32;%SystemRoot%;%SystemRoot%\System32\Wbem"

echo.
echo JAVA_HOME=%JAVA_HOME%
echo.

java -version

cmd