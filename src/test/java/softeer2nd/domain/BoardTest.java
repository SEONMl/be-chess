package softeer2nd.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;
    private String REPRESENTATION_PAWN = "pppppppp";

    @BeforeEach
    void init() {
        board = new Board();
        board.initialize();
    }

    @Test
    void initialize() throws Exception {
        assertEquals(REPRESENTATION_PAWN, board.getWhitePawnsResult());
        assertEquals(REPRESENTATION_PAWN.toUpperCase(), board.getBlackPawnsResult());
    }
}
