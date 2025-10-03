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
                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                matrix_buttons[i][j] = btn;
                grid.add(btn, i, j);
            }
        }

        grid.prefWidthProperty().bind(board_pane.widthProperty());
        grid.prefHeightProperty().bind(board_pane.heightProperty());

        board_pane.getChildren().clear();
        board_pane.getChildren().add(grid);
    }

    private void create_button_actions(){
        for( int i = 0; i < 8; i++ ) {
            for(int j=0; j<8; j++ ) {
                Button btn = matrix_buttons[i][j];
                btn.setOnMouseClicked(e -> on_matrix_button_click());
            }
        }
    }

    private void on_matrix_button_click() {
        // TODO
    }


}
