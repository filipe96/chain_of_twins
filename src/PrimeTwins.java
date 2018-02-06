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

    public boolean containsMiddle(ArrayList<PrimeTwins> list) {
        for (PrimeTwins pair : list) {// TODO Hier liegt der Fehler
            //System.out.println(pair.first);
            if ((pair != null) && (pair.getMiddle() == (first + second))) {
                System.out.println(pair.getMiddle() + "=" + getSum());
                return true;
            }
        }
        return false;
    }

    public PrimeTwins getNextChainLink(ArrayList<PrimeTwins> list) {
        for (PrimeTwins pair : list) {
            if (pair != null && pair.getMiddle() == getSum()) {
                return pair;
            }
        }
        return null;
    }

    public void setHasANextChainLink(Boolean value) {
        hasANextChainLink = value;
    }

    public Boolean getHasANextChainLink() {
        return hasANextChainLink;
    }

}
