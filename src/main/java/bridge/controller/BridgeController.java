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
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        System.out.println();

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
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
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
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String gameCommand = inputView.readGameCommand();
            if (bridgeGame.retryOrNot(gameCommand)) {
                return true;
            }
        }
        return false;
    }
}
