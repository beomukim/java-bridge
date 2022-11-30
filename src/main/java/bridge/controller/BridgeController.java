package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.CrossChecker;
import bridge.Direction;
import bridge.GameCommand;
import bridge.GameResult;
import bridge.InputView;
import bridge.OutputView;
import bridge.Position;
import bridge.TryCounter;
import bridge.User;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        System.out.println("다리길이");
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<Direction> bridge = bridgeMaker.makeBridge(bridgeSize).stream().map(Direction::valueOf)
                .collect(Collectors.toList());

        System.out.println(bridge);

        TryCounter tryCounter = new TryCounter();
        GameResult gameResult = new GameResult(tryCounter);
        User user = new User(gameResult);
        Position position = new Position();
        BridgeGame bridgeGame = new BridgeGame(bridge, position, tryCounter, user);

        while (bridgeGame.playing()) {
            System.out.println("d or u");
            Direction moving = Direction.valueOf(inputView.readMoving());
            CrossChecker checker = bridgeGame.move(moving, position);
            outputView.printMap(user);
            if (quit(bridgeGame, checker)) {
                gameResult.gameFail();
                break;
            }
        }
        outputView.printResult(user);
    }

    private boolean quit(BridgeGame bridgeGame, CrossChecker checker) {
        if (CrossChecker.isFail(checker)) {
            System.out.println("r or q");
            String gameCommand = inputView.readGameCommand();
            if (retryOrNot(bridgeGame, gameCommand)) {
                return true;
            }
        }
        return false;
    }

    private boolean retryOrNot(BridgeGame bridgeGame, String gameCommand) {
        GameCommand continueOrQuit = bridgeGame.retry(gameCommand);
        if (continueOrQuit == GameCommand.Q) {
            return true;
        }
        return false;
    }
}
