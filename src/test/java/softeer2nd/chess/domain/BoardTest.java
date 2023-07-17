package softeer2nd.chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.pieces.PieceFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 위에서 기물 찾기")
    void findPiece() throws Exception {
        Position expectWhiteRook = Position.transfer("a1");
        Position expectBlackRook = Position.transfer("a8");

        assertThat(board.findPiece(expectWhiteRook))
                .isEqualToComparingFieldByFieldRecursively(PieceFactory.createRook(Color.WHITE));
        assertThat(board.findPiece(expectBlackRook))
                .isEqualToComparingFieldByFieldRecursively(PieceFactory.createRook(Color.BLACK));
    }


    @Test
    @DisplayName("체스판의 기물 점수 구하는가?")
    void calculatePoint() throws Exception {
        double calculated = board.calculatePoint(Color.BLACK);

        assertEquals(38.0, calculated, 0.01);
        assertEquals(38.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.show());
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

        assertThat(board.findPiece(srcPosition))
                .isEqualToComparingFieldByFieldRecursively(PieceFactory.createBlankPiece());
        assertThat(board.findPiece(dstPosition))
                .isEqualToComparingFieldByFieldRecursively(PieceFactory.createKnight(Color.WHITE));
    }

    @Test
    @DisplayName("나이트는 기물을 뛰어 넘어 이동할 수 있다.")
    void knightCanMoveOverPiece() {
        Position source = Position.transfer("b1");
        Position destination = Position.transfer("c3");

        assertAll(() -> {
            board.move(source, destination);
        });
    }

    @Test
    @DisplayName("이동 경로에 기물이 있으면 이동할 수 없다.")
    void canNotMoveIfPieceExist() {
        Position source = Position.transfer("d1");
        Position destination = Position.transfer("a4");

        assertThrows(IllegalArgumentException.class, () -> {
            board.move(source, destination);
            System.out.println(board.show());
        });
    }
}
