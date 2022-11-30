package bridge;

public enum GameCommand {
    R, Q;

    public static boolean continueGame(String gameCommand) {
        return GameCommand.valueOf(gameCommand) == GameCommand.R;
    }

}
