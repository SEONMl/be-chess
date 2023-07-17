package softeer2nd.chess.exception;

public class NotAllowDirectionException extends CustomException {
    private static final String NOT_ALLOW_DIRECTION_MESSAGE = "이동할 수 없는 방향입니다.";

    public NotAllowDirectionException() {
        super(NOT_ALLOW_DIRECTION_MESSAGE);
    }
}
