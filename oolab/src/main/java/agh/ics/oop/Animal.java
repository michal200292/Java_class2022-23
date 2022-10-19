package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;
    public String toString(){
        return "Zwierzę znajduje się na pozycji: " + position.toString() + " i patrzy na: " + orientation.toString();
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public boolean isOriented(MapDirection orientation){ // Funckja do sprawdzania orientacji w testach
        return this.orientation.equals(orientation);
    }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD ->{
                Vector2d new_pos = this.position.add(this.orientation.toUnitVector());
                if(new_pos.precedes(new Vector2d(4, 4)) && new_pos.follows(new Vector2d(0, 0))){
                    this.position = new_pos;
                }
            }
            case BACKWARD -> {
                Vector2d new_pos = this.position.add(this.orientation.toUnitVector().opposite());
                if(new_pos.precedes(new Vector2d(4, 4)) && new_pos.follows(new Vector2d(0, 0))) {
                    this.position = new_pos;
                }
            }
        }
    }

}
