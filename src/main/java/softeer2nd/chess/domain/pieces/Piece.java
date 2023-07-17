package softeer2nd.chess.domain.pieces;

import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;
import softeer2nd.chess.domain.enums.Type;

public interface Piece {

    public boolean verifyMovePosition(Direction direction, int count);

    public char getRepresentation();

    public boolean isSameColor(Color color);

    public Type getType();

    public boolean isWhite();

    public boolean isBlack();

    public boolean equalsTypeAndColor(Type type, Color hopeCount); // -> equals 상속!

    boolean isTurn(int gameRound); // 이름 바꾸기
}
