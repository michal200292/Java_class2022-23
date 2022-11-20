import agh.ics.oop.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class OptionParserTest {

    @Test
    void test1(){
        String[] strMoves = new String[]{"f", "b", "backward", "forward", "left", "l", "right", "r", "b", "f", "l"};
        MoveDirection[] moves = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.LEFT};
        assertArrayEquals(moves, OptionParser.parse(strMoves));
    }

    @Test
    void test2(){
        String[] strMoves = new String[]{"f", "b", "prawo", "backward", "lewo"};
        assertThrows(IllegalArgumentException.class, () -> OptionParser.parse(strMoves));
    }
}
