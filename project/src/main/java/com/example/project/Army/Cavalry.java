package com.example.project.Army;

import com.example.project.Constants;
import com.example.project.Map.Board;
import com.example.project.Map.Field;
import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Cavalry extends TheArmy {
    public Cavalry() {
        super(Constants.cavalry_max_health, Constants.cavalry_max_health, Constants.cavalry_strength_of_attack);//, new Image("com/example/project/images/calavry2.png"));

        image = new Image(getClass().getResource("/com/example/project/images/cavalry2.png").toExternalForm());
    }

    @Override
    public List<Field> available_moves(Board board, Field field) {
        // cavalry can move three fields in 8 directions with possibility to jump
        List<Field> moves = new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_move_fields_in_direction(field, dir.getKey(), dir.getValue(),Constants.cavalry_range_moves,  board, Constants.cavalry_can_jump));
        }

        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            moves.addAll(get_move_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.cavalry_range_moves, board, Constants.cavalry_can_jump));
        }

        return moves;
    }

    @Override
    public List<Field> available_attacks(Board board, Field field) {
        // cavalry can attack in range of only one field in 8 directions
        ArrayList<Field> attack_fields =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.cavalry_attack_range, board, Constants.cavalry_can_overjump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.cavalry_attack_range, board, Constants.cavalry_can_overjump));
        }

        return attack_fields;
    }
}
