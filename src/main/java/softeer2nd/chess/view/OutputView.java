package softeer2nd.chess.view;

public class OutputView {
    public void gameEnd(int round) {
        printGameResult(round);
        print("게임이 종료됐습니다.");
    }

    private void printGameResult(int round) {
        if (round % 2 == 1) {
            print("백 기물 승리");
            return;
        }
        print("흑 기물 승리");
    }

    public void afterMove(String boardResult) {
        print(boardResult);
    }

    public void print(String content) {
        System.out.println(content);
    }
}
