package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Vector2d lowerLeftCorner;
    protected Vector2d upperRightCorner;
    protected Map<Vector2d, Animal> animals;
    protected Map<Vector2d, Grass> grass;
    protected MapVisualizer visualizer;

    abstract void updateCorners(Vector2d newItem);
    abstract public boolean canMoveTo(Vector2d position);
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition())){
            return false;
        }
        this.updateCorners(animal.getPosition());
        this.animals.put(animal.getPosition(), animal);
        return true;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal object = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, object);
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

    @Override
    public String toString(){
        return this.visualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }
}
