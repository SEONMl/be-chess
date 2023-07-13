package softeer2nd.chess.exception;

public class NotMoveCommandException extends CustomException {
    private static final String NOT_MOVE_COMMAND = "이동을 하지 않는 명령입니다.";

    public NotMoveCommandException() {
        super(NOT_MOVE_COMMAND);
    }
}
