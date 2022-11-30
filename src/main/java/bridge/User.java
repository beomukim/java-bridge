package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    private GameResult gameResult;

    public User(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void crossBridge(Direction moving, CrossChecker crossOrNot) {
        if (moving == Direction.U) {
            upBridge.add(crossOrNot.getResult());
        }
        if (moving == Direction.D) {
            downBridge.add(crossOrNot.getResult());
        }
    }

    public void reset() {
        upBridge.clear();
        downBridge.clear();
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
