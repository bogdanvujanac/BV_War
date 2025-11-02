package com.example.project.Map;

import com.example.project.Army.TheArmy;
import com.example.project.Util.Constants;
import com.example.project.Game.GameHelper;
import com.example.project.Game.GameState;
import com.example.project.Game.Player;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;

import java.util.HashSet;
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
            GameHelper.save_first_click(this);

            Field.paint_fields(GameState.possible_attack_fields, Constants.attack_color);
            Field.paint_fields(GameState.possible_move_fields, Constants.move_color);
        }
        else{
            if(army == null) {
                GameHelper.move(GameState.selected_field, this, GameState.possible_move_fields);
            }
            else if(army.player != GameState.current_player) {
                // ATTACK
                GameHelper.attack(GameState.selected_field, this, GameState.possible_attack_fields);
            }
            else {
                // nista
            }

            this.set_health_text();
            GameState.selected_field.set_health_text();

            GameState.first_click = true;
            GameState.selected_field = null;


            Field.set_fields_style(GameState.possible_move_fields.stream().filter(f -> f != this).toList(), "");

            for(Field f : GameState.possible_attack_fields){
                if(f.army != null){
                    f.set_color(f.army.player.color);
                }
                else
                    f.button.setStyle("");
            }

            GameState.possible_move_fields.clear();
            GameState.possible_attack_fields.clear();
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

        if(army != null)
            set_color(player.color);
        else
            set_color("");
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
            image_view.fitWidthProperty().bind(button.widthProperty().multiply(0.7));
            image_view.fitHeightProperty().bind(button.heightProperty());
            image_view.setPreserveRatio(true);

            button.setGraphic(image_view);

            button.setContentDisplay(ContentDisplay.TOP);
            set_health_text();
        }
    }

    public void set_health_text(){
        if(army != null){
            button.setText(army.get_health() + "/" + army.get_max_health());
        }
        else
            button.setText("");
    }


   /* private void applyOverlay(ImageView imageView, Button btn, Color color, double opacity) {
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
*/
    public void set_color(String color){
        button.setStyle("-fx-background-color: " + color + "; -fx-padding: 0; -fx-border-color: transparent;");
    }

    public static void paint_fields(HashSet<Field> fields, String color){
        for(Field f : fields){
            f.set_color(color);
        }
    }

    public static void set_fields_style(List<Field> fields, String style){
        for(Field f : fields){
            f.button.setStyle(style);
        }
    }

}
