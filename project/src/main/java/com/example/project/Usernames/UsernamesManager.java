package com.example.project.Usernames;

import com.example.project.Game.GameManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UsernamesManager {

    public UsernamesController controller;

    public void Show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/enter_usernames_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        controller = fxmlLoader.getController();

        controller.get_btn_play().setOnMouseClicked(event -> {
            try {
                on_btn_play_click(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    private void on_btn_play_click(Stage stage) throws IOException {
        GameManager gameManager = new GameManager(controller.size_for_grid());
        gameManager.Show(stage);
    }
}
