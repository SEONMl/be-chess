package softeer2nd.chess.domain.enums;

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
