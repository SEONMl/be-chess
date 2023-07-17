package softeer2nd.chess.exception;

public class NotRegularArgumentException  extends CustomException{
    private static final String Not_REGULAR_ARGUMENT_MESSAGE = "이동 명령은 연속된 소문자 하나와 숫자 문자 하나로 표현해주세요.";

    public NotRegularArgumentException() {
        super(Not_REGULAR_ARGUMENT_MESSAGE);
    }
}
