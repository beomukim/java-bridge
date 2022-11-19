package bridge;

public class BridgeGameManager {
    private int count;
    private int step;

    public int getStep() {
        return step;
    }

    public int getCount() {
        return count;
    }

    public BridgeGameManager() {
        count = 1;
        step = 0;
    }

    public void increaseCount() {
        count++;
    }

    public void increaseStep() {
        step++;
    }

    public void gameFail() {
        step = -1;
    }
}
