package agh.ics.oop;


public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

//        MoveDirection[] directions = new OptionParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
    }
    /*public static void run(Direction[] moves){
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
    }*/
    /*public static Direction[] string_to_enum(String[] args){
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
    }*/
}