package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

public class Piece {
    private final Color color;
    private final Type type;

    private Piece(Type type, Color color) {
        this.color = color;
        this.type = type;
    }

    public static Piece createPiece(Type type, Color color) {
        return new Piece(type, color);
    }

    public Color getColor() {
        return color;
    }

}
