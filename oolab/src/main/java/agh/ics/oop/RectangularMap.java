package agh.ics.oop;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RectangularMap extends AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    public RectangularMap(int width, int height){
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(width, height);
        this.visualizer = new MapVisualizer(this);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return (position.follows(this.lowerLeftCorner) && position.precedes(this.upperRightCorner) && !isOccupied(position));
    }
    @Override
    public String toString(){
        return this.visualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }
}
