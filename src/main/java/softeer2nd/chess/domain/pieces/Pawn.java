package softeer2nd.chess.domain.pieces;

import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;
import softeer2nd.chess.domain.enums.Type;

public class Pawn implements Piece {
    private final Color color;
    private final Type type;

    Pawn(Color color) {
        this.color = color;
        this.type = Type.PAWN;
    }

    public boolean verifyAttack(Direction direction, int count) {
        if (color.isBlack()) {
            return (Direction.SOUTHEAST == direction
                    || Direction.SOUTHWEST == direction)
                    && count == 1;
        }
        return (Direction.NORTHEAST == direction
                || Direction.NORTHWEST == direction)
                && count == 1;
    }


    @Override
    public boolean verifyMovePosition(Direction direction, int count) {
        if (color.isBlack()) {
            return Direction.SOUTH == direction && count == 1;
        }
        return Direction.NORTH == direction && count == 1;
    }

    @Override
    public char getRepresentation() {
        char representation = this.type.getRepresentation();
        if (this.color.isBlack()) {
            return Character.toUpperCase(representation);
        }
        return representation;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    @Override
    public boolean isWhite() {
        return color.isWhite();
    }

    @Override
    public boolean isBlack() {
        return color.isBlack();
    }

    @Override
    public boolean equalsTypeAndColor(Type type, Color color) {
        return Type.PAWN == type && this.color == color;
    }

    @Override
    public boolean isMovable(int round) {
        return color.checkRound(round);
    }
}
