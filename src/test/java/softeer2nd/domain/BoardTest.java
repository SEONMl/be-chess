package softeer2nd.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.domain.Board.INITIAL_PIECE_COUNT;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class BoardTest {

    public static final String REPRESENTATION_BLACK = "........";
    private Board board;
    private String REPRESENTATION_PAWN = "pppppppp";
    private String REPRESENTATION_PIECES = "rnbqkbnr";

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 생성 후 초기화가 잘 되어 있는지?")
    void initializePieces() throws Exception {
        board.initialize();

        assertEquals(INITIAL_PIECE_COUNT, board.pieceCount());
        String blankRank = appendNewLine(REPRESENTATION_BLACK);

        assertEquals(
                appendNewLine(REPRESENTATION_PIECES.toUpperCase()) +
                        appendNewLine(REPRESENTATION_PAWN).toUpperCase() +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine(REPRESENTATION_PAWN) +
                        appendNewLine(REPRESENTATION_PIECES),
                board.show()
        );
    }
}
