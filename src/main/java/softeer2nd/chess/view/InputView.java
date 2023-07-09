package softeer2nd.chess.view;

public class InputView {

    public void gameStart() {
        print("체스 게임을 시작합니다.");
        print("'exit' 입력 시 종료됩니다.");
    }

    public void beforeMove(int round) {
        print(round % 2 + 1 + "님 입력 >>> ");
    }

    private void print(String content){
        System.out.println(content);
    }

}
