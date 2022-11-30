package bridge;

import bridge.controller.BridgeController;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static InputView inputView = new InputView();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView());
        bridgeController.play();
    }

}
