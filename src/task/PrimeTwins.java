package task;
public class PrimeTwins {
    private Integer first;
    private Integer second;


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
}
