package softeer2nd.chess.domain;

import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Type;
import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.chess.utils.StringUtils.NEWLINE;
import static softeer2nd.chess.utils.StringUtils.SPACE;

public class Board {

    public static final int MAX_SIZE = 8;
    static final int INITIAL_PIECE_COUNT = 32;
    public static final String COLUMN_REPRESENTATION = "abcdefgh";
    public static final int WHITE_PIECE_LINE = MAX_SIZE;
    public static final int BLACK_PIECE_LINE = 0;
    private int pieceCount;
    private List<Rank> ranks;

    public Board() {
        initialize();
    }

    private Board(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void initialize() {
        pieceCount = INITIAL_PIECE_COUNT;
        ranks = new ArrayList<>(
                Arrays.asList(
                        Rank.createDifferentPieceArray(Color.BLACK),
                        Rank.createPawnArray(Color.BLACK),
                        Rank.createBlankArray(2),
                        Rank.createBlankArray(3),
                        Rank.createBlankArray(4),
                        Rank.createBlankArray(5),
                        Rank.createPawnArray(Color.WHITE),
                        Rank.createDifferentPieceArray(Color.WHITE)
                )
        );
    }

    public void initializeEmpty() {
        ranks = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            ranks.add(Rank.createBlankArray(i));
        }
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

        sb.append(showRank(row))
                .append(SPACE)
                .append(offsetRow)
                .append(SPACE)
                .append(NEWLINE);

        return sb.toString();
    }


    public void move(String src, String dst) {
        Position srcPosition = Position.transfer(src);
        Position dstPosition = Position.transfer(dst);

        Rank target = ranks.get(srcPosition.getRow());
        // 제거
        Piece beforeChange = target.delete(srcPosition);

        // 추가
        Rank nextTarget = ranks.get(dstPosition.getRow());
        nextTarget.add(dstPosition, beforeChange);
    }

    public String getWhitePawnsResult() {
        return showRank(WHITE_PIECE_LINE);
    }

    public String getBlackPawnsResult() {
        return showRank(BLACK_PIECE_LINE);
    }

    private String showRank(int row) {
        return ranks.get(row).show();
    }

    public int pieceCount() {
        return pieceCount;
    }

    public Piece findPiece(String expression) {
        Position position = Position.transfer(expression);
        Rank target = ranks.get(position.getRow());
        return target.find(position.getCol());
    }

    public double calculatePoint(Color color) {
        double totalPoint = ranks.stream()
                .mapToDouble(rank -> rank.sumPoint(color))
                .sum();

        // Pawn 만 따로 계산 : 점수 - 개수*0.5
        List<Integer> countOfPawns = countPawnsInRow(color);
        totalPoint += offsetPointWhenInRow(countOfPawns);

        return totalPoint;
    }

    private static double offsetPointWhenInRow(List<Integer> countOfPawns) {
        int offsetPoint = 0;
        for (int col = 0; col < MAX_SIZE; col++) {
            if (countOfPawns.get(col) > 1) {
                offsetPoint -= countOfPawns.get(col) * 0.5;
            }
        }
        return offsetPoint;
    }

    private List<Integer> countPawnsInRow(Color color) {
        List<Integer> rowCountOfPawns = new ArrayList<>(Collections.nCopies(MAX_SIZE, 0));
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                if (existColoredPawnAt(row, col, color)) {
                    rowCountOfPawns.set(row, rowCountOfPawns.get(row) + 1);
                }
            }
        }
        return rowCountOfPawns;
    }

    private boolean existColoredPawnAt(int row, int col, Color color) {
        return ranks.get(row).find(col).equalsTypeAndColor(Type.PAWN, color);
    }

    public void sortScore(Color color) {
        SortedMap<Type, Double> pointOfTypes = new TreeMap<>();

        for (int row = 0; row < MAX_SIZE; row++) {
            for (int col = 0; col < MAX_SIZE; col++) {
                Piece target = ranks.get(row).find(col);
                pointOfTypes.put(target.getType(),
                        pointOfTypes.getOrDefault(target.getType(), 0D)
                                + target.getType().getPoint());
            }
        }
        System.out.println(pointOfTypes);
    }
}
