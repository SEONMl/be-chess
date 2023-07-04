package softeer2nd.domain;

public enum ChessColor {
    WHITE('p'),
    BLACK('P'),
    ;

    private final char representation;

    ChessColor(char p) {
        this.representation = p;
    }

    public char getRepresentation() {
        return representation;
    }
}
