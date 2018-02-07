public enum Configuration {
    instance;
    int maximumNumberOfThreads = Runtime.getRuntime().availableProcessors();
    int maximum = 100000;
}
