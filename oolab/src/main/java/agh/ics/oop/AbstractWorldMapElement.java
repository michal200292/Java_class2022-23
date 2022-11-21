package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;
    protected IWorldMap map;
    protected List<IPositionChangeObserver> observers = new ArrayList<>();

    @Override
    abstract public String getImagePath();

    public Vector2d getPosition() {
        return position;
    }
    public TreeSetObject ElementInTreeSet;
    protected void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    protected void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
}
