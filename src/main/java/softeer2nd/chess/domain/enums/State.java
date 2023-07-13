package softeer2nd.chess.domain.enums;

public enum State {
    START,
    DOING,
    END
    ;

    public boolean isEnd() {
        return this == END;
    }
}
