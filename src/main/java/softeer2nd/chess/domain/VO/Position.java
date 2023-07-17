package softeer2nd.chess.domain.VO;

import softeer2nd.chess.domain.Board;
import softeer2nd.chess.domain.enums.Direction;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Position transfer(String expression) {
        int row = Board.MAX_SIZE - (expression.charAt(1) - '0');
        int col = expression.charAt(0) - 'a';
        return new Position(row, col);
    }

    public Direction getDirection(Position nextPosition) {
        int dRow = this.row - nextPosition.getRow();
        int dCol = this.column - nextPosition.getColumn();
        return Direction.getDirection(dRow, dCol);
    }

    // 두 끝 점이 일직선에 위치할 때 사용한다.
    public int getHopeCount(Position position) {
        int nRow = position.getRow();
        int nColumn = position.getColumn();
        return (nRow - this.column == 0)? Math.abs(nRow - this.row) : Math.abs(nColumn - this.column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn(){
        return column;
    }
}
