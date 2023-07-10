package softeer2nd.chess.domain.pieces;

import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;
import softeer2nd.chess.domain.enums.Type;

public class Bishop implements Piece {
    private final Color color;
    private final Type type; // 없애고 싶다...

    @Override
    public boolean verifyMovePosition(Direction direction, int count) {
        return false;
    }

    Bishop(Color color) {
        this.color = color;
        this.type = Type.BISHOP;
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
    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    @Override
    public Type getType() {
        return type;
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
        return Type.BISHOP == type && this.color == color;
    }
}
