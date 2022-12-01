package bridge;

public class GameResult {
    private int count;
    private Result result;

    public GameResult(int count, Result result) {
        this.count = count;
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public String getResult() {
        return result.getResult();
    }
}
