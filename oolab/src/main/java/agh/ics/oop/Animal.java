package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class Animal{
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers;
    public Animal(){
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal(IWorldMap map){
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
        this.map = map;
        this.observers = new ArrayList<>();
        addObserver((IPositionChangeObserver)map);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.observers = new ArrayList<>();
        addObserver((IPositionChangeObserver)map);
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

    private void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if(this.map.canMoveTo(newPosition)){
            for(IPositionChangeObserver x : this.observers){
                x.positionChanged(oldPosition, newPosition);
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
