package com.example.project.Usernames;

import com.example.project.Constants;
import com.example.project.Game.GameManager;
import com.example.project.PopUpMessage;
import com.example.project.Util.IController;
import com.example.project.Util.IManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UsernamesManager implements IManager {

    public UsernamesController controller;

    @Override
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

    @Override
    public IController get_controller(){
        return controller;
    }

    private void on_btn_play_click(Stage stage) throws IOException {

        if(controller.get_username1().isBlank() || controller.get_username2().isBlank()){
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all the fields");
            alert.showAndWait();*/

            PopUpMessage.pop_up(stage, Constants.error_blank_usernames);
        }
        else if(controller.get_username1().equalsIgnoreCase(controller.get_username2())){
            PopUpMessage.pop_up(stage, Constants.error_equal_usernames);
        }
        else {
            GameManager gameManager = new GameManager(controller.size_for_grid(), controller.get_username1(), controller.get_username2());
            gameManager.Show(stage);
        }
    }

}
