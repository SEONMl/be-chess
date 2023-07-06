package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.domain.Board.MAX_SIZE;

public class Rank {
    List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public static Rank create(List<Piece> pieces) {
        return new Rank(pieces);
    }

    public static Rank initPawnArray(Color color) {
        return new Rank(initSamePiecesArray(Type.PAWN, color));
    }

    public static Rank initBlankArray() {
        return new Rank(initSamePiecesArray(Type.BLANK, Color.NONE));
    }

    public static Rank initDifferentPieceArray(Color color) {
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

    private static List<Piece> initSamePiecesArray(Type type, Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            pieces.add(Piece.createPiece(type, color));
        }
        return pieces;
    }

    public String show() {
        return pieces.stream()
                .map(p -> {
                    char representation = p.getType().getRepresentation();
                    if (p.isBlack()) representation = Character.toUpperCase(representation);
                    return representation;
                })
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
}
