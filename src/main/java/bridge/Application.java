package bridge;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static InputView inputView = new InputView();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리길이");
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<Direction> bridge = bridgeMaker.makeBridge(bridgeSize).stream().map(Direction::valueOf)
                .collect(Collectors.toList());

        System.out.println(bridge);

        User user = new User();
        Position position = new Position();
        TryCounter tryCounter = new TryCounter();
        BridgeGame bridgeGame = new BridgeGame(bridge, position, tryCounter, user);

        while (bridgeGame.playing()) {
            Direction moving = Direction.valueOf(inputView.readMoving());
            System.out.println("d or u");
            CrossChecker checker = bridgeGame.move(moving, position);
            if (quit(bridgeGame, checker)) {
                break;
            }
        }


    }

    private static boolean quit(BridgeGame bridgeGame, CrossChecker checker) {
        if (CrossChecker.isFail(checker)) {
            System.out.println("r or q");
            String gameCommand = inputView.readGameCommand();
            if (retryOrNot(bridgeGame, gameCommand)) {
                return true;
            }
        }
        return false;
    }

    private static boolean retryOrNot(BridgeGame bridgeGame, String gameCommand) {
        GameCommand continueOrQuit = bridgeGame.retry(gameCommand);
        if (continueOrQuit == GameCommand.Q) {
            return true;
        }
        return false;
    }
}
