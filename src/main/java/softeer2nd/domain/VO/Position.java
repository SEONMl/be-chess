package softeer2nd.domain.VO;

import static softeer2nd.domain.Board.MAX_SIZE;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Position transfer(String expression) {
        int row = MAX_SIZE - (expression.charAt(1) - '0');
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
