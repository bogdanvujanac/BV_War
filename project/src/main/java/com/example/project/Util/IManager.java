package com.example.project.Util;

import javafx.stage.Stage;

import java.io.IOException;

public interface IManager {
    void Show(Stage stage) throws IOException;
    IController get_controller();
}
