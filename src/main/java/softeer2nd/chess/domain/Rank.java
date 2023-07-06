package softeer2nd.chess.domain;

import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rank {
    private List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public static Rank create(List<Piece> pieces) {
        return new Rank(pieces);
    }

    public static Rank createPawnArray(Color color) {
        return new Rank(createSamePiecesArray(Type.PAWN, color));
    }

    public static Rank createBlankArray() {
        return new Rank(createSamePiecesArray(Type.BLANK, Color.NONE));
    }

    public static Rank createDifferentPieceArray(Color color) {
        List<Piece> result = Arrays.asList(
                Piece.createPiece(Type.ROOK, color),
                Piece.createPiece(Type.KNIGHT, color),
                Piece.createPiece(Type.BISHOP, color),
                Piece.createPiece(Type.QUEEN, color),

                Piece.createPiece(Type.KING, color),
                Piece.createPiece(Type.BISHOP, color),
                Piece.createPiece(Type.KNIGHT, color),
                Piece.createPiece(Type.ROOK, color)
        );
        return new Rank(new ArrayList<>(result));
    }

    private static List<Piece> createSamePiecesArray(Type type, Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < Board.MAX_SIZE; i++) {
            pieces.add(Piece.createPiece(type, color));
        }
        return pieces;
    }

    public String show() {
        return pieces.stream()
                .map(Piece::representationOf)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public int count(Type type, Color color) {
        return (int) pieces.stream()
                .filter(p -> p.equalsTypeAndColor(type, color))
                .count();
    }

    public Piece find(int position) {
        return pieces.get(position);
    }

    public void add(int index, Piece piece) {
        this.pieces.set(index, piece);
    }

    public double sumPoint(Color color) {
        return pieces.stream()
                .filter(p -> p.getColor() == color)
                .map(Piece::getType)
                .mapToDouble(Type::getPoint)
                .sum();
    }
}
