package com.example.project.Army;

import com.example.project.Constants;
import com.example.project.Map.Board;
import com.example.project.Map.Field;
import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Infantry extends TheArmy{

    public Infantry() {
        super(Constants.infantry_max_health, "/com/example/project/images/infantry.png");//, new Image("com/example/project/images/infaantry.png"));

        //image = new Image(getClass().getResource("/com/example/project/images/infantry.png").toExternalForm());
    }

    @Override
    public int get_max_health() {
        return Constants.infantry_max_health;
    }

    @Override
    public int get_strength_of_attack() {
        return Constants.infantry_strength_of_attack;
    }

    public int get_rank(){
        return Constants.infantry_rank;
    }

    @Override
    public List<Field> available_moves(Board board, Field field) {
        // infantry can move two fields in 8 directions
        ArrayList<Field> moves =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_move_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.infantry_range_moves, board, Constants.infantry_can_jump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            moves.addAll(get_move_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.infantry_range_moves, board, Constants.infantry_can_jump));
        }

        return moves;
    }

    @Override
    public List<Field> available_attacks(Board board, Field field) {
        // infantry can attack in range of only one field in  8 directions

        ArrayList<Field> attack_fields =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.infantry_attack_range, board, Constants.infantry_can_overjump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.infantry_attack_range, board, Constants.infantry_can_overjump));
        }

        return attack_fields;
    }
}
