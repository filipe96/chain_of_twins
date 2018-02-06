import java.util.ArrayList;

public class PrimeTwins {
    private int first;
    private int second;
    private Boolean hasANextChainLink;


    public PrimeTwins(int first, int second) {
        this.first = first;
        this.second = second;

    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getSum() {
        return first + second;
    }

    public int getMiddle() {
        return first + 1;
    }

    public boolean containsMiddle(ArrayList<PrimeTwins> list/*, ArrayList<ArrayList<Integer>> fuckingContainerList*/) {
        for (PrimeTwins pair : list) {
            //System.out.println(pair.first);
            ArrayList<Integer> chainLinkIndexList = new ArrayList<>();

            if ((pair != null) && (pair.getMiddle() == (first + second))) {
                System.out.println("Middle of Next Chain: "+ pair.getMiddle() + " = " + "\n" +  "Sum of Prime Twins: "+ getSum());
                chainLinkIndexList.add(list.indexOf(pair));
                return true;
            }
        }
        //System.out.println("::::::::::::::::::::::::::");
        return false;
    }

    public ArrayList<Integer> findChainIndexes(ArrayList<PrimeTwins> list) {
        ArrayList<Integer> chainLinkIndexList = new ArrayList<>();
        for (PrimeTwins pair : list) {
            if ((pair != null) && (pair.getMiddle() == (first + second))) {
                chainLinkIndexList.add(first);
                chainLinkIndexList.add(second);

                chainLinkIndexList.add(pair.getFirst());
                chainLinkIndexList.add(pair.getSecond());

                System.out.println(list.indexOf(pair));
            }
        }
        return  chainLinkIndexList;
    }


    public PrimeTwins getNextChainLink(ArrayList<PrimeTwins> list) {
        for (PrimeTwins pair : list) {
            if (pair != null && pair.getMiddle() == getSum()) {
                return pair;
            }
        }
        return null;
    }

    public boolean hasANextChain(ArrayList<PrimeTwins> list){ //Könte evtl die lösung sein
        //TODO Zwei FOrschleifen bilden mit der einen durch den
        boolean hasANextChain = false;
        for (PrimeTwins pair:
             list) {
            if((pair != null) && (pair.getMiddle() == (first + second))){
                return true;
            }

        }
        return hasANextChain;
    }

    public void setHasANextChainLink(Boolean value) {
        hasANextChainLink = value;
    }

    public Boolean getHasANextChainLink() {
        return hasANextChainLink;
    }

}
