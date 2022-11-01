package agh.ics.oop;


public class Animal{
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;
    public Animal(){
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal(IWorldMap map){
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }
    @Override
    public String toString(){
        return this.orientation.toString();
    }

    protected Vector2d getPosition() {
        return this.position;
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
                if(this.map.canMoveTo(new_pos)){
                    this.position = new_pos;
                }
            }
            case BACKWARD -> {
                Vector2d new_pos = this.position.add(this.orientation.toUnitVector().opposite());
                if(this.map.canMoveTo(new_pos)) {
                    this.position = new_pos;
                }
            }
        }
    }
}
