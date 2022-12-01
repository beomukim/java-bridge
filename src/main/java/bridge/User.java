package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();
    private Result result;


    public void crossBridge(Direction moving, CrossChecker crossOrNot) {
        if (moving == Direction.U) {
            upBridge.add(crossOrNot.getResult());
            downBridge.add(CrossChecker.BLANK.getResult());
        }
        if (moving == Direction.D) {
            upBridge.add(CrossChecker.BLANK.getResult());
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

    public void gameFail() {
        result = Result.FAIL;
    }

    public void gameSuccess() {
        result = Result.SUCCESS;
    }

    public boolean isFail() {
        return result == Result.FAIL;
    }

    public Result getResult() {
        return result;
    }
}
