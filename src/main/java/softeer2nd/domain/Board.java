package softeer2nd.domain;

import softeer2nd.domain.VO.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.utils.StringUtils.NEWLINE;
import static softeer2nd.utils.StringUtils.SPACE;

public class Board {

    static final int MAX_SIZE = 8;
    static final int INITIAL_PIECE_COUNT = 32;
    public static final String COLUMN_REPRESENTATION = "abcdefgh";
    private final int WHITE_PIECE_LINE = 6;
    private final int BLACK_PIECE_LINE = 1;
    private int pieceCount;
    List<Rank> ranks;

    public Board() {
        initialize();
    }

    public void initialize() {
        pieceCount = INITIAL_PIECE_COUNT;
        ranks = new ArrayList<>(
                Arrays.asList(
                        Rank.initDifferentPieceArray(Color.BLACK),
                        Rank.initPawnArray(Color.BLACK),
                        Rank.initBlankArray(),
                        Rank.initBlankArray(),
                        Rank.initBlankArray(),
                        Rank.initBlankArray(),
                        Rank.initPawnArray(Color.WHITE),
                        Rank.initDifferentPieceArray(Color.WHITE)
                )
        );
    }

    public String show() {
        StringBuilder sb = new StringBuilder();

        sb.append(IntStream.range(0, MAX_SIZE)
                        .mapToObj(this::view)
                        .collect(Collectors.joining()))
                .append(NEWLINE)
                .append(COLUMN_REPRESENTATION);
        return sb.toString();
    }

    private String view(int row) {
        int offsetRow = MAX_SIZE - row;
        StringBuilder sb = new StringBuilder();

        sb.append(ranks.get(row).show())
                .append(SPACE)
                .append(offsetRow)
                .append(SPACE)
                .append(NEWLINE);

        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return ranks.get(WHITE_PIECE_LINE).show();
    }

    public String getBlackPawnsResult() {
        return ranks.get(BLACK_PIECE_LINE).show();
    }

    public int pieceCount() {
        return pieceCount;
    }

    public Piece findPiece(String position) {
        int col = position.charAt(0) - 'a';
        int row = position.charAt(1) - '0';
        return ranks.get(MAX_SIZE - row).find(col);
    }
}
