package softeer2nd.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @Test
    @DisplayName("흰 색 폰이 생성되어야 한다.")
    public void createWhitePawn(){
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
    }
}
