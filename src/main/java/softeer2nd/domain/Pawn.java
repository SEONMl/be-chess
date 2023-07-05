package softeer2nd.domain;

public class Pawn {
    private final ChessColor color;
    private final char representation;

    public Pawn() {
        this.color = ChessColor.WHITE;
        this.representation = color.getRepresentation();
    }

    public Pawn(ChessColor color) {
        this.color = color;
        this.representation = color.getRepresentation();
    }

    public ChessColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
