package agh.ics.oop;


public class Animal extends AbstractWorldMapElement{
    private MapDirection orientation;

    public Animal(){
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal(IWorldMap map){
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
        this.map = map;
        this.ElementInTreeSet = new TreeSetObject(this.position, true);
        addObserver((IPositionChangeObserver)map);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.ElementInTreeSet = new TreeSetObject(this.position, true);
        addObserver((IPositionChangeObserver)map);
    }
    @Override
    public String toString(){
        return this.orientation.toString();
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/animal"+ orientation.toString() + ".png";
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public boolean isOriented(MapDirection orientation){ // Funckja do sprawdzania orientacji w testach
        return this.orientation.equals(orientation);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if(this.map.canMoveTo(newPosition)){
            for(IPositionChangeObserver x : this.observers) {
                x.positionChanged(this, oldPosition, newPosition);
            }
            this.position = newPosition;
        }
    }
    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD ->{
                Vector2d new_pos = this.position.add(this.orientation.toUnitVector());
                positionChanged(this.position, new_pos);
            }
            case BACKWARD -> {
                Vector2d new_pos = this.position.add(this.orientation.toUnitVector().opposite());
                positionChanged(this.position, new_pos);
            }
        }
    }
}
