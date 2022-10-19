package agh.ics.oop;

public class OptionParser{
    public MoveDirection[] parse(String[] moves){
        int count = 0;
        for(String move : moves){
            switch(move){
                case "f", "forward", "b", "backward", "l",
                        "left", "r", "right" -> count++;
            }
        }
        MoveDirection[] parsed = new MoveDirection[count];
        int i = 0;
        for(String move : moves){
            switch(move){
                case "f", "forward" -> {
                    parsed[i] = MoveDirection.FORWARD;
                    i ++;
                }
                case "b", "backward" -> {
                    parsed[i] = MoveDirection.BACKWARD;
                    i ++;
                }
                case "l", "left" -> {
                    parsed[i] = MoveDirection.LEFT;
                    i ++;
                }
                case "r", "right" -> {
                    parsed[i] = MoveDirection.RIGHT;
                    i ++;
                }
            }
        }
        return parsed;
    }
}
