package task;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class PrimeTwinChains implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int min;
    private int max;

    public PrimeTwinChains(CyclicBarrier cyclicBarrier, int min, int max) {
        this.cyclicBarrier = cyclicBarrier;
        this.min = min;
        this.max = max;
    }

    //Aus Gründen der Testbarkeit wurde darauf verzichtet die Methoden anstandsmäßig privat zu lassen
    @Override
    public void run() {
        System.out.println("task.PrimeTwinChains started");

        ArrayList<Integer> primeList = getListOfPrimes();
        ArrayList<PrimeTwins> primeTwinList = findPrimeTwins(primeList);
        primeList.clear();
        getFinalList(iteratePrimeTwins(primeTwinList));
        primeTwinList.clear();
    }


    public ArrayList<Integer> getListOfPrimes() {
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for (int number = min; number <= max; number++) {
            if (isPrime(number)) {
                listOfPrimes.add(number);
            }
        }
        return listOfPrimes;
    }

    public boolean isPrime(int number) {
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public ArrayList<PrimeTwins> findPrimeTwins(ArrayList<Integer> list) {  //Works!
        System.out.println("Search for Prime Twins started");
        ArrayList<PrimeTwins> primeTwinsArrayList = new ArrayList<>();
        for (int index = 0; index <= list.size() - 2; index++) {
            if (list.get(index) == list.get(index + 1) - 2) {
                PrimeTwins pair = new PrimeTwins(list.get(index), list.get(index + 1));
                primeTwinsArrayList.add(pair);
            }
        }
        return primeTwinsArrayList;
    }


    public ArrayList<ArrayList<Integer>> iteratePrimeTwins(ArrayList<PrimeTwins> list) {
        System.out.println("Search for Chains started");
        ArrayList<ArrayList<Integer>> containerList = new ArrayList<>();
        for (int x = 0; x <= list.size() - 2; x++) {
            containerList.add(findChain(list, x));
        }
        return containerList;
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

                System.out.println(chainList);
            }
        }
        return chainList;
    }

    public   ArrayList<ArrayList<Integer>> getFinalList(ArrayList<ArrayList<Integer>> list) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        for (ArrayList chain :
                list) {
            if (chain.size() > 2) {
                finalList.add(chain);
            }
        }
        return finalList;
    }
}
