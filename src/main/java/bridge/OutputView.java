package bridge;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(User user) {
        List<String> upBridge = user.getUpBridge();
        List<String> downBridge = user.getDownBridge();

        System.out.println("[ " + String.join(" | ", upBridge) + " ]");
        System.out.println("[ " + String.join(" | ", downBridge) + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println("최종 게임 결과");
        printMap(user);

        GameResult gameResult = user.getGameResult();
        GameResultDto gameResultDto = GameResultDto.from(gameResult);

        System.out.println(gameResultDto.getResult());
        System.out.println(gameResultDto.getCount());
    }
}
