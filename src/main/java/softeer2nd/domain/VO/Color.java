package softeer2nd.domain.VO;

public enum Color {
    WHITE,
    BLACK,
    NONE,
    ;

    public boolean isWhite() {
        return this == WHITE;
    }

    public boolean isBlack() {
        return this == BLACK;
    }
}
