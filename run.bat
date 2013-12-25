call mvn assembly:assembly
call java -jar target\MockTaodianApi-0.0.1.jar -short_data short_url.txt

:: mvn compile exec:java -Dexec.classpathScope=compile -Dexec.mainClass=com.taodian.mockapi.AppMain
