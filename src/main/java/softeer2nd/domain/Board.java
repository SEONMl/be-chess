package softeer2nd.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final int MAX_SIZE = 8;
    String[] pieces;

    public Board() {
        pieces = new String[MAX_SIZE];
    }

    public void initialize() {
        char tmp[] = {'.', 'p', 'P'}, c;

        for (int i = 0; i < MAX_SIZE; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == 1) c = tmp[2];
            else if (i == 6) c = tmp[1];
            else c = tmp[0];

            for(int j=0;j<MAX_SIZE;j++){
                sb.append(c);
            }
            pieces[i]=sb.toString();
        }
    }

    public void print() {
        for(String row : pieces){
            System.out.println(row);
        }
    }

    public String getWhitePawnsResult() {
        return pieces[6];
    }

    public String getBlackPawnsResult() {
        return pieces[1];
    }
}
