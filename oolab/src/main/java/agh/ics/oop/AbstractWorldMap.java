package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected Vector2d lowerLeftCorner;
    protected Vector2d upperRightCorner;
    protected List<Animal> animals;
    protected List<Grass> grass;
    protected MapVisualizer visualizer;

    abstract void updateCorners(Vector2d newItem);
    abstract public boolean canMoveTo(Vector2d position);
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition())){
            return false;
        }
        this.updateCorners(animal.getPosition());
        this.animals.add(animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position){
            return (objectAt(position) != null);
    }
    @Override
    public Object objectAt(Vector2d position){
        for(Animal x: this.animals){
            if(x.isAt(position)){
                return x;
            }
        }
        if(this instanceof GrassField) {
            for (Grass x : this.grass) {
                if (x.getPosition().equals(position)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.visualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }
}
