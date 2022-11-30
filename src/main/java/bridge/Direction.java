package bridge;

import java.util.Arrays;

public enum Direction {
    U(1), D(0);

    private int directionCode;

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }

    public static Direction from(int directionCode) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.directionCode == directionCode)
                .findAny().orElseThrow(IllegalStateException::new);
    }
}
