package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrassField extends AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private int bound;
    public GrassField(int n){
        this.visualizer = new MapVisualizer(this);
        this.lowerLeftCorner = new Vector2d(0, 0);
        this.upperRightCorner = new Vector2d(0, 0);
        this.bound = (int)Math.sqrt(10*n);
        for(int i = 0; i < n; i++){
            drawNewGrass();
        }
    }

    public void drawNewGrass(){
        Vector2d newPos;
        do{
            int x = (int)(Math.random()*this.bound);
            int y = (int)(Math.random()*this.bound);
            newPos = new Vector2d(x, y);
        }while(isOccupied(newPos));
        Grass newGrass = new Grass(newPos, this);
        newGrass.addObserver(this.sortedObjects);
        this.grass.put(newPos, newGrass);
        this.sortedObjects.addNewElement(newGrass.ElementInTreeSet);
    }

    public void updateCorners(){
        this.lowerLeftCorner = this.sortedObjects.getLowerLeftCorner();
        this.upperRightCorner = this.sortedObjects.getUpperRightCorner();
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        Object object = objectAt(position);
        return !(object instanceof Animal);
    }

    @Override
    public String toString(){
        updateCorners();
        return this.visualizer.draw(this.lowerLeftCorner, this.upperRightCorner);
    }
}
