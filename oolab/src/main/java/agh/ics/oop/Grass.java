package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{
    public Grass(Vector2d position, IPositionChangeObserver observer){

        this.position = position;
        this.observers.add(observer);
        this.ElementInTreeSet = new TreeSetObject(this.position, false);
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getImagePath() {
        return "src/main/resources/grass.png";
    }
}
