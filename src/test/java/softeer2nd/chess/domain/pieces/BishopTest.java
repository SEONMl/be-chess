package softeer2nd.chess.domain.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private Piece white;
    private Piece black;

    @BeforeEach
    void setup() {
        white = PieceFactory.createBishop(Color.WHITE);
        black = PieceFactory.createBishop(Color.BLACK);
    }

    @ParameterizedTest
    @EnumSource(names = {"NORTHEAST", "SOUTHWEST", "SOUTHEAST", "NORTHWEST"})
    @DisplayName("대각선 방향으로만 이동 가능하다.")
    void mustMoveBishopDirection(Direction direction) {
        int hopeCount = 1;

        assertTrue(white.verifyMovePosition(direction, hopeCount));
        assertTrue(black.verifyMovePosition(direction, Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @EnumSource(names = {"NORTH", "NNE", "EAST", "EES"})
    @DisplayName("나이트 방향으로만 이동 가능하다.")
    void mustMoveBishopDirection_false(Direction direction) {
        int hopeCount = 1;

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