package com.example.project.Usernames;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class UsernamesController {

    @FXML
    private Button btn_play;

    @FXML
    private TextField tf_username1;

    @FXML
    private TextField tf_username2;

    @FXML
    ChoiceBox<String> cb_field;

    @FXML
    public void initialize(){
        cb_field.getItems().addAll("6x6","7x7","8x8", "9x9","10x10");
        cb_field.setValue("6x6");
    }

    public int size_for_grid(){
        String value = cb_field.getValue();
        String i =  value.split("x")[0];
        return Integer.parseInt(i);
    }

    public String get_username1(){
        return tf_username1.getText();
    }

    public String get_username2(){
        return tf_username2.getText();
    }

    public Button get_btn_play(){
        return btn_play;
    }
}
