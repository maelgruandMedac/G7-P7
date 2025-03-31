@echo off

echo Compilation des fichiers Java...
javac -d bin src/com/p8/*.java

if errorlevel 1 (
    echo La compilation a echoue. Veuillez verifier les erreurs.
    pause
    exit /b 1
)

echo Compilation reussie. Execution de l'application...
java -cp bin com.p8.App

pause
