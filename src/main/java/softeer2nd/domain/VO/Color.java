package softeer2nd.domain.VO;

public enum Color {
    WHITE('p'),
    BLACK('P'),
    ;

    private final char representation;

    Color(char p) {
        this.representation = p;
    }

    public char getRepresentation() {
        return representation;
    }
}
