package softeer2nd.chess.domain.pieces;

import softeer2nd.chess.domain.enums.Color;

public class PieceFactory {
    public static Piece createKing(Color color) {
        return new King(color);
    }

    public static Piece createQueen(Color color) {
        return new Queen(color);
    }

    public static Piece createBishop(Color color){
        return new Bishop(color);
    }

    public static Piece createKnight(Color color){
        return new Knight(color);
    }

    public static Piece createRook(Color color){
        return new Rook(color);
    }

    public static Piece createPawn(Color color){
        return new Pawn(color);
    }

    public static Piece createBlankPiece(){
        return new BlankPiece(Color.NONE);
    }
}
