package softeer2nd.chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.pieces.PieceFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 위에서 기물 찾기")
    void findPiece() throws Exception {
        board.initialize();

        Position expectWhiteRook = Position.transfer("a8");
        Position expectBlackRook = Position.transfer("a1");

        assertEquals(PieceFactory.createRook(Color.WHITE), board.findPiece(expectWhiteRook));
        assertEquals(PieceFactory.createRook(Color.BLACK), board.findPiece(expectBlackRook));
    }


    @Test
    @DisplayName("체스판의 기물 점수 구하는가?")
    void calculatePoint() throws Exception {
        board.initialize();
        double calculated = board.calculatePoint(Color.BLACK);

        assertEquals(38.0, calculated, 0.01);
        assertEquals(38.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.show());
        board.sortScore(Color.BLACK);
    }


    @Test
    @DisplayName("체스판 위의 기물을 선택해서 이동이 되는가?")
    void move() throws Exception {
        board.initialize();
        String src = "b1";
        String dst = "c3";
        Position srcPosition = Position.transfer(src);
        Position dstPosition = Position.transfer(dst);


        board.move(srcPosition, dstPosition);

        assertEquals(PieceFactory.createBlankPiece(),
                board.findPiece(srcPosition));
        assertEquals(PieceFactory.createKnight(Color.WHITE),
                board.findPiece(dstPosition));
    }
}
