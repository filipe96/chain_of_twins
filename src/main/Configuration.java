package main;

public enum Configuration {
    instance;
    int maximumNumberOfThreads = Runtime.getRuntime().availableProcessors();
    int maximum =   250000000;  //run for 15 minutes (tested with a four core processor)
                  //500000000;  //run for full processor capacity
}
