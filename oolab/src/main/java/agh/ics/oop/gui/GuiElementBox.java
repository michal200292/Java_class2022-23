package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import agh.ics.oop.Vector2d;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    Image photo;
    ImageView newImage;
    Label label;

    VBox vbox;
    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        try{
            photo = new Image(new FileInputStream(element.getImagePath()));
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
            throw new FileNotFoundException("File does not exits");
        }

        newImage = new ImageView(photo);
        newImage.setFitHeight(20);
        newImage.setFitWidth(20);

        element.getPosition();
        if(element instanceof Animal){
            label = new Label("Z" + element.getPosition().toString());
        }
        else{
            label = new Label("Trawa");
        }
        vbox = new VBox();
        vbox.getChildren().addAll(newImage, label);
        vbox.setAlignment(Pos.CENTER);
    }
}
