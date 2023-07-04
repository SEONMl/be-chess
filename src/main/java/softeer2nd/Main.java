package softeer2nd;

import softeer2nd.controller.GameController;
import softeer2nd.domain.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        new GameController(board).start();
    }
}