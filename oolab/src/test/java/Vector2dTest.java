import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void test_equals(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(-2, 1);
        Vector2d vector4 = new Vector2d(2, -1);
        Vector2d vector5 = new Vector2d(15, 16);
        assertTrue(vector1.equals(vector2));
        assertFalse(vector1.equals(vector3));
        assertFalse(vector1.equals(vector4));
        assertFalse(vector1.equals(vector5));
    }

    @Test
    void test_toString(){
        Vector2d vector = new Vector2d(12, 13);
        assertEquals("(12,13)", vector.toString());
    }

    @Test
    void test_precedes(){
        Vector2d vector1 = new Vector2d(12, 13);
        Vector2d vector2 = new Vector2d(15, 15);
        Vector2d vector3 = new Vector2d(15, 10);
        Vector2d vector4 = new Vector2d(10, 10);
        assertTrue(vector1.precedes(vector2));
        assertFalse(vector1.precedes(vector3));
        assertFalse(vector1.precedes(vector4));
    }

    @Test
    void test_follows(){
        Vector2d vector1 = new Vector2d(12, 13);
        Vector2d vector2 = new Vector2d(10, 12);
        Vector2d vector3 = new Vector2d(15, 14);
        Vector2d vector4 = new Vector2d(20, 20);
        assertTrue(vector1.follows(vector2));
        assertFalse(vector1.follows(vector3));
        assertFalse(vector1.follows(vector4));
    }

    @Test
    void test_upperRight(){
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 0);
        Vector2d vector3 = new Vector2d(2, 1);

        assertEquals(vector1.upperRight(vector2), vector3);
        assertEquals(vector2.upperRight(vector1), vector3);
        assertNotEquals(vector2.upperRight(vector1), new Vector2d(5, 6));
    }

    @Test
    void test_lowerLeft(){
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 0);
        Vector2d vector3 = new Vector2d(1, 0);

        assertEquals(vector1.lowerLeft(vector2), vector3);
        assertEquals(vector2.lowerLeft(vector1), vector3);
        assertNotEquals(vector2.lowerLeft(vector1), new Vector2d(5, 6));
    }

    @Test
    void test_add(){
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 0);
        Vector2d vector3 = new Vector2d(1, 0);
        assertEquals(vector1.add(vector2), new Vector2d(3, 1));
        assertEquals(vector2.add(vector1), new Vector2d(3, 1));
        assertEquals(vector1.add(vector3), new Vector2d(2, 1));
        assertEquals(vector3.add(vector1), new Vector2d(2, 1));
        assertNotEquals(vector1.add(vector2), new Vector2d(2, 1));
    }

    @Test
    void test_subtract(){
        Vector2d vector1 = new Vector2d(1, 1);
        Vector2d vector2 = new Vector2d(2, 0);
        assertEquals(vector1.substract(vector2), new Vector2d(-1, 1));
        assertEquals(vector2.substract(vector1), new Vector2d(1, -1));
        assertNotEquals(vector1.substract(vector2), new Vector2d(2, 1));
    }

    @Test
    void test_opposite(){
        Vector2d vector = new Vector2d(1, 2);
        assertEquals(vector.opposite(), new Vector2d(-1, -2));
        assertNotEquals(vector.opposite(), new Vector2d(1, -2));

    }
}
