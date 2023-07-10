package softeer2nd.chess;

import softeer2nd.chess.controller.GameController;
import softeer2nd.chess.domain.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        new GameController(board).start();
    }
}
/*
처음에 설계를 매우 잘해야겠다는 느낌..
 */