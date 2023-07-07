package softeer2nd.chess.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PieceTest {

    private Position samplePosition = Position.transfer("a1");

    @Test
    @DisplayName("기물과 색깔 별로 인스턴스 생성되는지?")
    void createPiece() {

        verifyPiece(Piece.createWhitePawn(samplePosition), Type.PAWN, Color.WHITE);
        verifyPiece(Piece.createWhiteKing(samplePosition), Type.KING, Color.WHITE);
        verifyPiece(Piece.createWhiteBishop(samplePosition), Type.BISHOP, Color.WHITE);
        verifyPiece(Piece.createWhiteKnight(samplePosition), Type.KNIGHT, Color.WHITE);
        verifyPiece(Piece.createWhiteQueen(samplePosition), Type.QUEEN, Color.WHITE);
        verifyPiece(Piece.createWhiteRook(samplePosition), Type.ROOK, Color.WHITE);

        verifyPiece(Piece.createBlackPawn(samplePosition), Type.PAWN, Color.BLACK);
        verifyPiece(Piece.createBlackKing(samplePosition), Type.KING, Color.BLACK);
        verifyPiece(Piece.createBlackBishop(samplePosition), Type.BISHOP, Color.BLACK);
        verifyPiece(Piece.createBlackKnight(samplePosition), Type.KNIGHT, Color.BLACK);
        verifyPiece(Piece.createBlackQueen(samplePosition), Type.QUEEN, Color.BLACK);
        verifyPiece(Piece.createBlackRook(samplePosition), Type.ROOK, Color.BLACK);
    }

    void verifyPiece(Piece piece, Type type, Color color) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
    }

    @Test
    @DisplayName("Blank 기물이 잘 생성되었는지")
    void createBlank(){
        Piece blank = Piece.createBlank(samplePosition);

        assertFalse(blank.isBlack());
        assertFalse(blank.isWhite());
        assertEquals(Type.BLANK, blank.getType());
        assertEquals(Color.NONE, blank.getColor());
    }
}
