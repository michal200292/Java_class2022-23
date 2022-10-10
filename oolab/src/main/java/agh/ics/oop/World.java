package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("Start");
        run(string_to_enum(args));
        System.out.println("Stop");
    }
    public static void run(Direction[] moves){

        for(Direction move:moves) {
            String message = switch (move) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                case UNKNOWN -> "Niewiadomo co robi zwierzak";
            };
            System.out.println(message);
        }
    }
    public static Direction[] string_to_enum(String[] args){
        Direction[] converted = new Direction[args.length];
        int i = 0;
        for(String x : args){
            Direction move = switch(x){
                case "f" -> Direction.FORWARD;
                case "d" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.UNKNOWN;
            };
            converted[i] = move;
            i += 1;
        }
        return converted;
    }
}
