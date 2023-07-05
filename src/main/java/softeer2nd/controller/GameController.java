package softeer2nd.controller;

import softeer2nd.domain.Board;

import java.util.Scanner;

public class GameController {
    private Board chessBoard;
    private Scanner sc;
    private int round;

    public GameController(Board newBoard) {
        chessBoard = newBoard;
        sc = new Scanner(System.in);
        round=0;
    }

    public void start() {
        chessBoard.initialize();
        chessBoard.show();
        run();
    }

    void run(){
        System.out.println("0 입력 시 종료됩니다.");
        while(true){
            System.out.print(round%2+1+"님 입력 >>> ");
            round++;
            int i = sc.nextInt();

            if(i==0) break;
        }
        System.out.println("게임이 종료됐습니다.");
    }
}
