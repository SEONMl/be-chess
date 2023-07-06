package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import java.util.Objects;

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
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createBlank() {
        return new Piece(Type.BLANK, Color.NONE);
    }

    private static Piece createWhite(Type type) {
        return new Piece(type, Color.WHITE);
    }

    private static Piece createBlack(Type type) {
        return new Piece(type, Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return this.color.isWhite();
    }

    public boolean isBlack() {
        return this.color.isBlack();
    }

    public boolean equalsTypeAndColor(Type type, Color color) {
        return this.type == type && this.color == color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", type=" + type +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
