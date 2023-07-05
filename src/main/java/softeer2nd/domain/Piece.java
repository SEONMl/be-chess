package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

public class Piece {
    private final Color color;
    private final Type type;

    private Piece(Type type, Color color) {
        this.color = color;
        this.type = type;
    }

    public static Piece createPiece(Type type, Color color) {
        return new Piece(type, color);
    }

    public static Piece createWhitePawn() {
        return createPiece(Type.PAWN, Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return createPiece(Type.PAWN, Color.BLACK);
    }
    public static Piece createWhiteBishop() {
        return createPiece(Type.BISHOP, Color.WHITE);
    }

    public static Piece createBlackBishop() {
        return createPiece(Type.BISHOP, Color.BLACK);
    }
    public static Piece createWhiteRook() {
        return createPiece(Type.ROOK, Color.WHITE);
    }

    public static Piece createBlackRook() {
        return createPiece(Type.ROOK, Color.BLACK);
    }
    public static Piece createWhiteKnight() {
        return createPiece(Type.KNIGHT, Color.WHITE);
    }

    public static Piece createBlackKnight() {
        return createPiece(Type.KNIGHT, Color.BLACK);
    }
    public static Piece createWhiteKing() {
        return createPiece(Type.KING, Color.WHITE);
    }

    public static Piece createBlackKing() {
        return createPiece(Type.KING, Color.BLACK);
    }

    public static Piece createWhiteQueen() {
        return createPiece(Type.QUEEN, Color.WHITE);
    }

    public static Piece createBlackQueen() {
        return createPiece(Type.QUEEN, Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }
}
