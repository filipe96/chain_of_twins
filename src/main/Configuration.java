package main;

public enum Configuration {
    instance;
    int maximumNumberOfThreads = Runtime.getRuntime().availableProcessors();
    int maximum = 5000000;//00;
}
