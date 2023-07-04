package softeer2nd.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;
    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    public void createBoardWithWhitePawn() throws Exception {
        verifyBoard(ChessColor.WHITE);
    }

    @Test
    public void createBoardWithBlackPawn() throws Exception {
        verifyBoard(ChessColor.BLACK);
    }

    void verifyBoard(ChessColor color) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(1, board.size());
        assertEquals(pawn, board.findPawn(0));
    }
}
