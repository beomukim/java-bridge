package bridge;

public class GameResultDto {
    private int count;
    private Result result;

    public GameResultDto(int count, Result result) {
        this.count = count;
        this.result = result;
    }

    public static GameResultDto from(GameResult gameResult) {
        return new GameResultDto(gameResult.getCount(), gameResult.getResult());
    }

    public int getCount() {
        return count;
    }

    public Result getResult() {
        return result;
    }
}
