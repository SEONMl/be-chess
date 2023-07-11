package softeer2nd.chess.domain;

import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;
import softeer2nd.chess.domain.pieces.Piece;
import softeer2nd.chess.domain.pieces.PieceFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.chess.domain.Board.BLACK_PIECE_LINE;
import static softeer2nd.chess.domain.Board.WHITE_PIECE_LINE;

public class Rank {
    private final List<Piece> pieces;

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
        return new Rank(createSamePiecesArray(Type.PAWN, color));
    }

    public static Rank createBlankArray() {
        return new Rank(createSamePiecesArray(Type.BLANK, Color.NONE));
    }

    public static Rank createDifferentPieceArray(Color color) {
        int row = WHITE_PIECE_LINE;
        if (color.isBlack()) {
            row = BLACK_PIECE_LINE;
        }

        List<Piece> result = Arrays.asList( //gg
                PieceFactory.createRook(color),
                PieceFactory.createKnight(color),
                PieceFactory.createBishop(color),
                PieceFactory.createQueen(color),

                PieceFactory.createKing(color),
                PieceFactory.createBishop(color),
                PieceFactory.createKnight(color),
                PieceFactory.createRook(color)
        );
        return new Rank(new ArrayList<>(result));
    }

    private static List<Piece> createSamePiecesArray(Type type, Color color) {
        List<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < Board.MAX_SIZE; i++) {
            pieces.add(pieceOf(type, color));
        }
        return pieces;
    }

    private static Piece pieceOf(Type type, Color color) {
        if(type == Type.PAWN) {
            return PieceFactory.createPawn(color);
        }
        return PieceFactory.createBlankPiece();
    }

    public String show() {
        return pieces.stream()
                .map(Piece::getRepresentation)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public int count(Type type, Color color) {
        return (int) pieces.stream()
                .filter(p -> p.equalsTypeAndColor(type, color))
                .count();
    }

    public Piece find(int col) {
        return pieces.get(col);
    }

    public void add(Position position, Piece piece) {
        int col = position.getColumn();
        this.pieces.set(col, piece);
    }

    public double sumPoint(Color color) {
        return pieces.stream()
                .filter(p -> p.isSameColor(color))
                .map(Piece::getType)
                .mapToDouble(Type::getPoint)
                .sum();
    }

    public void delete(Position position) {
        int col = position.getColumn();
        this.pieces.set(col, PieceFactory.createBlankPiece());
    }
}
