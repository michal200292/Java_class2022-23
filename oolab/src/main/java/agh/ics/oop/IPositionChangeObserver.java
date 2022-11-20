package agh.ics.oop;

public interface IPositionChangeObserver {
    void positionChanged(Object object, Vector2d oldPosition, Vector2d newPosition);
}
