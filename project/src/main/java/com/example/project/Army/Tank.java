package com.example.project.Army;

import com.example.project.Constants;
import com.example.project.Map.Board;
import com.example.project.Map.Field;
import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Tank extends TheArmy{


    public Tank() {
        super(Constants.tank_max_health, Constants.tank_max_health, Constants.tank_strength_of_attack, "/com/example/project/images/tank1.png");//, new Image("com/example/project/images/tank.png"));

        //image = new Image(getClass().getResource("/com/example/project/images/tank.png").toExternalForm());
    }

    public int get_rank(){
        return Constants.tank_rank;
    }

    @Override
    public List<Field> available_moves(Board board, Field field) {
        // tank can move two fields in 4 directions

        ArrayList<Field> moves =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_move_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.tank_range_moves, board, Constants.tank_can_jump));
        }

        return moves;
    }

    @Override
    public List<Field> available_attacks(Board board, Field field) {
        // tank can attack in range of 2 fields in 8 directions without overjump
        ArrayList<Field> attack_fields =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.tank_attack_range, board, Constants.tank_can_overjump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.tank_attack_range, board, Constants.tank_can_overjump));
        }

        return attack_fields;
    }
}
