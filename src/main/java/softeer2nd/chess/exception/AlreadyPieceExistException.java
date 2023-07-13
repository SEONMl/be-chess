package softeer2nd.chess.exception;

public class AlreadyPieceExistException extends CustomException{
    private static final String ALREADY_PIECE_EXIST_MESSAGE = "동선에 기물이 존재하여 이동할 수 없습니다.";
    public AlreadyPieceExistException() {
        super(ALREADY_PIECE_EXIST_MESSAGE);
    }
}
