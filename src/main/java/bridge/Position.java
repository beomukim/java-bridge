package bridge;

public class Position {
    private int step = 0;

    public int getStep() {
        return step;
    }

    public void increaseStep() {
        this.step++;
    }

    public void reset() {
        step = 0;
    }
}
