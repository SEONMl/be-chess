package softeer2nd.chess.domain.enums;

import java.util.Set;

public enum Direction {
    NORTH(1, 0),
    NORTHEAST(1, 1),
    EAST(0, 1),
    SOUTHEAST(-1, 1),
    SOUTH(-1, 0),
    SOUTHWEST(-1, -1),
    WEST(0, -1),
    NORTHWEST(1, -1),

    NNE(1, 2),
    NNW(-1, 2),
    SSE(1, -2),
    SSW(-1, -2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1),

    NONE(0, 0);

    private int xDegree;
    private int yDegree;

    private Direction(int xDegree, int yDegree) {
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public int getXDegree() {
        return xDegree;
    }

    public int getYDegree() {
        return yDegree;
    }

    public static Direction getDirection(int dRow, int dCol) {
        for (Direction direction : Direction.values()) {
            if (direction.isSame(dRow, dCol)) return direction;
        }
        return Direction.NONE;
    }

    private boolean isSame(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        if (x == 0) y /= absY;
        else if (y == 0) x /= absX;
        if (absX == absY) {
            x /= absX;
            y /= absY;
        }
        return xDegree == x && yDegree == y;
    }

    public boolean isNone() {
        return this == NONE;
    }

    public static Set<Direction> linearDirection() {
        return Set.of(NORTH, EAST, SOUTH, WEST);
    }

    public static Set<Direction> diagonalDirection() {
        return Set.of(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static Set<Direction> everyDirection() {
        return Set.of(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static Set<Direction> knightDirection() {
        return Set.of(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

    public static Set<Direction> whitePawnDirection() {
        return Set.of(NORTH, NORTHEAST, NORTHWEST);
    }

    public static Set<Direction> blackPawnDirection() {
        return Set.of(SOUTH, SOUTHEAST, SOUTHWEST);
    }

    public boolean isKnightMove() {
        return knightDirection().contains(this);
    }
}
