package com.example.project.Start;

import com.example.project.Usernames.UsernamesManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartManager {

    public StartController controller;

    public void Show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/start_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        controller = fxmlLoader.getController();

        controller.get_btn_exit().addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            Platform.exit();
        });

        controller.get_btn_start().addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            try {
                on_btn_start_click(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    private void on_btn_start_click(Stage stage) throws IOException {
        UsernamesManager usernamesManager = new UsernamesManager();
        usernamesManager.Show(stage);
    }

}
