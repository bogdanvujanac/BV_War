package com.example.project.Army;

import com.example.project.Constants;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Cannon extends TheArmy{
    protected Cannon(Pair<Integer, Integer> field) {
        super(Constants.cannon_max_health, Constants.cannon_max_health, Constants.cannon_strength_of_attack, field);
    }

    @Override
    protected List<Pair<Integer, Integer>> available_moves(int size_of_board) {
        // cannon can move only one field in 4 directions
        int x = this.field.getKey();
        int y = this.field.getValue();

        ArrayList<Pair<Integer, Integer>> moves =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.cannon_range_moves, size_of_board, false));
        }

        return moves;
    }

    @Override
    protected List<Pair<Integer, Integer>> available_attacks(int size_of_board) {
        return List.of();
    }
}
