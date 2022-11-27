package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application{

    private AbstractWorldMap map;
    private GridPane grid;

    private Stage primaryStage;

    int moveDelay = 300;

    ThreadedSimulationEngine engine;

    @Override
    public void init() throws IllegalArgumentException{
        String[] args = getParameters().getRaw().toArray(new String[0]);
        try{
            MoveDirection[] directions = OptionParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 4)};
            engine = new ThreadedSimulationEngine(map, positions, this, 300);
//            Thread engineThread = new Thread(engine);
//            engineThread.start();
        }
        catch(IllegalArgumentException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void start(Stage pStage) throws FileNotFoundException {
        primaryStage = pStage;
        grid = new GridPane();
        updateGrid();
        Scene scene = new Scene(grid, 800 , 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    void addElement(IMapElement element, int x, int y) throws FileNotFoundException {
        GuiElementBox elementBox = new GuiElementBox(element);
        grid.add(elementBox.vbox, x, y, 1, 1);
        GridPane.setHalignment(elementBox.vbox, HPos.RIGHT);
    }
    public void updateGrid() throws FileNotFoundException {
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        this.map.updateCorners();
        Vector2d lowerLeft = map.lowerLeftCorner;
        Vector2d upperRight = map.upperRightCorner;
        Label label1 = new Label("y/x");
        label1.setAlignment(Pos.CENTER);
        label1.setMinWidth(40);
        label1.setMinHeight(40);
        grid.add(label1, 0, 0, 1, 1);
        GridPane.setHalignment(label1, HPos.CENTER);
        for(int i = lowerLeft.x; i <= upperRight.x; ++i){
            Label label2 = new Label(String.valueOf(i));
            label2.setAlignment(Pos.CENTER);
            label2.setMinWidth(40);
            grid.add(label2, i - lowerLeft.x + 1, 0, 1, 1);
            GridPane.setHalignment(label2, HPos.CENTER);
        }

        for(int i = upperRight.y; i >= lowerLeft.y; --i){
            Label label2 = new Label(String.valueOf(i));
            label2.setAlignment(Pos.CENTER);
            label2.setMinHeight(40);
            grid.add(label2, 0, upperRight.y - i + 1, 1, 1);
            GridPane.setHalignment(label2, HPos.CENTER);
        }

        for(var entry: map.animals.entrySet()){
            addElement(entry.getValue(), entry.getKey().x - lowerLeft.x + 1, upperRight.y - entry.getKey().y + 1);
        }

        for(var entry: map.grass.entrySet()){
            if(!map.animals.containsKey(entry.getKey())) {
                addElement(entry.getValue(), entry.getKey().x - lowerLeft.x + 1, upperRight.y - entry.getKey().y + 1);
            }
        }
        grid.setGridLinesVisible(true);
        TextField text = new TextField();
        Button start = new Button("Start");
        start.minWidth(40);
        start.minHeight(40);
        grid.add(text, 1, upperRight.y - lowerLeft.y + 2, upperRight.x - lowerLeft.x, 1);
        grid.add(start, upperRight.x - lowerLeft.x + 1, upperRight.y - lowerLeft.y + 2, 1, 1);

        start.setOnAction(x -> {
            String[] args = text.getText().split(" ");
            engine.setMoves(OptionParser.parse(args));
            Thread engineThread = new Thread(engine);
            engineThread.start();
            text.clear();
        });


    }
}