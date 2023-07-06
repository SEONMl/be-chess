package softeer2nd.domain;

import softeer2nd.domain.VO.Color;
import softeer2nd.domain.VO.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.domain.Rank.initRow;
import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    static final int MAX_SIZE = 8;
    static final int INITIAL_PIECE_COUNT = 32;
    private final int WHITE_PIECE_LINE = 6;
    private final int BLACK_PIECE_LINE = 1;
    private int pieceCount;
    List<Rank> ranks;

    public Board() {
        ranks = new ArrayList<>();
    }

    public void initialize() {
        pieceCount = INITIAL_PIECE_COUNT;

        ranks.add(initRow(Type.KING, Color.BLACK));
        ranks.add(initRow(Type.PAWN, Color.BLACK));
        ranks.add(initRow(Type.BLANK, Color.NONE));
        ranks.add(initRow(Type.BLANK, Color.NONE));

        ranks.add(initRow(Type.BLANK, Color.NONE));
        ranks.add(initRow(Type.BLANK, Color.NONE));
        ranks.add(initRow(Type.PAWN, Color.WHITE));
        ranks.add(initRow(Type.KING, Color.WHITE));
    }

    public String show() {
        return ranks.stream()
                .map(Rank::show)
                .collect(Collectors.joining());
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
}
