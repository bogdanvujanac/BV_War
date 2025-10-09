package com.example.project.Map;

import com.example.project.Army.TheArmy;
import com.example.project.Game.GameState;
import com.example.project.Game.Player;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.List;

public class Field {

    private int x;
    private int y;
    private Button button;

    private TheArmy army;

    public Field(int x, int y, Button button) {
        this.x = x;
        this.y = y;
        this.army = null;

        this.button = button;

        button.setOnAction(e -> on_field_button_click());
    }

    void on_field_button_click(){
        if(GameState.first_click){
            if(army == null || army.player != GameState.current_player){
                return;
            }
            if(army.player == GameState.current_player){
                List<Field> attacks = GameState.board.available_attacks(this);
                GameState.possible_move_fields = GameState.board.available_moves(this);
                // gui: show fields
                GameState.first_click = false;
                GameState.selected_field = this;

                for(Field f : attacks){
                    f.button.setStyle("-fx-background-color: red; -fx-padding: 0; -fx-border-color: transparent;");
                    ImageView iv = (ImageView) f.button.getGraphic();
                    applyOverlay(iv, f.button, Color.RED, 0.4);
                }

                for(Field f : GameState.possible_move_fields){
                    f.button.setStyle("-fx-background-color: yellow; -fx-padding: 0; -fx-border-color: transparent;");
                    ImageView iv = (ImageView) f.button.getGraphic();
                    applyOverlay(iv, f.button, Color.YELLOW, 0.4);
                }
            }
        }
        else{
            if(army == null) {
                // move() ili ne
                if(GameState.possible_move_fields.contains(this)) {
                    this.set_army(GameState.selected_field.get_army(), GameState.current_player);
                    GameState.selected_field.set_army(null, null);
                }
            }
            else if(army.player != GameState.current_player) {
                // atack() ili ne
                System.out.println(army.player + " " + GameState.current_player);
            }
            else {
                // nista
                System.out.println("nista");
            }

            GameState.first_click = true;
            GameState.selected_field = null;


            for(Field f : GameState.possible_move_fields){
                f.button.setStyle("-fx-background-color: none; -fx-padding: 0; -fx-border-color: transparent;");

            }

            GameState.possible_move_fields = null;
        }
    }

    public boolean is_occupied(){
        return army != null;
    }

    public void set_army(TheArmy army, Player player) {
        this.army = army;

        if(army != null)
            this.army.set_player(player);

        set_picture();
    }

    public TheArmy get_army(){
        return army;
    }

    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }

    private void set_picture(){
        if(army == null)
            button.setGraphic(null);
        else {
            ImageView image_view = new ImageView(army.get_image());
            image_view.fitWidthProperty().bind(button.widthProperty().multiply(0.8));
            image_view.fitHeightProperty().bind(button.heightProperty());
            image_view.setPreserveRatio(true);

            button.setGraphic(image_view);
        }
    }


    private void applyOverlay(ImageView imageView, Button btn, Color color, double opacity) {
        if (imageView == null) return;

        ColorAdjust colorAdjust = new ColorAdjust();
        Blend blend = new Blend(
                BlendMode.OVERLAY,
                colorAdjust,
                new ColorInput(
                        0, 0,
                        btn.getWidth(), btn.getHeight(),
                        Color.color(color.getRed(), color.getGreen(), color.getBlue(), opacity)
                )
        );
        imageView.setEffect(blend);


    }

}
