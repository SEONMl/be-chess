package softeer2nd.chess.domain.enums;

public enum Type {
    BLANK('.', 0.0),
    PAWN('p',1.0), // 더블 폰 이면 0.5 점
    KNIGHT('n', 2.5),
    BISHOP('b', 3.0),
    ROOK('r', 5.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    ;

    private char representation;
    private double point;

    private Type(char representation, double point) {
        this.representation = representation;
        this.point = point;
    }


    public char getRepresentation() {
        return representation;
    }

    public boolean isPawn() {
        return this == PAWN;
    }

    public boolean isBlank() {
        return this == BLANK;
    }

    public double getPoint() {
        return point;
    }
}
