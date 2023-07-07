package softeer2nd.chess;

import softeer2nd.chess.controller.GameController;
import softeer2nd.chess.domain.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        new GameController(board).start();
    }
}


/*
mission 5
## 구현 내용
- Board 클래스에서 List<List<Piece>> -> List<Rank>로 리팩토링
- 체스판 위의 기물 추가하기
- 각 기물 별 점수 설정하기
- 체스판 위에 있는 기물 색깔 별 점수 구하기
- 기물 점수를 내림차순으로 정렬

## 고민 사항
- Rank와 Piece 둘 다 관리해야 해서 로직 고민이 많았다.
- 구현을 하고 리팩토링을 해야 할지 리팩토링을 하고 구현을 해야 할지 고민했는데 중간에 하는 게 더 낫다는 생각이 든다. 미션5가 끝나니 미션4와 많은 것들이 달라졌다.
- Board의 ranks를 stream으로 Piece까지 접근할 수 없을까? Rank 클래스에서 Stream<Piece> 를 반환? -> 그럼 필드를 직접 접근하는 거랑 뭐가 다른 건지? 이런 생각 자체가 틀린 건가

## 기타
- 디버깅 연습 좀 해야겠다. 상현님이 디버깅 도와주셔서 빨리 해결할 수 있었다.

테스트 커버리지 테스트가 얼마나 잘 수행되고 있는지를 확인
객체 생성 비용 < VO의 장점
 */