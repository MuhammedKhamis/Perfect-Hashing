package perfectHashing.util;

public class Pair {

    private int value;

    private boolean occupied;

    public Pair() {
        // TODO Auto-generated constructor stub
        occupied = false;
        value = 0;
    }

    public Pair(int value) {
        occupied = true;
        this.value = value;
    }

    public void setValue(int value) {
        occupied = true;
        this.value = value;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getValue() {
        return value;
    }

}
