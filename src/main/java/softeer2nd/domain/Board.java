package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    static final int MAX_SIZE = 8;
    static final int INITIAL_PIECE_COUNT = 32;
    private final int WHITE_PIECE_LINE = 6;
    private final int BLACK_PIECE_LINE = 1;
    private int pieceCount;
    List<List<Piece>> pieces;

    public Board() {
        initialize();
    }

    public void initialize() {
        pieceCount = INITIAL_PIECE_COUNT;
        pieces = new ArrayList<>();

        pieces.add(initRow(Type.KING, Color.BLACK));
        pieces.add(initRow(Type.PAWN, Color.BLACK));
        pieces.add(initRow(Type.BLANK, Color.NONE));
        pieces.add(initRow(Type.BLANK, Color.NONE));
        pieces.add(initRow(Type.BLANK, Color.NONE));
        pieces.add(initRow(Type.BLANK, Color.NONE));
        pieces.add(initRow(Type.PAWN, Color.WHITE));
        pieces.add(initRow(Type.KING, Color.WHITE));

    }

    private List<Piece> initRow(Type type, Color color) {
        if (!type.isBlank() && !type.isPawn()) return initPiecesArray(color);

        List<Piece> result = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            result.add(Piece.createPiece(type, color));
        }
        return result;
    }

    private List<Piece> initPiecesArray(Color color) {
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
        StringBuilder stringBuilder = new StringBuilder();

        for (List<Piece> row : pieces) {
            stringBuilder.append(concat(row));
        }

        return stringBuilder.toString();
    }

    public String getWhitePawnsResult() {
        return concat(pieces.get(WHITE_PIECE_LINE));
    }

    public String getBlackPawnsResult() {
        return concat(pieces.get(BLACK_PIECE_LINE));
    }

    private String concat(List<Piece> list) {
        return list.stream()
                .map(p -> {
                    char c = p.getType().getRepresentation();
                    if (p.isBlack()) c = Character.toUpperCase(c);
                    return c;
                })
                .map(String::valueOf)
                .collect(Collectors.joining())
                .concat(NEWLINE);
    }

    public int pieceCount() {
        return pieceCount;
    }
}
