package softeer2nd.chess.controller;

import softeer2nd.chess.domain.Board;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.State;
import softeer2nd.chess.utils.Validation;
import softeer2nd.chess.view.InputView;
import softeer2nd.chess.view.OutputView;

import java.util.Scanner;

import static softeer2nd.chess.utils.StringUtils.SPACE;

public class GameController {
    public static final int FROM_POSITION_INDEX = 1;
    public static final int TO_POSITION_INDEX = 2;
    private final String MOVE_COMMAND = "move";
    private final String EXIT_COMMAND = "exit";

    private final InputView inputView;
    private final OutputView outputView;
    private final Board chessBoard;
    private final Scanner sc;
    private State gameState;


    public GameController(Board newBoard) {
        this.chessBoard = newBoard;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.sc = new Scanner(System.in);
        gameState = State.START;
    }

    public void start() {
        chessBoard.initialize();
        inputView.gameStart();
        outputView.afterMove(chessBoard.show());
        run();
    }

    void run() {
        int round = 0;
        while (!gameState.isEnd()) {
            String command = inputCommandUntilPossibleToMove(round++);
            if (exit(command)) {
                break;
            }
            outputView.afterMove(chessBoard.show());
        }
        outputView.gameEnd(round);
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
            } catch (Exception e) {
                outputView.print(e.getMessage());
                enterCorrectly = true;
            }
        }
        return command;
    }

    private void isStartWithMove(String command, int round) throws Exception {
        if (command.startsWith(MOVE_COMMAND)) {
            String[] splitCommand = command.split(SPACE);
            String fromPosition = splitCommand[FROM_POSITION_INDEX];
            String toPosition = splitCommand[TO_POSITION_INDEX];

            validateCommand(fromPosition);
            moveOnlyYourPieces(fromPosition, round);

            validateCommand(toPosition);
            commandMove(fromPosition, toPosition);
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
        boolean kingDied = chessBoard.move(srcPosition, dstPosition);
        if(kingDied){
            this.gameState = State.END;
        }
    }

    private boolean exit(String command) {
        return command.startsWith(EXIT_COMMAND);
    }

}
