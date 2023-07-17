package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class finalTest {
    private final List<Integer> list =new ArrayList<>(List.of(1,2,3,4,5,6));;

    @Test
    void test() {
        list.set(0, 10);
        assertEquals(list.get(0), 10);
    } // 참조하는 주소값을 고정.. add, set 도 됨
}
