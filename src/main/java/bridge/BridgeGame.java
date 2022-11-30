package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<Direction> bridge;
    private Position position;
    private User user;

    public BridgeGame(List<Direction> bridge, Position position, User user) {
        this.bridge = bridge;
        this.position = position;
        this.user = user;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public CrossChecker move(Direction moving, Position position) {
        Direction now = bridge.get(position.getStep());
        CrossChecker crossOrNot = check(now, moving);
        user.crossBridge(moving, crossOrNot);
        position.increaseStep();
        return crossOrNot;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.reset();
        position.reset();
    }

    private CrossChecker check(Direction now, Direction moving) {
        if (now == moving) {
            return CrossChecker.SUCCESS;
        }
        return CrossChecker.FAIL;
    }

    public boolean playing() {
        return bridge.size() > position.getStep();
    }
}
