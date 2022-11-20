package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    public Vector2d lowerLeftCorner;
    public Vector2d upperRightCorner;
    public Map<Vector2d, Animal> animals = new HashMap<>();
    public Map<Vector2d, Grass> grass = new HashMap<>();
    public MapVisualizer visualizer;

    public MapBoundary sortedObjects = new MapBoundary();

    abstract public boolean canMoveTo(Vector2d position);
    public boolean place(Animal animal) throws IllegalArgumentException{
        if(!canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("Position " + animal.getPosition() + " is already occupied");
        }
        this.animals.put(animal.getPosition(), animal);
        animal.addObserver(this.sortedObjects);
        this.sortedObjects.addNewElement(animal.ElementInTreeSet);
        return true;
    }
    @Override
    public void positionChanged(Object object, Vector2d oldPosition, Vector2d newPosition){
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, (Animal) object);
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return (objectAt(position) != null);
    }
    @Override
    public Object objectAt(Vector2d position){
        if(this.animals.get(position) != null){
            return this.animals.get(position);
        }
        if(this instanceof GrassField) {
            if(this.grass.get(position) != null){
                return this.grass.get(position);
            }
        }
        return null;
    }

}