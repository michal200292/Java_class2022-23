import agh.ics.oop.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    void test_map1() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "f", "f", "f", "l", "l", "r", "f", "f"});
        IWorldMap map = new RectangularMap(6, 6);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(4,4), new Vector2d(6,6)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 4)));
        assertTrue(map.isOccupied(new Vector2d(5, 6)));
        assertTrue(map.isOccupied(new Vector2d(3, 5)));
    }

    @Test
    void test_map2() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"b", "b", "b", "b", "r", "r", "f", "f", "f", "f"});
        IWorldMap map = new RectangularMap(6, 6);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 0)));
    }

    @Test
    void test_map3() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "f", "r", "f", "f", "r", "r", "r", "f", "b", "r", "f", "f", "l", "f", "f"});
        IWorldMap map = new RectangularMap(1, 1);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 0)));
        assertTrue(map.isOccupied(new Vector2d(1, 0)));
    }
}
