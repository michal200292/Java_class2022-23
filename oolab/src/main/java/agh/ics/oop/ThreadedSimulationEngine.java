package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ThreadedSimulationEngine implements Runnable{
    private IWorldMap map;
    private MoveDirection[] moves;
    private List<Animal> animals;

    private int moveDelay;
    private App animation;
    public ThreadedSimulationEngine(IWorldMap map, Vector2d[] positions, App animation, int delay){
        this.map = map;
        this.animals = new ArrayList<>();
        this.animation = animation;
        moveDelay = delay;
        for(Vector2d pos : positions){
            Animal new_animal = new Animal(map, pos);
            this.map.place(new_animal);
            this.animals.add(new_animal);
        }
    }
    public ThreadedSimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions, App animation, int delay){
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();
        this.animation = animation;
        moveDelay = delay;
        for(Vector2d pos : positions){
            Animal new_animal = new Animal(map, pos);
            this.map.place(new_animal);
            this.animals.add(new_animal);

        }
    }

    @Override
    public void run() throws RuntimeException{
        System.out.println(this.map);
        int n = this.animals.size();
        int i = 0;
        for(MoveDirection m : moves){
            if(i == n) i = 0;
            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.animals.get(i).move(m);
            Platform.runLater(() ->{
                try {
                    animation.updateGrid();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
            i++;
            System.out.println(this.map);
        }
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }
}
