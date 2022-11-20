package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class OptionParser{
    public static MoveDirection[] parse(String[] moves) throws IllegalArgumentException{
        MoveDirection[] parsed = new MoveDirection[moves.length];
        int i = 0;
        for(String move : moves){
            switch (move) {
                case "f", "forward" -> parsed[i] = MoveDirection.FORWARD;
                case "b", "backward" -> parsed[i] = MoveDirection.BACKWARD;
                case "l", "left" -> parsed[i] = MoveDirection.LEFT;
                case "r", "right" -> parsed[i] = MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(move + " is not a legal move");
            }
            i++;
        }
        return parsed;
    }
}
