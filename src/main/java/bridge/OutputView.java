package bridge;

import java.util.List;

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
    public void printResult(BridgeGame bridgeGame) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getUser());

        GameResult gameResult = bridgeGame.gameResult();
        System.out.println("게임 성공 여부: " + gameResult.getResult());
        System.out.println("총 시도한 횟수: " + gameResult.getCount());
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRestartMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
}
