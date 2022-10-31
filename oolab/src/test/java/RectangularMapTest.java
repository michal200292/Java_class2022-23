import agh.ics.oop.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    void test_map1() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f"});
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertNotNull(map.objectAt(new Vector2d(2, 3)));
    }
}
