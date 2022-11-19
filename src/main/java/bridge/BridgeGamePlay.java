package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.BridgeMakerController;

public class BridgeGamePlay {
    public void gamePlay() {
        AppConfig appConfig = new AppConfig();
        BridgeMakerController bridgeMakerController = appConfig.bridgeMakerController();
        BridgeGameController bridgeGameController = appConfig.bridgeGameController();

        bridgeMakerController.makeBridge();
        bridgeGameController.playGame();
    }
}
