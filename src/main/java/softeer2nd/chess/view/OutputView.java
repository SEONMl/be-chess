package softeer2nd.chess.view;

public class OutputView {
    public void gameEnd() {
        print("게임이 종료됐습니다.");
    }

    public void afterMove(String boardResult) {
        print(boardResult);
    }

    private void print(String content) {
        System.out.println(content);
    }
}
