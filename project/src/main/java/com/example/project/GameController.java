package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane grid_pane_game;

    public Button[][] matrix_buttons;

    public void init(int grid_size){
        create_board(grid_size);
    }

    private void create_board(int n){
        GridPane grid =  new GridPane(n, n);
        matrix_buttons =  new Button[n][n];

        for( int i = 0; i < n; i++ ) {
            for(int j=0; j<n; j++ ) {
                matrix_buttons[i][j] = new Button();
                grid.add(matrix_buttons[i][j], i, j);
            }
        }

        grid_pane_game.add(grid,1,1);
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
