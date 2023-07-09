package softeer2nd.chess.domain.pieces;

import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;

public class BlankPiece implements Piece {
    private final Color color;
    private final Type type;

    BlankPiece(Color color) {
        this.color = color;
        this.type = Type.BLANK;
    }

    @Override
    public char getRepresentation() {
        return type.getRepresentation();
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
        return Type.BLANK == type && this.color == color;
    }
}
