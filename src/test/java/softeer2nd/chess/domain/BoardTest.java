package softeer2nd.chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.domain.pieces.Piece;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;

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

        assertEquals(Piece.createBlackRook(Position.transfer("a8")), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(Position.transfer("h8")), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(Position.transfer("a1")), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(Position.transfer("h1")), board.findPiece("h1"));
    }


    @Test
    @DisplayName("체스판의 기물 점수 구하는가?")
    void calculatePoint() throws Exception {
        board.initialize();

        assertEquals(38.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(38.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.show());
        board.sortScore(Color.BLACK);
    }


    @Test
    @DisplayName("체스판 위의 기물을 선택해서 이동이 되는가?")
    void move() throws Exception {
        board.initialize();
        String srcPosition = "b1";
        String dstPosition = "c3";

        board.move(srcPosition, dstPosition);

        assertEquals(Piece.createBlank(Position.transfer(srcPosition)),
                board.findPiece(srcPosition));
        assertEquals(Piece.createWhiteKnight(Position.transfer(dstPosition)),
                board.findPiece(dstPosition));
    }
}
