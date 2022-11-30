package bridge;

public class GameResult {
    private TryCounter tryCounter;
    private Result result = Result.SUCCESS;

    public GameResult(TryCounter tryCounter) {
        this.tryCounter = tryCounter;
    }

    public void gameFail() {
        result = Result.FAIL;
    }

    public Result getResult() {
        return result;
    }

    public int getCount() {
        return tryCounter.getCount();
    }
}
