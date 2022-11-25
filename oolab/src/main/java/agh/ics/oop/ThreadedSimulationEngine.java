package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class ThreadedSimulationEngine implements Runnable{
    private IWorldMap map;
    private MoveDirection[] moves;
    private List<Animal> animals;

    private App animation;
    public ThreadedSimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions, App animation){
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();
        this.animation = animation;
        for(Vector2d pos : positions){
            Animal new_animal = new Animal(map, pos);
            this.map.place(new_animal);
            this.animals.add(new_animal);

        }
    }

    @Override
    public void run(){
        System.out.println(this.map);
        int n = this.animals.size();
        int i = 0;
        for(MoveDirection m : moves){
            if(i == n){
                i = 0;
            }
            this.animals.get(i).move(m);
            i++;
            System.out.println(this.map);
        }
    }
}
