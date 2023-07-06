package softeer2nd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PieceTest {

    @Test
    @DisplayName("색깔을 가진 폰이 생성되어야 한다.")
    public void createPawn() {
        verifyPawn(Type.PAWN, Color.WHITE);
        verifyPawn(Type.KING, Color.BLACK);
    }

    void verifyPawn(final Type type, final Color color) {
        Piece piece = Piece.createPiece(type, color);
        assertThat(piece.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기물과 색깔 별로 인스턴스 생성되는지?")
    void createPiece() {
        verifyPiece(Piece.createWhitePawn(), Type.PAWN, Color.WHITE);
        verifyPiece(Piece.createWhiteKing(), Type.KING, Color.WHITE);
        verifyPiece(Piece.createWhiteBishop(), Type.BISHOP, Color.WHITE);
        verifyPiece(Piece.createWhiteKnight(), Type.KNIGHT, Color.WHITE);
        verifyPiece(Piece.createWhiteQueen(), Type.QUEEN, Color.WHITE);
        verifyPiece(Piece.createWhiteRook(), Type.ROOK, Color.WHITE);

        verifyPiece(Piece.createBlackPawn(), Type.PAWN, Color.BLACK);
        verifyPiece(Piece.createBlackKing(), Type.KING, Color.BLACK);
        verifyPiece(Piece.createBlackBishop(), Type.BISHOP, Color.BLACK);
        verifyPiece(Piece.createBlackKnight(), Type.KNIGHT, Color.BLACK);
        verifyPiece(Piece.createBlackQueen(), Type.QUEEN, Color.BLACK);
        verifyPiece(Piece.createBlackRook(), Type.ROOK, Color.BLACK);
    }

    void verifyPiece(Piece piece, Type type, Color color) {
        assertEquals(color, piece.getColor());
        assertEquals(type, piece.getType());
    }

    @Test
    @DisplayName("Blank 기물이 잘 생성되었는지")
    void createBlank(){
        Piece blank = Piece.createBlank();

        assertFalse(blank.isBlack());
        assertFalse(blank.isWhite());
        assertEquals(Type.BLANK, blank.getType());
        assertEquals(Color.NONE, blank.getColor());
    }
}
