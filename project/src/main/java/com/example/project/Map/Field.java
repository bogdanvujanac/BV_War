package com.example.project.Map;

import com.example.project.Army.TheArmy;
import com.example.project.Game.Player;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Field {

    private int x;
    private int y;

    private TheArmy army;

    private Button button;

    public Field(int x, int y, Button button) {
        this.x = x;
        this.y = y;
        this.army = null;

        this.button = button;
    }

    public boolean is_occupied(){
        return army != null;
    }

    public void set_army(TheArmy army, Player player) {
        this.army = army;
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

        ImageView image_view = new ImageView(army.get_image());
        image_view.fitWidthProperty().bind(button.widthProperty());
        image_view.fitHeightProperty().bind(button.heightProperty());
        image_view.setPreserveRatio(true);

        button.setGraphic(image_view);
    }
}
