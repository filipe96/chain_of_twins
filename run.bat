"%JAVA%\bin\java" -server -Xms4G -Xmx4G -XX:MaxDirectMemorySize=1024M -XX:NewSize=1G -XX:MaxNewSize=1G -XX:+UseParNewGC -XX:MaxTenuringThreshold=2 -XX:SurvivorRatio=8 -XX:+UnlockDiagnosticVMOptions -XX:ParGCCardsPerStrideChunk=32768 -classpath build main.Application
pause
