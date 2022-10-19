import agh.ics.oop.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    void test_walks1(){
        Animal cat = new Animal();
        OptionParser parser = new OptionParser();
        String[] moves = new String[]{"f", "b", "l", "dasd", "r", "f", "l", "f", "f", "r", "f"};
        for(MoveDirection move : parser.parse(moves)){
            cat.move(move);
        }
        assertTrue(cat.isAt(new Vector2d(0, 4)));
        assertTrue(cat.isOriented(MapDirection.NORTH));
    }
    @Test
    void test_walks2(){
        Animal cat = new Animal();
        OptionParser parser = new OptionParser();
        String[] moves = new String[]{"f", "forward", "backward", "left", "f", "r", "f", "l", "f", "r", "f", "l", "l"};
        for(MoveDirection move : parser.parse(moves)){
            cat.move(move);
        }
        assertTrue(cat.isAt(new Vector2d(0, 4)));
        assertTrue(cat.isOriented(MapDirection.SOUTH));

    }
    @Test
    void test_walks3(){
        Animal cat = new Animal();
        OptionParser parser = new OptionParser();
        String[] moves = new String[]{"r", "r", "f", "r", "r", "b", "b", "b", "l", "f", "f", "f"};
        for(MoveDirection move : parser.parse(moves)){
            cat.move(move);
        }
        assertTrue(cat.isAt(new Vector2d(0, 0)));
        assertTrue(cat.isOriented(MapDirection.WEST));

    }
    @Test
    void test_walks4(){
        Animal cat = new Animal();
        OptionParser parser = new OptionParser();
        String[] moves = new String[]{"l", "f", "r", "f", "r", "f", "r", "f", "l", "l"};
        for(MoveDirection move : parser.parse(moves)){
            cat.move(move);
        }
        assertTrue(cat.isAt(new Vector2d(2, 2)));
        assertTrue(cat.isOriented(MapDirection.NORTH));

    }

}
