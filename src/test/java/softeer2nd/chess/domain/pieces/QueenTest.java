package softeer2nd.chess.domain.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {


    private Piece white;
    private Piece black;

    @BeforeEach
    void setup() {
        white = PieceFactory.createQueen(Color.WHITE);
        black = PieceFactory.createQueen(Color.BLACK);
    }

    @ParameterizedTest
    @EnumSource(names = {"NNE", "NNW", "EES", "EEN", "SSE"})
    @DisplayName("모든 방향으로만 이동 가능하다.")
    void mustMoveDirection(Direction direction) {
        int hopeCount = 1;

        assertTrue(white.verifyMovePosition(direction, hopeCount));
        // 범위 체크는 보드에서 합니다.
        assertTrue(black.verifyMovePosition(direction, Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @EnumSource(names = {"NNE", "NNW", "EEN", "SSE"})
    @DisplayName("나이트 방향으로 이동할 수 없다.")
    void mustMoveDirection_false(Direction direction) {
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