#!/bin/bash
JAVA="/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home";
exec "$JAVA/bin/java" -server -Xms4G -Xmx4G -XX:MaxDirectMemorySize=1024M -XX:NewSize=1G -XX:MaxNewSize=1G -XX:+UseParNewGC -XX:MaxTenuringThreshold=2 -XX:SurvivorRatio=8 -XX:+UnlockDiagnosticVMOptions -XX:ParGCCardsPerStrideChunk=32768 -cp "out/production/Chain of Twins P" main.Application;
