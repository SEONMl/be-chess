package softeer2nd.chess.domain;

import org.ietf.jgss.Oid;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.chess.domain.Board.BLACK_PIECE_LINE;
import static softeer2nd.chess.domain.Board.WHITE_PIECE_LINE;

public class Rank {
    private List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public static Rank create(List<Piece> pieces) {
        return new Rank(pieces);
    }

    public static Rank createPawnArray(Color color) {
        int row = WHITE_PIECE_LINE + 1;
        if (color.isBlack()) {
            row = BLACK_PIECE_LINE - 1;
        }
        return new Rank(createSamePiecesArray(Type.PAWN, color, row));
    }

    public static Rank createBlankArray(int initialRow) {
        return new Rank(createSamePiecesArray(Type.BLANK, Color.NONE, initialRow));
    }

    public static Rank createDifferentPieceArray(Color color) {
        int row = WHITE_PIECE_LINE;
        if (color.isBlack()) {
            row = BLACK_PIECE_LINE;
        }

        List<Piece> result = Arrays.asList( //gg
                Piece.create(Type.ROOK, color, new Position(row, 0)),
                Piece.create(Type.KNIGHT, color, new Position(row, 1)),
                Piece.create(Type.BISHOP, color, new Position(row, 2)),
                Piece.create(Type.QUEEN, color, new Position(row, 3)),

                Piece.create(Type.KING, color, new Position(row, 4)),
                Piece.create(Type.BISHOP, color, new Position(row, 5)),
                Piece.create(Type.KNIGHT, color, new Position(row, 6)),
                Piece.create(Type.ROOK, color, new Position(row, 7))
        );
        return new Rank(new ArrayList<>(result));
    }

    private static List<Piece> createSamePiecesArray(Type type, Color color, int row) {
        List<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < Board.MAX_SIZE; i++) {
            pieces.add(Piece.create(type, color, new Position(row, i)));
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

    public void add(Position position, Piece piece) {
        int col = position.getCol();
        Piece newPiece = Piece.create(piece, position);
        this.pieces.set(col, newPiece);
    }

    public double sumPoint(Color color) {
        return pieces.stream()
                .filter(p -> p.getColor() == color)
                .map(Piece::getType)
                .mapToDouble(Type::getPoint)
                .sum();
    }

    public Piece delete(Position position) {
        int col = position.getCol();
        Piece beforeChange = find(col);
        // position 같은 객체..?
        this.pieces.set(col, Piece.createBlank(position));
        return beforeChange;
    }
}
