import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    void next_test_north(){
        MapDirection test_object = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, test_object.next());
    }

    @Test
    void next_test_east(){
        MapDirection test_object = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, test_object.next());
    }

    @Test
    void next_test_south(){
        MapDirection test_object = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, test_object.next());
    }

    @Test
    void next_test_west(){
        MapDirection test_object = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, test_object.next());
    }

    @Test
    void previous_test_north(){
        MapDirection test_object = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, test_object.previous());
    }

    @Test
    void previous_test_east(){
        MapDirection test_object = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, test_object.previous());
    }

    @Test
    void previous_test_south(){
        MapDirection test_object = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, test_object.previous());
    }

    @Test
    void previous_test_west(){
        MapDirection test_object = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, test_object.previous());
    }
}
