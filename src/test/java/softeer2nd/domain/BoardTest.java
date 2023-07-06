package softeer2nd.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    public static final String REPRESENTATION_BLACK = "........";
    private Board board;
    private String REPRESENTATION_PAWN = "pppppppp";
    private String REPRESENTATION_PIECES = "rnbqkbnr";

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 위에서 기물 찾기")
    void findPiece() throws Exception {
        board.initialize();

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

}
