package softeer2nd.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @Test
    @DisplayName("색깔을 가진 폰이 생성되어야 한다.")
    public void createPawn(){
        Pawn pawn = new Pawn("white");
        Pawn blackPawn = new Pawn("black");

        assertThat(pawn.getColor()).isEqualTo("white");
        assertThat(blackPawn.getColor()).isEqualTo("black");
    }
}

// 주간 스터디 플랜, 먼저 만들기