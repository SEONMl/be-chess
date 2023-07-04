package softeer2nd.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private final int MAX_SIZE = 8;
    List<List<Character>> pieces;

    public Board() {
        pieces = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            pieces.add(new ArrayList<>());
        }
    }

    public void initialize() {
        char[] tmp = {'.', 'p', 'P'};
        char c = tmp[0];

        for (int i = 0; i < MAX_SIZE; i++) {
            if (i == 1) c = tmp[2];
            else if (i == 6) c = tmp[1];

            for (int j = 0; j < MAX_SIZE; j++) {
                pieces.get(i).add(j, c);
            }
        }
    }

    public void print() {
        for (List<Character> row : pieces) {
            System.out.println(concat(row));
        }
    }

    public String getWhitePawnsResult() {
        return concat(pieces.get(6));
    }

    public String getBlackPawnsResult() {
        return concat(pieces.get(1));
    }

    private String concat(List<Character> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
