package softeer2nd.chess.utils;

import softeer2nd.chess.domain.Board;
import softeer2nd.chess.exception.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String COMMAND_REGEX = "[a-z][0-9]";
    private Validation() {}

    public static void isRegularCommand(String command) throws NotRegularArgumentException {
        Pattern pattern = Pattern.compile(COMMAND_REGEX);
        Matcher matcher = pattern.matcher(command);

        if(!matcher.matches()){
            throw new NotRegularArgumentException();
        }
    }

    public static void isOutOfBoard(String command) throws OutOfBoardException {
        int column = command.charAt(0) - 'a';
        int row = Board.MAX_SIZE - (command.charAt(1) - '0');
        if (notInBound(column) || notInBound(row)) {
            throw new OutOfBoardException();
        }
    }

    private static boolean notInBound(int current) {
        return 0 > current || current >= Board.MAX_SIZE;
    }
}
