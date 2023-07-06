package softeer2nd.domain.enums;

public enum Type {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k'),
    BLANK('.'),
    ;

    private char representation;

    Type(char representation) {
        this.representation = representation;
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
}
