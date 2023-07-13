package softeer2nd.chess.exception;

public class OutOfBoardException extends CustomException {
    private static final String OUT_OF_BOARD_MESSAGE = "이동 입력이 범위 밖을 넘어갔습니다.";
    public OutOfBoardException() {
        super(OUT_OF_BOARD_MESSAGE);
    }
}
