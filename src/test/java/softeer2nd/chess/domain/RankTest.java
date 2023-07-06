package softeer2nd.chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    private Rank rank;

    @BeforeEach
    void setup() {
    }

    @Test
    @DisplayName("기물의 색과 종류를 인자로 받았을 때 개수를 반환")
    void countPiecesWhenTypeAndColor() {
        Color color = Color.BLACK;
        rank = Rank.createPawnArray(color);

        int result = rank.count(Type.PAWN, color);

        assertEquals(Board.MAX_SIZE, result);
    }
}