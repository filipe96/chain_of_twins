package main;

import task.PrimeTwinChains;

import java.util.concurrent.CyclicBarrier;
import java.util.ArrayList;


public class Application {
    private CyclicBarrier cyclicBarrier;
    private ArrayList<PrimeTwinChains> threadList;

    public Application() {
        cyclicBarrier = new CyclicBarrier(Configuration.instance.maximumNumberOfThreads);
        threadList = new ArrayList<>();

    }

    private void build() {
        System.out.println("phase 01 - build");

        int minimum = 3;
        int stepSize = (Configuration.instance.maximum - minimum) / Configuration.instance.maximumNumberOfThreads;
        int maximum = minimum + stepSize;

        for (int i = 0; i < Configuration.instance.maximumNumberOfThreads; i++) {
            threadList.add(new PrimeTwinChains(cyclicBarrier, minimum, maximum));
            System.out.println("Minimum:" + minimum);
            System.out.println("Maximum:" + maximum);
            minimum = maximum + 1;
            maximum = minimum + stepSize;
        }
    }

    private void execute() {
        for (PrimeTwinChains list : threadList) {
            new Thread(list).start();
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.build();
        app.execute();
    }
}
