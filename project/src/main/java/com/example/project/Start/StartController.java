package com.example.project.Start;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartController {

    @FXML
    private Button btn_start;

    @FXML
    private Button btn_exit;

    public Button get_btn_exit(){
        return btn_exit;
    }

    public Button get_btn_start(){
        return btn_start;
    }
}
