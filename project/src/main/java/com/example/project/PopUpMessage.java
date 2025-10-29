package com.example.project;


import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PopUpMessage {

    public static void pop_up(Stage stage, String message){
        Stage child = new Stage();
        child.initOwner(stage);
        child.initModality(Modality.WINDOW_MODAL);
        child.setTitle("Warning");

        Label label = new Label(message);

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

    public static void pop_up_end_game(Stage stage, String message, String username){
        Stage child = new Stage();
        child.initOwner(stage);
        child.initModality(Modality.WINDOW_MODAL);
        child.setTitle("WINNER");

        child.initStyle(StageStyle.UNDECORATED);

        Label label = new Label(message + username);

        Button button1 = new Button("PLAY AGAIN");
        button1.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(PopUpMessage.class.getResource("/com/example/project/enter_usernames_scene.fxml"));
                Parent root = loader.load();

                stage.setScene(new Scene(root));
                stage.show();

                child.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button button2 = new Button("EXIT");
        button2.setOnAction(e -> {
            child.close();
            //stage.close();
            Platform.exit();
        });

        HBox buttons = new HBox(15, button1,button2);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(15, label,buttons);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #f0f0f0; -fx-border-radius: 10; -fx-background-radius: 10;");

        Scene scene = new Scene(layout, 300, 150);
        child.setScene(scene);

        child.setX(stage.getX()+stage.getWidth()/2-layout.getWidth()/2);
        child.setY(stage.getY()+stage.getHeight()/2-layout.getHeight()/2);

        //child.initStyle(StageStyle.UNIFIED);
        child.setResizable(false);

        child.showAndWait();
    }

    public static void pop_up_current_player(Stage stage, String username, String color){
        Stage child = new Stage();
        child.initOwner(stage);
        child.initModality(Modality.WINDOW_MODAL);
        child.initStyle(StageStyle.UNDECORATED);

        Label label = new Label(username + " " + "is on turn.");
        label.setStyle("-fx-font-size: 20; -fx-text-fill: black; -fx-font-weight: bold;");

        VBox layout = new VBox(label);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: " + color +"; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 15, 0.2, 0, 0)");

        Scene scene = new Scene(layout, 300, 150);
        child.setScene(scene);

        child.setX(stage.getX()+stage.getWidth()/2-layout.getWidth()/2);
        child.setY(stage.getY()+stage.getHeight()/2-layout.getHeight()/2);

        child.show();

        javafx.animation.PauseTransition delay = new javafx.animation.PauseTransition(javafx.util.Duration.seconds(2));
        delay.setOnFinished(e -> {
            javafx.animation.FadeTransition fade = new javafx.animation.FadeTransition(javafx.util.Duration.seconds(0.5), layout);
            fade.setFromValue(1);
            fade.setToValue(0);
            fade.setOnFinished(e1 -> {child.close();});
            fade.play();
        });
        delay.play();
    }


}
