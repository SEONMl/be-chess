package softeer2nd.chess.exception;

import softeer2nd.chess.view.OutputView;

public abstract class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
