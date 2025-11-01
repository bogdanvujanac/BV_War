package com.example.project.Start;

import com.example.project.Usernames.UsernamesManager;
import com.example.project.Util.IController;
import com.example.project.Util.IManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartManager implements IManager {

    public StartController controller;

    @Override
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

    private void on_btn_start_click(Stage stage) throws IOException {
        UsernamesManager usernamesManager = new UsernamesManager();
        usernamesManager.Show(stage);
    }

}
