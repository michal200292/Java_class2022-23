package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrassField extends AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private int bound;
    public GrassField(int n){
        this.animals = new HashMap<>();
        this.grass = new HashMap<>();
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
        updateCorners(newPos);
        this.grass.put(newPos, new Grass(newPos));
    }
    public void updateCorners(Vector2d newItem){
        this.lowerLeftCorner = this.lowerLeftCorner.lowerLeft(newItem);
        this.upperRightCorner = this.upperRightCorner.upperRight(newItem);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        updateCorners(position);
        Object object = objectAt(position);
        if(object instanceof Animal){
            return false;
        } else if (object instanceof Grass) {
            drawNewGrass();
            this.grass.remove(((Grass) object).getPosition());
            return true;
        }
        else{
            return true;
        }
    }

}
