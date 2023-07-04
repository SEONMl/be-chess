package softeer2nd.domain;

public class Pawn {
    private final ChessColor color;

    public Pawn(){
        this.color=ChessColor.WHITE;
    }

    public Pawn(ChessColor color){
        this.color=color;
    }

    public ChessColor getColor() {
        return color;
    }
}
