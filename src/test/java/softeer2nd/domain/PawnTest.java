package softeer2nd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    private static final ChessColor WHITE = ChessColor.WHITE;
    private static final ChessColor BLACK = ChessColor.BLACK;

    @Test
    @DisplayName("색깔을 가진 폰이 생성되어야 한다.")
    public void createPawn(){
        verifyPawn(WHITE);
        verifyPawn(BLACK);
    }

    void verifyPawn(final ChessColor color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}

// 주간 스터디 플랜, 먼저 만들기