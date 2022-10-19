import agh.ics.oop.Animal;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    void test_initialization(){
        Animal cat = new Animal();
        assertTrue(cat.isAt(new Vector2d(2, 2)));
        assertTrue(cat.isAt(new Vector2d(2, 2)));
    }

}
