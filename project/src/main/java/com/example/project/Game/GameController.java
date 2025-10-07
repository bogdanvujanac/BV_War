package com.example.project.Game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class GameController {

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private Pane board_pane;

    public Button[][] matrix_buttons;

    public void init(int grid_size){
        create_board(grid_size);
    }

    private void create_board(int n) {
        GridPane grid = new GridPane();
        matrix_buttons = new Button[n][n];

        for (int i = 0; i < n; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / n);
            grid.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / n);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Button btn = new Button();
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

        //board_pane.getChildren().clear();
        //board_pane.getChildren().add(grid);
    }

    private void create_button_actions(){
        for( int i = 0; i < 8; i++ ) {
            for(int j=0; j<8; j++ ) {
                Button btn = matrix_buttons[i][j]; // TODO: think about where to initialize buttons
            }
        }
    }




}
