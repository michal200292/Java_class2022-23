package agh.ics.oop;


public class World {
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(position1.equals(position2));
    }
    public static void run(Direction[] moves){
        int i = 0;
        while (i < moves.length && !(moves[i] == null)){
            String message = switch (moves[i]) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
            i += 1;
        }
    }
    public static Direction[] string_to_enum(String[] args){
        Direction[] converted = new Direction[args.length];
        int i = 0;
        for(String x : args){
            Direction move = switch(x){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> null;
            };
            if(!(move == null)) {
                converted[i] = move;
                i += 1;
            }
        }
        return converted;
    }
}