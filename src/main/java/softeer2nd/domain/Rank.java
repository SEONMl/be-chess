package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.domain.Board.MAX_SIZE;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Rank {
    List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public static Rank initRow(Type type, Color color) {
        if (!type.isBlank() && !type.isPawn()) return new Rank(initPiecesArray(color));

        List<Piece> result = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            result.add(Piece.createPiece(type, color));
        }
        return new Rank(result);
    }

    private static List<Piece> initPiecesArray(Color color) {
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
        return new ArrayList<>(result);
    }

    public String show() {
        return pieces.stream()
                .map(p -> {
                    char representation = p.getType().getRepresentation();
                    if (p.isBlack()) representation = Character.toUpperCase(representation);
                    return representation;
                })
                .map(String::valueOf)
                .collect(Collectors.joining())
                .concat(NEWLINE);
    }

}
