package softeer2nd.chess.utils;

import softeer2nd.chess.domain.Board;

public class Validation {
    private Validation() {}

    public static void isOutOfBoard(String command) throws IllegalArgumentException {
        int column = command.charAt(0) - 'a';
        int row = Board.MAX_SIZE - (command.charAt(1) - '0');
        if (notInBound(column) || notInBound(row)) {
            throw new IllegalArgumentException("잘못된 이동 명령을 내렸습니다.");
        }
    }

    private static boolean notInBound(int current) {
        return 0 > current || current >= Board.MAX_SIZE;
    }


    public static void NOT_A_MOVE_COMMAND() throws IllegalArgumentException {
        throw new IllegalArgumentException("이동을 하지 않는 명령입니다.");
    }

    public static void THROW_ALREADY_PIECE_EXIST() throws IllegalArgumentException {
        throw new IllegalArgumentException("동선에 기물이 존재하여 이동할 수 없습니다.");
    }

    public static void NOT_ALLOW_DIRECTION() throws IllegalArgumentException {
        throw new IllegalArgumentException("이동할 수 없는 방향입니다.");
    }
}
