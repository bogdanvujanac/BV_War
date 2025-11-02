package com.example.project;

import com.example.project.Start.StartManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StartManager startMgr = new StartManager();
        startMgr.Show(stage);
    }
}
