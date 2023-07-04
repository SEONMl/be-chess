package softeer2nd.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> pieces = new ArrayList<Pawn>();

    public void add(Pawn pawn) {
        pieces.add(pawn);
    }

    public int size() {
        return pieces.size();
    }

    public Pawn findPawn(int i) {
        return pieces.get(i);
    }
}
