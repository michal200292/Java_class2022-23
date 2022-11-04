import agh.ics.oop.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest{
    @Test
    void test_map1() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "f", "f", "f", "l", "l", "r", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(4,4), new Vector2d(6,6)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(2, 4)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3, 5)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(5, 7)) instanceof Animal);
    }
    @Test
    void test_map2() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "l", "b", "r", "f", "l", "f", "f", "f", "r", "l", "l", "f", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1), new Vector2d(2,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(0, -2)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(1, -2)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(2, -2)) instanceof Animal);
    }
    @Test
    void test_map3() {
        MoveDirection[] directions = new OptionParser().parse(new String[]{"f", "f", "f", "f", "f", "f", "r", "l", "r", "l", "r", "l", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(0,1), new Vector2d(0,2), new Vector2d(0,3), new Vector2d(0,4), new Vector2d(0,5)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(2, 0)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(-2, 1)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(2, 2)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(-2, 3)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(2, 4)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(-2, 6)) instanceof Animal);
    }
}
