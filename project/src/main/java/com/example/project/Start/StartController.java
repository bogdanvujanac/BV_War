package com.example.project.Start;

import com.example.project.Util.IController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StartController implements IController {

    @FXML
    private AnchorPane pane_start;

    @FXML
    private Button btn_start;

    @FXML
    private Button btn_exit;

    @Override
    public void initialize(){
        Image img = new Image(getClass().getResource("/com/example/project/images/background1.jpg").toExternalForm());
        BackgroundImage bgimg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,false,true,true));
        pane_start.setBackground(new Background(bgimg));
    }

    public Button get_btn_exit(){
        return btn_exit;
    }

    public Button get_btn_start(){
        return btn_start;
    }
}
