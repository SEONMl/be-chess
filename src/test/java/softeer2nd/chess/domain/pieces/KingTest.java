package softeer2nd.chess.domain.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private Piece white;
    private Piece black;

    @BeforeEach
    void setup() {
        white = PieceFactory.createKing(Color.WHITE);
        black = PieceFactory.createKing(Color.BLACK);
    }

    @ParameterizedTest
    @EnumSource(names = {"NORTH", "NORTHEAST", "EAST", "SOUTH"})
    @DisplayName("모든 방향으로만 이동 가능하다.")
    void mustMoveKingDirection(Direction direction) {
        int hopeCount = 1;

        assertTrue(white.verifyMovePosition(direction, hopeCount));
        assertTrue(black.verifyMovePosition(direction, Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @EnumSource(names = {"NORTH", "NORTHEAST", "EAST", "SOUTH"})
    @DisplayName("한 칸만 이동 가능하다.")
    void mustMoveKingDirection_false(Direction direction) {
        int hopeCount = 2;

        assertFalse(white.verifyMovePosition(direction, hopeCount));
        assertFalse(black.verifyMovePosition(direction, Integer.MAX_VALUE));
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