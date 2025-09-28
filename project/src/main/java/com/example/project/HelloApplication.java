package com.example.project;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameManager gameMgr = new GameManager(5);
        gameMgr.Show(stage);
    }
}
