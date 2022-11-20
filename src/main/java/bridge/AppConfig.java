package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.BridgeMakerController;
import bridge.service.BridgeGameService;
import bridge.service.BridgeMakerService;

public class AppConfig {
    private BridgeGameService bridgeGameService;

    public BridgeMakerController bridgeMakerController() {
        BridgeMakerService bridgeMakerService = bridgeMakerService();
        setBidgeMakerService(bridgeMakerService);
        return new BridgeMakerController(bridgeMakerService, inputView(), outputView());
    }


    public BridgeGameController bridgeGameController() {
        return new BridgeGameController(bridgeGameService, inputView(), outputView());
    }

    private BridgeMakerService bridgeMakerService() {
        return new BridgeMakerService();
    }

    private void setBidgeMakerService(BridgeMakerService bridgeMakerService) {
        bridgeGameService = new BridgeGameService(bridgeMakerService, bridgeGameManager(), bridgeGame(), userBridge());
    }

    private BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager();
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    private UserBridge userBridge() {
        return new UserBridge();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
