package softeer2nd.chess.controller;

import softeer2nd.chess.domain.Board;

import java.util.Scanner;

import static softeer2nd.chess.utils.StringUtils.SPACE;

public class GameController {
    private final String MOVE_COMMAND = "move";
    private Board chessBoard;
    private Scanner sc;
    private int round;

    public GameController(Board newBoard) {
        chessBoard = newBoard;
        sc = new Scanner(System.in);
        round = 0;
    }

    public void start() {
        chessBoard.initialize();
        System.out.println(chessBoard.show());
        run();
    }

    void run() {
        System.out.println("0 입력 시 종료됩니다.");
        while (true) {
            System.out.print(round % 2 + 1 + "님 입력 >>> ");
            round++;
            String cmd = sc.nextLine();
            if (cmd.equals("0")) break;

            isStartWithMove(cmd);

            System.out.println(chessBoard.show());
        }
        System.out.println("게임이 종료됐습니다.");
    }
    private void isStartWithMove(String command) {
        if(command.startsWith(MOVE_COMMAND)) {
            String[] splitCommand  = command.split(SPACE);
            commandMove(splitCommand[1], splitCommand[2]);
        }
    }

    private void commandMove(String srcPosition, String dstPosition) {
        chessBoard.move(srcPosition, dstPosition);
    }
}
