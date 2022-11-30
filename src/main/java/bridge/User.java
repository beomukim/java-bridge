package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public void crossBridge(Direction moving, CrossChecker crossOrNot) {
        if (moving == Direction.U) {
            upBridge.add(crossOrNot.getResult());
        }
        if (moving == Direction.D) {
            downBridge.add(crossOrNot.getResult());
        }
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    public void reset() {
        upBridge.clear();
        downBridge.clear();
    }
}
