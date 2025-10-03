package com.example.project.Usernames;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WarningMessage {

    public static void WarningIsBlank(Stage stage){
        Stage child = new Stage();
        child.initOwner(stage);
        child.initModality(Modality.WINDOW_MODAL);
        child.setTitle("Warning");

        Label label = new Label("Please fill out all the fields");

        Button button = new Button("OK");
        button.setOnAction(e -> {child.close();});


        VBox layout = new VBox(15, label,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 150);
        child.setScene(scene);


        child.setX(stage.getX()+stage.getWidth()/2-layout.getWidth()/2);
        child.setY(stage.getY()+stage.getHeight()/2-layout.getHeight()/2);

        child.initStyle(StageStyle.UNIFIED);
        child.setResizable(false);

        child.showAndWait();
    }


    public static void WarningIsEqual(Stage stage){
        Stage child = new Stage();
        child.initOwner(stage);
        child.initModality(Modality.WINDOW_MODAL);
        child.setTitle("Warning");

        Label label = new Label("Usernames can't be the same");

        Button button = new Button("OK");
        button.setOnAction(e -> {child.close();});


        VBox layout = new VBox(15, label,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 150);
        child.setScene(scene);


        child.setX(stage.getX()+stage.getWidth()/2-layout.getWidth()/2);
        child.setY(stage.getY()+stage.getHeight()/2-layout.getHeight()/2);

        child.initStyle(StageStyle.UNIFIED);
        child.setResizable(false);

        child.showAndWait();
    }
}
