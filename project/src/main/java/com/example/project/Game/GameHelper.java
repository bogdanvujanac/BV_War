package com.example.project.Game;

import com.example.project.Constants;
import com.example.project.Map.Field;

public class GameHelper {

    public static void save_first_click(Field field){
        if(field.get_army() == null || field.get_army().player != GameState.current_player){
            return;
        }

        // selected field belongs to current player
        // if(field.get_army().player == GameState.current_player)

        GameState.possible_attack_fields = GameState.board.available_attacks(field);
        GameState.possible_move_fields = GameState.board.available_moves(field);

        GameState.first_click = false;
        GameState.selected_field = field;

    }
}
