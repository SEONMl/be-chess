package softeer2nd.chess.domain.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import softeer2nd.chess.domain.enums.Direction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static softeer2nd.chess.domain.enums.Color.BLACK;
import static softeer2nd.chess.domain.enums.Color.WHITE;

class PawnTest {

    private Piece white;
    private Piece black;

    @BeforeEach
    void setup() {
        white = PieceFactory.createPawn(WHITE);
        black = PieceFactory.createPawn(BLACK);
    }

    @Test
    @DisplayName("앞으로 방향으로만 이동 가능하다.")
    void mustMoveWhitePawn() {
        int hopeCount = 1;
        Direction north = Direction.NORTH;
        Direction south = Direction.SOUTH;

        assertTrue(white.verifyMovePosition(north, hopeCount));
        assertFalse(white.verifyMovePosition(south, hopeCount));
    }

    @Test
    @DisplayName("앞으로 방향으로만 이동 가능하다.")
    void mustMoveBlackPawn() {
        int hopeCount = 1;
        Direction north = Direction.NORTH;
        Direction south = Direction.SOUTH;

        assertTrue(black.verifyMovePosition(north, hopeCount));
        assertFalse(black.verifyMovePosition(south, hopeCount));
    }

    @Test
    @DisplayName("자기 턴에 움직이는가?")
    void doesPieceMoveInItsTurn() {
        int whiteTurn = 0;
        int blackTurn = 1;

        assertTrue(white.isTurn(whiteTurn));
        assertTrue(black.isTurn(blackTurn));

        assertFalse(white.isTurn(blackTurn));
        assertFalse(black.isTurn(whiteTurn));
    }
}