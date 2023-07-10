package softeer2nd.chess.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;
import softeer2nd.chess.domain.pieces.Piece;
import softeer2nd.chess.domain.pieces.PieceFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {


    @Test
    @DisplayName("기물과 색깔 별로 인스턴스 생성되는지?")
    void createPiece() {

        verifyPiece(PieceFactory.createPawn(Color.WHITE), Type.PAWN, Color.WHITE);
        verifyPiece(PieceFactory.createKing(Color.WHITE), Type.KING, Color.WHITE);
        verifyPiece(PieceFactory.createBishop(Color.WHITE), Type.BISHOP, Color.WHITE);
        verifyPiece(PieceFactory.createKnight(Color.WHITE), Type.KNIGHT, Color.WHITE);
        verifyPiece(PieceFactory.createQueen(Color.WHITE), Type.QUEEN, Color.WHITE);
        verifyPiece(PieceFactory.createRook(Color.WHITE), Type.ROOK, Color.WHITE);

        verifyPiece(PieceFactory.createPawn(Color.BLACK), Type.PAWN, Color.BLACK);
        verifyPiece(PieceFactory.createKing(Color.BLACK), Type.KING, Color.BLACK);
        verifyPiece(PieceFactory.createBishop(Color.BLACK), Type.BISHOP, Color.BLACK);
        verifyPiece(PieceFactory.createKnight(Color.BLACK), Type.KNIGHT, Color.BLACK);
        verifyPiece(PieceFactory.createQueen(Color.BLACK), Type.QUEEN, Color.BLACK);
        verifyPiece(PieceFactory.createRook(Color.BLACK), Type.ROOK, Color.BLACK);
    }

    void verifyPiece(Piece piece, Type type, Color color) {
        assertTrue(piece.equalsTypeAndColor(type, color));
    }

    @Test
    @DisplayName("Blank 기물이 잘 생성되었는지")
    void createBlank() {
        Piece blank = PieceFactory.createBlankPiece();

        assertFalse(blank.isBlack());
        assertFalse(blank.isWhite());
        assertEquals(Type.BLANK, blank.getType());
    }
}
