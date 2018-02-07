import java.util.concurrent.CyclicBarrier;
import java.util.ArrayList;

public class Application {
    private CyclicBarrier cyclicBarrier;
    private ArrayList<PrimeTwinChains> listOfChains;

    public Application() {
        cyclicBarrier = new CyclicBarrier(Configuration.instance.maximumNumberOfThreads);
        listOfChains = new ArrayList<>();

    }

    public void build(){
        System.out.println("phase 01 - build");

        int minimum = 3;
        int stepSize = (Configuration.instance.maximum - minimum) / Configuration.instance.maximumNumberOfThreads;
        int maximum = minimum + stepSize;

        for (int i = 0;i < Configuration.instance.maximumNumberOfThreads;i++){
            listOfChains.add(new PrimeTwinChains(cyclicBarrier, minimum, maximum));
            minimum = maximum + 1;
            maximum = minimum + stepSize;
        }
    }

    public void execute() {
        for (PrimeTwinChains list: listOfChains) {
            new Thread(list).start();
        }
    }

/*
    public ArrayList<Integer> getListOfPrimes(int min, int max ) {
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for (int number = min; number <= max; number++) {
            if (isPrime(number)) {
                System.out.println(number);
                listOfPrimes.add(number);
            }
        }
        return listOfPrimes;
    }

    private boolean isPrime(int number) {
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private ArrayList<PrimeTwins> findPrimeTwins(ArrayList<Integer> list) {  //Works!
        ArrayList<PrimeTwins> primeTwinsArrayList = new ArrayList<>();
        for (int index = 0; index <= list.size() - 2; index++) {
            if (list.get(index) == list.get(index + 1) - 2) {
                PrimeTwins pair = new PrimeTwins(list.get(index),
                        list.get(index + 1));
                primeTwinsArrayList.add(pair);
            }
        }
        return primeTwinsArrayList;
    }


    private ArrayList<ArrayList<Integer>> aNewHope(ArrayList<PrimeTwins> list) {
        ArrayList<ArrayList<Integer>> fuckingContainerList = new ArrayList<>();
        for (int x = 0; x <= list.size() - 2; x++) {
            fuckingContainerList.add(findChain(list, x));
        }
        return fuckingContainerList;
    }

    private ArrayList<Integer> findChain(ArrayList<PrimeTwins> list, int index) {
        ArrayList<Integer> chainList = new ArrayList<>();
        chainList.add(list.get(index).getFirst());
        chainList.add(list.get(index).getSecond());
        for (int x = 0; x < list.size(); x++) {
            if (list.get(index).getSum() == list.get(x).getMiddle()) {
                index = x;
                chainList.add(list.get(x).getFirst());
                chainList.add(list.get(x).getSecond());

            }
        }
        return chainList;
    }
*/
    public static void main(String[] args) {
        Application app = new Application();
        app.build();
        app.execute();
    }




}
