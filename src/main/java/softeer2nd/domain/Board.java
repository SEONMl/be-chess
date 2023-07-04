package softeer2nd.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final int MAX_SIZE = 8;
    char[][] pieces;

    public Board() {
        pieces = new char[MAX_SIZE][MAX_SIZE];
    }

    public void initialize() {
        char tmp[] = {'.', 'p', 'P'}, c;

        for (int i = 0; i < MAX_SIZE; i++) {
            if (i == 1) c = tmp[2];
            else if (i == 6) c = tmp[1];
            else c = tmp[0];

            for (int j = 0; j < MAX_SIZE; j++) {
                pieces[i][j] = c;
            }
        }
    }

    public void print() {
        for(char[] row : pieces){
            System.out.println(new String(row));
        }
    }

    public String getWhitePawnsResult() {
        return new String(pieces[6]);
    }

    public String getBlackPawnsResult() {
        return new String(pieces[1]);
    }
}
