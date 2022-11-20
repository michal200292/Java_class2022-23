package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    SortedSet<TreeSetObject> XObjects = new TreeSet<>((o1, o2) -> {
        if(o1.equals(o2)){
            return 0;
        }
        if(o1.position.x != o2.position.x){
            return o1.position.x - o2.position.x;
        }
        if(o1.position.y != o2.position.y){
            return o1.position.y - o2.position.y;
        }
        if(o1.IsAnimal){
            return 1;
        }
        return -1;
    });
    SortedSet<TreeSetObject> YObjects = new TreeSet<>((o1, o2) -> {
        if(o1.equals(o2)){
            return 0;
        }
        if(o1.position.y != o2.position.y){
            return o1.position.y - o2.position.y;
        }
        if(o1.position.x != o2.position.x){
            return o1.position.x - o2.position.x;
        }
        if(o1.IsAnimal){
            return 1;
        }
        return -1;
    });
    public void positionChanged(Object object, Vector2d oldPosition, Vector2d newPosition){
        AbstractWorldMapElement MapObject = (AbstractWorldMapElement)object;
        TreeSetObject sortedObject = MapObject.ElementInTreeSet;
        XObjects.remove(sortedObject);
        YObjects.remove(sortedObject);
        sortedObject.position = newPosition;
        XObjects.add(sortedObject);
        YObjects.add(sortedObject);
    }
    public void addNewElement(TreeSetObject newElement){
        XObjects.add(newElement);
        YObjects.add(newElement);
    }

    public Vector2d getUpperRightCorner(){
        Vector2d lastX = XObjects.last().position;
        Vector2d lastY = YObjects.last().position;
        return lastX.upperRight(lastY);
    }
    public Vector2d getLowerLeftCorner(){
        Vector2d lastX = XObjects.first().position;
        Vector2d lastY = YObjects.first().position;
        return lastX.lowerLeft(lastY);
    }
}