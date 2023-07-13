package softeer2nd.chess.domain;

import softeer2nd.chess.domain.VO.Position;
import softeer2nd.chess.domain.enums.Color;
import softeer2nd.chess.domain.enums.Direction;
import softeer2nd.chess.domain.enums.Type;
import softeer2nd.chess.domain.pieces.Pawn;
import softeer2nd.chess.domain.pieces.Piece;
import softeer2nd.chess.exception.AlreadyPieceExistException;
import softeer2nd.chess.exception.NotAllowDirectionException;
import softeer2nd.chess.exception.NotMoveCommandException;
import softeer2nd.chess.exception.PawnAttackException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.chess.utils.StringUtils.NEWLINE;
import static softeer2nd.chess.utils.StringUtils.SPACE;

public class Board {

    public static final int MAX_SIZE = 8;
    public static final String COLUMN_REPRESENTATION = "abcdefgh";
    public static final int WHITE_PIECE_LINE = MAX_SIZE;
    public static final int BLACK_PIECE_LINE = 0;
    private final List<Rank> ranks;

    public Board() {
        ranks = initialize();
    }

    public List<Rank> initialize() {
        return new ArrayList<>(
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

    public boolean move(Position srcPosition, Position dstPosition) throws Exception {
        Piece piece = checkMovePossibility(srcPosition, dstPosition);
        Piece beforeChange = deleteOriginPiece(srcPosition);
        addPieceAt(dstPosition, beforeChange);
        return piece.getType() == Type.KING;
    }

    private Piece deleteOriginPiece(Position position) {
        int srcRank = position.getRow();
        Piece origin = findPiece(position);
        if (origin.getType() == Type.PAWN) {
            ((Pawn) origin).move();
        }

        ranks.get(srcRank).delete(position);
        return origin;
    }

    private void addPieceAt(Position position, Piece piece) {
        int dstRank = position.getRow();
        ranks.get(dstRank).add(position, piece);
    }

    private Piece checkMovePossibility(Position srcPosition, Position dstPosition) throws Exception {
        Direction headDirection = srcPosition.getDirection(dstPosition);
        if (headDirection.isNone()) {
            throw new NotMoveCommandException();
        }

        int hopeCount = srcPosition.getHopeCount(dstPosition);

        Piece from = findPiece(srcPosition);
        checkIsMovable(srcPosition, headDirection, hopeCount, from);

        Piece to = findPiece(dstPosition);
        if(to.getType() != Type.BLANK){
            checkSameColor(from, to);
            checkPawnAttack(from, headDirection);
        }

        return to;
    }

    private void checkPawnAttack(Piece from, Direction direction) throws PawnAttackException {
        if (from.getType() != Type.PAWN) return;

        if (direction.isStraight()) {
            throw new PawnAttackException();
        }

    }

    public Piece findPiece(Position position) {
        Rank target = ranks.get(position.getRow());
        return target.find(position.getColumn());
    }

    private void checkIsMovable(Position src, Direction direction, int hopeCount, Piece from) throws Exception {
        if (!from.verifyMovePosition(direction, hopeCount)) {
            throw new NotAllowDirectionException();
        }
        if (!notExistPieceInDirection(src, direction, hopeCount)) {
            throw new AlreadyPieceExistException();
        }
    }

    private void checkSameColor(Piece piece1, Piece piece2) throws Exception {
        if (isSameTeam(piece1, piece2)) {
            throw new AlreadyPieceExistException();
        }
    }

    private static boolean isSameTeam(Piece from, Piece to) {
        return from.isWhite() && to.isWhite() || from.isBlack() && to.isBlack();
    }

    private boolean notExistPieceInDirection(Position position, Direction direction, int hopeCount) {
        if (direction.isKnightMove()) return true;
        if (hopeCount == 0) return true;
        boolean result = true;

        Position nextPosition = direction.getNextPosition(position);
        if (hopeCount > 1 && checkIsNotEmpty(nextPosition)) {
            return false;
        }

        result &= notExistPieceInDirection(nextPosition, direction, hopeCount - 1);
        return result;
    }

    private boolean checkIsNotEmpty(Position position) {
        return findPiece(position).getType() != Type.BLANK;
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

    private String showRank(int row) {
        return ranks.get(row).show();
    }

    public double calculatePoint(Color color) {
        double totalPoint = ranks.stream()
                .mapToDouble(rank -> rank.sumPoint(color))
                .sum();

        // Pawn 만 따로 계산 : 점수 - 개수*0.5
        List<Integer> countOfPawns = countPawnsInRow(color);
        totalPoint += getOffsetPointWhenInRow(countOfPawns);

        return totalPoint;
    }

    private static double getOffsetPointWhenInRow(List<Integer> pawnCountInRow) {
        int offsetPoint = 0;
        for (int col = 0; col < MAX_SIZE; col++) {
            if (pawnCountInRow.get(col) > 1) {
                offsetPoint -= pawnCountInRow.get(col) * 0.5;
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

    public boolean checkTurnByColor(Position position, int round) {
        Piece target = findPiece(position);
        return target.isTurn(round);
    }
}
