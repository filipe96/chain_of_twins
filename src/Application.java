
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.execute();
    }

    public void execute() {
        ArrayList<PrimeTwins> listOfTwins = new ArrayList<>();
        listOfTwins = findPrimeTwins(getListOfPrimes());

        //aNewHope(listOfTwins);
        findChain(listOfTwins, 0);

        //Ausgabe nur wenn sizeOf größer 2


    }


    public ArrayList<Integer> getListOfPrimes() {
        ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
        for (int number = 2; number <= 3000; number++) {
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
        ArrayList<ArrayList<PrimeTwins>> fuckingContainerList = new ArrayList<>();
        for (int x = 0; x <= list.size() - 2; x++) {
            findChain(list, x);
        }
    }

    public void  findChain (ArrayList<PrimeTwins> list, int index) {
        ArrayList <Integer> chainList = new ArrayList<>();
        chainList.add(list.get(index).getFirst());
        chainList.add(list.get(index).getSecond());
        int x;// = index;
        for ( x = 0; x < list.size() ; x++) {
            if(list.get(index).getSum() == list.get(x).getMiddle()){
                System.out.println("Sum"+ list.get(index).getSum()  + "Middle:" + list.get(x).getMiddle());
                System.out.println("index" + index);
                System.out.println("x" + x);
                index = x;
                chainList.add(list.get(x).getFirst());
                chainList.add(list.get(x).getSecond());

            }
        }
        System.out.println(chainList);
    }


    public ArrayList<Integer> hasAChainLink(ArrayList<PrimeTwins> list, int index) {
        return list.get(index).findChainIndexes(list);
    }



}
