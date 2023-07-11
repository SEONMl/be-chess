package softeer2nd.chess.domain;

import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;
import softeer2nd.chess.domain.enums.Type;
import softeer2nd.chess.domain.pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.chess.utils.StringUtils.NEWLINE;
import static softeer2nd.chess.utils.StringUtils.SPACE;
import static softeer2nd.chess.utils.Validation.*;
import static softeer2nd.chess.utils.Validation.THROW_ALREADY_PIECE_EXIST;

public class Board {

    public static final int MAX_SIZE = 8;
    public static final String COLUMN_REPRESENTATION = "abcdefgh";
    public static final int WHITE_PIECE_LINE = MAX_SIZE;
    public static final int BLACK_PIECE_LINE = 0;
    private List<Rank> ranks;

    public Board() {
        initialize();
    }

    private Board(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void initialize() {
        ranks = new ArrayList<>(
                Arrays.asList(
                        Rank.createDifferentPieceArray(Color.BLACK),
                        Rank.createPawnArray(Color.BLACK),
                        Rank.createBlankArray(),
                        Rank.createBlankArray(),
                        Rank.createBlankArray(),
                        Rank.createBlankArray(),
                        Rank.createPawnArray(Color.WHITE),
                        Rank.createDifferentPieceArray(Color.WHITE)
                )
        );
    }


    private void checkMovePossibility(Position src, Position dst) throws IllegalArgumentException {
        Direction direction = src.getDirection(dst);
        if (direction.isNone()) {
            NOT_A_MOVE_COMMAND();
        }

        int count = getCount(src, dst);

        Piece from = getTargetAt(src);
        if (!from.verifyMovePosition(direction, count)) {
            NOT_ALLOW_DIRECTION();
        }
        if (!notExistPiece(src.getRow(), src.getCol(), direction, count)) {
            THROW_ALREADY_PIECE_EXIST();
        }

        Piece to = getTargetAt(dst);
        if(isSameColor(from, to)){
            THROW_ALREADY_PIECE_EXIST();
        }
    }

    private static boolean isSameColor(Piece from, Piece to) {
        return from.isWhite() && to.isWhite() || from.isBlack() && to.isBlack();
    }

    private Piece getTargetAt(Position position) {
        return ranks.get(position.getRow()).find(position.getCol());
    }

    private static int getCount(Position src, Position dst) {
        int x = src.getRow();
        int y = src.getCol();
        int nx = dst.getRow();
        int ny = dst.getCol();
        int count = Math.abs(nx - x);
        if (nx - x == 0) {
            count = Math.abs(ny - y);
        }
        return count;
    }

    private boolean notExistPiece(int row, int col, Direction direction, int count) {
        if (direction.isKnightMove()) return true;
        if (count == 0) return true;
        boolean result = true;

        int nextRow = row - direction.getXDegree();
        int nextCol = col - direction.getYDegree();
        if (!ranks.get(nextRow).isEmptyPlace(nextCol)) {
            return false;
        }
        result &= notExistPiece(nextRow, nextCol, direction, count - 1);
        return result;
    }


    public String show() {
        StringBuilder sb = new StringBuilder();

        sb.append(IntStream.range(0, MAX_SIZE)
                        .mapToObj(this::joinRankOf)
                        .collect(Collectors.joining()))
                .append(NEWLINE)
                .append(COLUMN_REPRESENTATION);
        return sb.toString();
    }

    private String joinRankOf(int row) {
        int offsetRow = MAX_SIZE - row;
        StringBuilder sb = new StringBuilder();

        sb.append(showRank(row))
                .append(SPACE)
                .append(offsetRow)
                .append(SPACE)
                .append(NEWLINE);

        return sb.toString();
    }

    public void move(Position srcPosition, Position dstPosition) throws IllegalArgumentException {
        checkMovePossibility(srcPosition, dstPosition);
        Rank target = ranks.get(srcPosition.getRow());
        // 제거
        Piece beforeChange = target.delete(srcPosition);

        // 추가
        Rank nextTarget = ranks.get(dstPosition.getRow());
        nextTarget.add(dstPosition, beforeChange);
    }

    private String showRank(int row) {
        return ranks.get(row).show();
    }

    public Piece findPiece(Position position) {
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
                    rowCountOfPawns.set(col, rowCountOfPawns.get(col) + 1);
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

    public boolean checkMovableByColor(Position position, int round) {
        Piece target = findPiece(position);
        if(target.isMovable(round)) {
            return true;
        }
        return false;
    }
}
