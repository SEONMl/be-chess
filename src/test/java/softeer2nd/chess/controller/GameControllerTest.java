package softeer2nd.chess.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import softeer2nd.chess.domain.Board;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameControllerTest {

    private GameController controller;

    @BeforeEach
    void init() {
        Board board = new Board();
        controller = new GameController(board);
    }

    @DisplayName("체스판 범위 내의 입력을 받아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a0", "z4", "4d", "aa", "11"})
    void commandMustInChessBoardSize(String command) {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.forTest_validateCommand(command);
        });
    }
}