package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    public boolean preceds(Vector2d other){
        return (this.x <= other.x) && (this.y <= other.y);
    }
    public boolean follows(Vector2d other){
        return (this.x >= other.x) && (this.y >= other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }
    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }
    public boolean equals(Vector2d other){
        return ((this.x == other.x) && (this.y == other.y));
    }
    public Vector2d opposite(Vector2d other){
        return new Vector2d(-this.x, -this.y);
    }
}
