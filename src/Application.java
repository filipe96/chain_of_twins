
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.execute();
    }

    public void execute() {
        ArrayList<PrimeTwins> listOfTwins = new ArrayList<>();
        listOfTwins = findPrimeTwins(getListOfPrimes());

        findChains(listOfTwins);
    }


    public ArrayList<Integer> getListOfPrimes() {
        ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
        for (int number = 2; number <= 14; number++) {
            if (isPrime(number)) {
                listOfPrimes.add(number);
                System.out.println(number);
            }
        }
        System.out.println("ende");
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

    public ArrayList<PrimeTwins> findPrimeTwins(ArrayList<Integer> list) {
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

    public void findChains(ArrayList<PrimeTwins> list) {
        for (int index = 0; index <= list.size() - 2; index++) {
          //  for (int i = index; index <= list.size() -2 ; i++){
                //list.get(index).containsMiddle(list);
                if (list.get(index).containsMiddle(list)){
                    System.out.println("Fist  :" + list.get(index).getFirst());
                    System.out.println("Second:" + list.get(index).getSecond());
                    System.out.println("++++++++++++++++++++");
                    System.out.println("FirstN: " + list.get(index).getFirst());
                    System.out.println("Middle: " + list.get(index).getMiddle());
                    System.out.println("SecondN:" + list.get(index).getSecond());
                    System.out.println("=============");
                }

            //}
        }

    }


    public boolean hasAChainLink(ArrayList<PrimeTwins> list, int index) {
        return list.get(index).containsMiddle(list);
    }
   // public PrimeTwins findNextChainLink(ArrayList <PrimeTwins> list, int index){
   //     return list.get(index).getNextChainLink(list);
    //}

   // public void  printOut(ArrayList<ArrayList<PrimeTwins>> list){
   //     for (PrimeTwins pair:
   //          list) {
   //         if(pair.getHasANextChainLink()  ) {
   //             System.out.println(pair.getFirst() + pair.getSecond());
   //         }
        // }
   // }


}
