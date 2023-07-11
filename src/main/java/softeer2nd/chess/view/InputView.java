package softeer2nd.chess.view;

import softeer2nd.chess.domain.enums.Color;

public class InputView {

    public void gameStart() {
        print("체스 게임을 시작합니다.");
        print("'exit' 입력 시 종료됩니다.");
    }

    public void beforeMove(int round) {
        print(round % Color.COLOR_COUNT + 1 + "님 입력 >>> ");
    }

    private void print(String content){
        System.out.println(content);
    }

}
