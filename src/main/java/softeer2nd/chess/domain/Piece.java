package softeer2nd.chess.domain;

import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final Type type;
    private final Position position;

    private Piece(Type type, Color color, Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public static Piece create(Type type, Color color, Position position) {
        return new Piece(type, color, position);
    }

    public static Piece create(Piece piece, Position position) {
        return new Piece(piece.getType(), piece.getColor(), position);
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(Type.PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(Type.PAWN, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return createWhite(Type.BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return createBlack(Type.BISHOP, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(Type.ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(Type.ROOK, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(Type.KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(Type.KNIGHT, position);
    }

    public static Piece createWhiteKing(Position position) {
        return createWhite(Type.KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return createBlack(Type.KING, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return createWhite(Type.QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return createBlack(Type.QUEEN, position);
    }

    public static Piece createBlank(Position position) {
        return new Piece(Type.BLANK, Color.NONE, position);
    }

    private static Piece createWhite(Type type, Position position) {
        return new Piece(type, Color.WHITE, position);
    }

    private static Piece createBlack(Type type, Position position) {
        return new Piece(type, Color.BLACK, position);
    }

    public char representationOf() {
        char representation = this.type.getRepresentation();
        if (this.color.isBlack()) {
            return Character.toUpperCase(representation);
        }
        return representation;
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
