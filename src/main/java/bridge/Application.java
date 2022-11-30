package bridge;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
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
            CrossChecker checker = bridgeGame.move(moving, position);
            if (CrossChecker.isFail(checker)) {
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("R")) {
                    bridgeGame.retry();
                }
                if (gameCommand.equals("Q")) {
                    break;
                }
            }
        }


    }
}
