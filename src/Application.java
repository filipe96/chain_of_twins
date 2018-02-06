
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.execute();
    }

    public void execute() {
        ArrayList<PrimeTwins> listOfTwins = new ArrayList<>();
        listOfTwins = findPrimeTwins(getListOfPrimes());

        aNewHope(listOfTwins);
    }


    public ArrayList<Integer> getListOfPrimes() {
        ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
        for (int number = 2; number <= 3000; number++) {
            if (isPrime(number)) {
                listOfPrimes.add(number);
        //        System.out.println(number);
            }
        }
       // System.out.println("ende");
        return listOfPrimes;
    }

    public boolean isPrime(int number) {
        //check if n is a multiple of 2
        if (number % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public ArrayList<PrimeTwins> findPrimeTwins(ArrayList<Integer> list) {  //Works!
        //prime-2 = prime
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

    public ArrayList<ArrayList<Integer>> findChains(ArrayList<PrimeTwins> list) {  //Problem: Only finds neighbor
        ArrayList<ArrayList<Integer>> fuckingContainerList = new ArrayList<>();
        for (int index = 0; index <= list.size() - 2; index++) {


                 ArrayList<Integer> s =   hasAChainLink(list, index);
                 fuckingContainerList.add(s);

        }
        return fuckingContainerList;
    }

    private void aNewHope(ArrayList<PrimeTwins> list){
        ArrayList<ArrayList<Integer>> fuckingContainerList = new ArrayList<>();
        for (int x = 0; x <= list.size() - 2; x++) {
            for (int y = x; y < list.size(); y++){ //code can be better
                boolean a = list.get(x).getSum() == list.get(y).getMiddle();
                if(a) {
                    System.out.println("First : " + list.get(x).getFirst());
                    System.out.println("Second: " + list.get(x).getSecond());
                    System.out.println("First : " + list.get(y).getFirst());
                    System.out.println("Second: " + list.get(y).getSecond());
                }
            }

        }
    }


    public ArrayList<Integer> hasAChainLink(ArrayList<PrimeTwins> list, int index) {
        return list.get(index).findChainIndexes(list);
    }



}
