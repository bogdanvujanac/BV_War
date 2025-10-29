package com.example.project.Game;

import com.example.project.Army.TheArmy;
import com.example.project.Map.Field;

import java.util.List;

public class GameHelper {

    public static void save_first_click(Field field){
        if(field.get_army() == null || field.get_army().player != GameState.current_player){
            return;
        }

        // selected field belongs to current player
        // if(field.get_army().player == GameState.current_player)

        GameState.possible_attack_fields.addAll(GameState.board.available_attacks(field));
        GameState.possible_move_fields.addAll(GameState.board.available_moves(field));

        GameState.first_click = false;
        GameState.selected_field = field;

    }

    public static void move(Field from_field, Field to_field, List<Field> possible_move_fields){
        if(possible_move_fields.contains(to_field)) {
            to_field.set_army(from_field.get_army(), GameState.current_player);
            from_field.set_army(null, null);
        }
    }

    public static void attack(Field attacking_field, Field defense_field, List<Field> possible_attack_fields){

        TheArmy defense_army = defense_field.get_army();
        TheArmy attacking_army = attacking_field.get_army();

        if(!possible_attack_fields.contains(defense_field))
            return;

        if(attacking_army.get_rank() == defense_army.get_rank()){
            defense_army.decrease_health(attacking_army.get_strength_of_attack());
            if(defense_army.get_health() <= 0){
                defense_army.player.number_of_armies--;
                defense_field.set_army(null, null);
            }
        }
        else if(attacking_army.get_rank() < defense_army.get_rank()){
            defense_army.decrease_health(attacking_army.get_strength_of_attack() / 2);
            attacking_army.decrease_health(defense_army.get_strength_of_attack() / 2);
            if(defense_army.get_health() <= 0){
                defense_army.player.number_of_armies--;
                defense_field.set_army(null, null);
            }
            if(attacking_army.get_health() <= 0){
                attacking_army.player.number_of_armies--;
                attacking_field.set_army(null, null);
            }
        } else{ // >
            defense_army.decrease_health((int) (GameState.selected_field.get_army().get_strength_of_attack()*1.5));
            if(defense_army.get_health() <= 0){
                defense_army.player.number_of_armies--;
                defense_field.set_army(null, null);
            }
        }

    }
}
