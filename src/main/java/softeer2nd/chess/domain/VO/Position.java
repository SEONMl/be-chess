package softeer2nd.chess.domain.VO;

import softeer2nd.chess.domain.Board;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Position transfer(String expression) {
        int row = Board.MAX_SIZE - (expression.charAt(1) - '0');
        int col = expression.charAt(0) - 'a';
        return new Position(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol(){
        return col;
    }
}
