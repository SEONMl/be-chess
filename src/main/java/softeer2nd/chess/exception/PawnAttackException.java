package softeer2nd.chess.exception;

public class PawnAttackException extends CustomException{
    private static final String PAWN_ATTACK_MESSAGE = "폰 공격은 대각선으로만 가능합니다.";
    public PawnAttackException() {
        super(PAWN_ATTACK_MESSAGE);
    }
}
