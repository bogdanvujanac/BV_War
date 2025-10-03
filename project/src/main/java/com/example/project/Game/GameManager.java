package com.example.project.Game;

import com.example.project.Army.Cannon;
import com.example.project.Army.Cavalry;
import com.example.project.Army.Infantry;
import com.example.project.Army.Tank;
import com.example.project.Map.Board;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class GameManager {
    private final int grid_size;
    public GameController controller;

    private Player player1;
    private Player player2;

    private int on_turn; // 1, 2

    private Board board;

    public GameManager(int grid_size, String username1, String username2){
        this.grid_size = grid_size;

        player1 = new Player(username1);
        player2 = new Player(username2);

        on_turn = new Random().nextInt(2) + 1;

    }

    public void Show(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/game_scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // controller initialization
        controller = fxmlLoader.getController();
        controller.init(grid_size);

        stage.setMaximized(true);
        stage.setResizable(false);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.show();
        Platform.runLater(() -> stage.setFullScreen(true));

        //
        start_game();
    }

    private void start_game(){
        board = new Board(grid_size, controller.matrix_buttons);
        // 1.
        put_army_on_map();
    }

    private void put_army_on_map(){

        //TODO
        board.get_field(0, 1).set_army(new Cannon(), player1);
        board.get_field(1, 1).set_army(new Cavalry(), player1);
        board.get_field(5, 1).set_army(new Cavalry(), player1);
        board.get_field(3, 0).set_army(new Tank(), player1);
        board.get_field(2, 1).set_army(new Infantry(), player1);
        board.get_field(4, 0).set_army(new Infantry(), player1);
        board.get_field(4, 1).set_army(new Infantry(), player1);

        board.get_field(grid_size-1, grid_size-1-1).set_army(new Cannon(), player2);
        board.get_field(grid_size-1-1, grid_size-1-1).set_army(new Cavalry(), player2);
        board.get_field(grid_size-1-5, grid_size-1-1).set_army(new Cavalry(), player2);
        board.get_field(grid_size-1-3, grid_size-1).set_army(new Tank(), player2);
        board.get_field(grid_size-1-2, grid_size-1-1).set_army(new Infantry(), player2);
        board.get_field(grid_size-1-4, grid_size-1).set_army(new Infantry(), player2);
        board.get_field(grid_size-1-4, grid_size-1-1).set_army(new Infantry(), player2);
    }
}
