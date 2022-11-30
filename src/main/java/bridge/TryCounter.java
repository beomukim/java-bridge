package bridge;

public class TryCounter {
    private int count = 1;

    public void increaseCount() {
        count++;
    }

    public void reset() {
        count = 0;
    }
}
