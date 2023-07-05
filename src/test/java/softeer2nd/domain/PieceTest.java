package softeer2nd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @Test
    @DisplayName("색깔을 가진 폰이 생성되어야 한다.")
    public void createPawn(){
        verifyPawn(Type.PAWN, Color.WHITE);
        verifyPawn(Type.KING, Color.BLACK);
    }

    void verifyPawn(final Type type, final Color color){
        Piece piece = Piece.createPiece(type, color);
        assertThat(piece.getColor()).isEqualTo(color);
    }
}
