package softeer2nd.chess.controller;

import softeer2nd.chess.domain.Board;
import softeer2nd.chess.view.InputView;
import softeer2nd.chess.view.OutputView;

import java.util.Scanner;

import static softeer2nd.chess.utils.StringUtils.SPACE;

public class GameController {
    private final String MOVE_COMMAND = "move";
    private final String EXIT_COMMAND = "exit";

    private final InputView inputView;
    private final OutputView outputView;
    private Board chessBoard;
    private final Scanner sc;


    public GameController(Board newBoard) {
        this.chessBoard = newBoard;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.sc = new Scanner(System.in);
    }

    public void start() {
        chessBoard.initialize();
        inputView.gameStart();
        run();
    }

    void run() {
        int round = 0;
        while (true) {
            inputView.beforeMove(round);
            round++;
            String cmd = sc.nextLine();
            if (exit(cmd)) {
                break;
            }

            isStartWithMove(cmd);
            outputView.afterMove(chessBoard.show());
        }
        outputView.gameEnd();
    }

    private void isStartWithMove(String command) {
        if (command.startsWith(MOVE_COMMAND)) {
            String[] splitCommand = command.split(SPACE);
            commandMove(splitCommand[1], splitCommand[2]);
        }
    }

    private void commandMove(String srcPosition, String dstPosition) {
        chessBoard.move(srcPosition, dstPosition);
    }

    private boolean exit(String command) {
        return command.equals(EXIT_COMMAND);
    }

}
