package softeer2nd.chess.controller;

import softeer2nd.chess.domain.Board;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.utils.Validation;
import softeer2nd.chess.view.InputView;
import softeer2nd.chess.view.OutputView;

import java.util.Scanner;

import static softeer2nd.chess.utils.StringUtils.SPACE;

public class GameController {
    private final String MOVE_COMMAND = "move";
    private final String EXIT_COMMAND = "exit";

    private final InputView inputView;
    private final OutputView outputView;
    private final Board chessBoard;
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
        outputView.afterMove(chessBoard.show());
        run();
    }

    void run() {
        int round = 0;
        while (true) {
            String command = inputCommandUntilPossibleToMove(round);
            if (exit(command)) {
                break;
            }
            outputView.afterMove(chessBoard.show());
            round++;
        }
        outputView.gameEnd();
    }

    private String inputCommandUntilPossibleToMove(int round) {
        boolean enterCorrectly = true;
        String command = "";
        while (enterCorrectly) {
            enterCorrectly = false;
            inputView.beforeMove(round);
            command = sc.nextLine();
            try {
                isStartWithMove(command, round % Color.COLOR_COUNT);
            } catch (IllegalArgumentException e) {
                outputView.print(e.toString());
                enterCorrectly = true;
            }
        }
        return command;
    }

    private void isStartWithMove(String command, int round) throws Exception {
        if (command.startsWith(MOVE_COMMAND)) {
            String[] splitCommand = command.split(SPACE);
            validateCommand(splitCommand[1]);
            moveOnlyYourPieces(splitCommand[1], round);

            validateCommand(splitCommand[2]);
            commandMove(splitCommand[1], splitCommand[2]);
        }
    }

    private void validateCommand(String position) throws Exception {
        Validation.isRegularCommand(position);
        Validation.isOutOfBoard(position);
    }

    private void moveOnlyYourPieces(String position, int round) { // 0: 흰, 1: 검
        Position targetPosition = Position.transfer(position);
        if (!chessBoard.checkTurnByColor(targetPosition, round)) {
            throw new IllegalArgumentException("자신의 기물만 움직일 수 있습니다.");
        }
    }

    private void commandMove(String src, String dst) throws Exception {
        Position srcPosition = Position.transfer(src);
        Position dstPosition = Position.transfer(dst);
        chessBoard.move(srcPosition, dstPosition);
    }

    private boolean exit(String command) {
        return command.startsWith(EXIT_COMMAND);
    }

}
