package softeer2nd.domain.enums;

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
    private double score;

    private Type(char representation, double score) {
        this.representation = representation;
        this.score = score;
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

    public double getScore() {
        return score;
    }
}
