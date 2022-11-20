package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends Application {

    private AbstractWorldMap map;
    @Override
    public void init() throws IllegalArgumentException{
        String[] args = getParameters().getRaw().toArray(new String[0]);
        try{
            MoveDirection[] directions = OptionParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch(IllegalArgumentException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Vector2d lowerLeft = map.lowerLeftCorner;
        Vector2d upperRight = map.upperRightCorner;

        Label label1 = new Label("y/x");
        grid.add(label1, 0, 0, 1, 1);
        GridPane.setHalignment(label1, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));

        for(int i = lowerLeft.x; i <= upperRight.x; ++i){
            Label label2 = new Label(String.valueOf(i));
            grid.add(label2, i - lowerLeft.x + 1, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            GridPane.setHalignment(label2, HPos.CENTER);
        }

        for(int i = upperRight.y; i >= lowerLeft.y; --i){
            Label label2 = new Label(String.valueOf(i));
            grid.add(label2, 0, upperRight.y - i + 1, 1, 1);
            grid.getRowConstraints().add(new RowConstraints(20));
            GridPane.setHalignment(label2, HPos.CENTER);
        }

        for(int i = lowerLeft.x; i <= upperRight.x; ++i){
            for(int j = lowerLeft.y; j <= upperRight.y; ++j){
                Object object = map.objectAt(new Vector2d(i, j));
                if(object != null) {
                    Label label2 = new Label(object.toString());
                    grid.add(label2, i - lowerLeft.x + 1, upperRight.y - j + 1, 1, 1);
                    GridPane.setHalignment(label2, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(grid, 400 , 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
