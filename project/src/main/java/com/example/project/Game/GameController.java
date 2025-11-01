package com.example.project.Game;

import com.example.project.Constants;
import com.example.project.Util.IController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GameController implements IController {

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Pane board_pane;

    @FXML
    private Label lblUsername1;
    @FXML
    private Label lblUsername2;

    @FXML
    private Button btn_end;

    @Override
    public void initialize(){
        Image img = new Image(getClass().getResource("/com/example/project/images/military1.jpg").toExternalForm());
        BackgroundImage bgimg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,false,true,true));
        anchor_pane.setBackground(new Background(bgimg));
    }


    public Button[][] matrix_buttons;

    public void init(int grid_size){
        create_board(grid_size);
    }

    private void create_board(int n) {
        GridPane grid = new GridPane();
        matrix_buttons = new Button[n][n];

        for (int i = 0; i < n; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(80.0 / n);
            grid.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(80.0 / n);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Button btn = new Button(); // TODO: think about where to initialize buttons
               // btn.setMaxSize(board_pane.getWidth() / n, board_pane.getHeight() / n);
                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                //btn.setMinSize(board_pane.getWidth() / n, board_pane.getHeight() / n);
                // //btn.setMaxSize(board_pane.getWidth() / n, board_pane.getHeight() / n);

                btn.setFocusTraversable(false);

                //Image img = new Image(getClass().getResourceAsStream("/com/example/project/images/field.jpg"));
                //ImageView image_view = new ImageView(img);
                //image_view.setFitWidth(64);
                //image_view.setFitHeight(64);
                //image_view.setPreserveRatio(false);
                //btn.setGraphic(image_view);

                //btn.setStyle("-fx-background-color: transparent; -fx-padding: 0; -fx-border-color: transparent;");

                matrix_buttons[i][j] = btn;
                grid.add(btn, j, i);
            }
        }

        grid.prefWidthProperty().bind(board_pane.widthProperty());
        grid.prefHeightProperty().bind(board_pane.heightProperty());

        board_pane.getChildren().setAll(grid);
        grid.setAlignment(Pos.TOP_CENTER);
    }

    public void write_usernames(String username1, String username2){
        lblUsername1.setText(username1);
        lblUsername1.setStyle("-fx-font-weight: bold;" + "-fx-text-fill: white;" + "-fx-font-size: 20;" + "-fx-background-color:" + Constants.player1_color +";" + "-fx-border-color: black;" + "-fx-border-width: 2px;" + "-fx-background-radius: 8;" + "-fx-border-radius: 8;" + "-fx-padding: 5 10 5 10;");
        lblUsername2.setText(username2);
        lblUsername2.setStyle("-fx-font-weight: bold;" + "-fx-text-fill: white;" + "-fx-font-size: 20;" + "-fx-background-color:" + Constants.player2_color +";" + "-fx-border-color: black;" + "-fx-border-width: 2px;" + "-fx-background-radius: 8;" + "-fx-border-radius: 8;" + "-fx-padding: 5 10 5 10;");

    }

    public Button get_btn_end() {
        return btn_end;
    }

}
