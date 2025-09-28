package com.example.project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameManager {
    private final int grid_size;
    public GameController controller;

    GameManager(int grid_size){
        this.grid_size = grid_size;
    }

    public void Show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // controller initialization
        controller = fxmlLoader.getController();
        controller.init(grid_size);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
