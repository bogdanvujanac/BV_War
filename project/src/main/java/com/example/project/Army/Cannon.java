package com.example.project.Army;

import com.example.project.Constants;
import com.example.project.Map.Board;
import com.example.project.Map.Field;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Cannon extends TheArmy{
    protected Cannon() {
        super(Constants.cannon_max_health, Constants.cannon_max_health, Constants.cannon_strength_of_attack);
    }

    @Override
    public List<Field> available_moves(Board board, Field field) {
        // cannon can move only one field in 4 directions
        ArrayList<Field> moves =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_move_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.cannon_range_moves, board, Constants.cannon_can_jump));
        }

        return moves;
    }

    @Override
    public List<Field> available_attacks(Board board, Field field) {
        // cannon can attack in range of 3 fields in 4 directions with possible overjump others
        ArrayList<Field> attack_fields =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            attack_fields.addAll(get_attack_fields_in_direction(field, dir.getKey(), dir.getValue(), Constants.cannon_attack_range, board, Constants.cannon_can_overjump));
        }

        return attack_fields;
    }
}
