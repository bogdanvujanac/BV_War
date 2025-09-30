package com.example.project.Army;

import com.example.project.Constants;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Tank extends TheArmy{


    protected Tank(Pair<Integer, Integer> field) {
        super(Constants.tank_max_health, Constants.tank_max_health, Constants.tank_strength_of_attack, field);
    }

    @Override
    protected List<Pair<Integer, Integer>> available_moves(int size_of_board) {
        // tank can move two fields in 4 directions
        int x = field.getKey();
        int y = field.getValue();

        ArrayList<Pair<Integer, Integer>> moves =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_move_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.tank_range_moves, size_of_board, Constants.tank_can_jump));
        }

        return moves;
    }

    @Override
    protected List<Pair<Integer, Integer>> available_attacks(int size_of_board) {
        // tank can attack in range of 2 fields in 8 directions without overjump
        int x = this.field.getValue();
        int y = this.field.getKey();

        ArrayList<Pair<Integer, Integer>> attack_fields =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            attack_fields.addAll(get_attack_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.tank_attack_range, size_of_board, Constants.tank_can_overjump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            attack_fields.addAll(get_attack_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.tank_attack_range, size_of_board, Constants.tank_can_overjump));
        }

        return attack_fields;
    }
}
