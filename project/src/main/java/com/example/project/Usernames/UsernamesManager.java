package com.example.project.Usernames;

import com.example.project.Game.GameManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
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

        stage.setMaximized(true);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.show();
        Platform.runLater(() -> stage.setFullScreen(true));
    }

    private void on_btn_play_click(Stage stage) throws IOException {

        if(controller.get_username1().isBlank() || controller.get_username2().isBlank()){
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all the fields");
            alert.showAndWait();*/

            WarningMessage.WarningIsBlank(stage);
        }
        else if(controller.get_username1().equalsIgnoreCase(controller.get_username2())){
            WarningMessage.WarningIsEqual(stage);
        }
        else {
            GameManager gameManager = new GameManager(controller.size_for_grid(), controller.get_username1(), controller.get_username2());
            gameManager.Show(stage);
        }
    }
}
