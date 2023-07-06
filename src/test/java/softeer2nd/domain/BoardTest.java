package softeer2nd.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.domain.enums.Color;

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

    @Test
    void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.show());
    }

    @Test
    @DisplayName("체스판의 기물 점수 구하는가?")
    void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());
        addPiece("h1", Piece.createWhitePawn());
        addPiece("h2", Piece.createWhitePawn());

        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(8.0, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.show());
        board.sortScore(Color.BLACK);
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
