package softeer2nd.chess.domain.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import softeer2nd.chess.domain.enums.Direction;

import static org.junit.jupiter.api.Assertions.*;

class BlankPieceTest {
    private Piece piece;

    @BeforeEach
    void setup() {
        piece = PieceFactory.createBlankPiece();
    }

    @ParameterizedTest
    @EnumSource(names = {"NORTH", "NNE", "EAST", "EES"})
    @DisplayName("움직일 수 없다.")
    void mustMoveKnightsDirection_false(Direction direction) {
        int hopeCount = 1;

        assertFalse(piece.verifyMovePosition(direction, hopeCount));
    }
}