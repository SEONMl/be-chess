package softeer2nd.chess.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}