package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.CrossChecker;
import bridge.Direction;
import bridge.InputView;
import bridge.OutputView;
import bridge.Result;
import bridge.User;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();

        BridgeGame bridgeGame = startGame(bridgeSize);
        User user = bridgeGame.getUser();

        move(bridgeGame, user);
        gameResult(bridgeGame, user);
    }

    private static BridgeGame startGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        return bridgeGame;
    }


    private void move(BridgeGame bridgeGame, User user) {
        while (bridgeGame.playing()) {
            CrossChecker checker = getCrossChecker(bridgeGame, user);
            if (quit(bridgeGame, checker)) {
                bridgeGame.gameResult(Result.FAIL);
                break;
            }
        }
    }

    private void gameResult(BridgeGame bridgeGame, User user) {
        if (!user.isFail()) {
            bridgeGame.gameResult(Result.SUCCESS);
        }
        outputView.printResult(bridgeGame);
    }

    private CrossChecker getCrossChecker(BridgeGame bridgeGame, User user) {
        outputView.printMovingMessage();
        Direction moving = Direction.valueOf(inputView.readMoving());
        CrossChecker checker = bridgeGame.move(moving);
        outputView.printMap(user);
        return checker;
    }

    private boolean quit(BridgeGame bridgeGame, CrossChecker checker) {
        if (CrossChecker.isFail(checker)) {
            if (retry(bridgeGame)) {
                return true;
            }
        }
        return false;
    }

    private boolean retry(BridgeGame bridgeGame) {
        outputView.printRestartMessage();
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.retryOrNot(gameCommand)) {
            return true;
        }
        return false;
    }
}
