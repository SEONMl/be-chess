package softeer2nd.chess.domain.enums;

public enum Color {
    WHITE(0),
    BLACK(1),
    NONE(-1),
    ;
    private final int round;

    Color(int round) {
        this.round = round;
    }

    public boolean isWhite() {
        return this == WHITE;
    }

    public boolean isBlack() {
        return this == BLACK;
    }

    public boolean checkRound(int round) {
        return this.round == round;
    }
}
