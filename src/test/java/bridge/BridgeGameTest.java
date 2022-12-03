package bridge;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
    }

    @Test
    void 이동_테스트() {
        CrossChecker crossChecker = bridgeGame.move(Direction.D);
        assertThat(crossChecker).isEqualTo(CrossChecker.FAIL);
        User user = bridgeGame.getUser();
        assertThat(user.getDownBridge()).contains(String.valueOf(crossChecker.getResult()));
    }

    @Test
    void 재시작_테스트() {
        bridgeGame.move(Direction.D);
        GameCommand gameCommand = bridgeGame.retry("R");
        assertThat(gameCommand).isEqualTo(GameCommand.R);
        User user = bridgeGame.getUser();
        assertThat(user.getUpBridge()).isEmpty();
        assertThat(user.getDownBridge()).isEmpty();
    }

    @Test
    void 재시작_종료_테스트() {
        bridgeGame.move(Direction.D);
        GameCommand gameCommand = bridgeGame.retry("Q");
        assertThat(gameCommand).isEqualTo(GameCommand.Q);
        User user = bridgeGame.getUser();
        assertThat(user.getUpBridge()).isNotEmpty();
        assertThat(user.getDownBridge()).isNotEmpty();
    }
}
