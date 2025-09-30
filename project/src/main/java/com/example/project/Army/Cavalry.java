package com.example.project.Army;

import com.example.project.Constants;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Cavalry extends TheArmy {
    protected Cavalry(Pair<Integer, Integer> field) {
        super(Constants.cavalry_max_health, Constants.cavalry_max_health, Constants.cavalry_strength_of_attack, field);
    }

    @Override
    protected List<Pair<Integer, Integer>> available_moves(int size_of_board) {
        // cavalry can move three fields in 8 directions with possibility to jump
        int x = field.getKey();
        int y = field.getValue();

        List<Pair<Integer, Integer>> moves = new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_fields_in_direction(x, y, dir.getKey(), dir.getValue(),Constants.cavalry_range_moves,  size_of_board, true));
        }

        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            moves.addAll(get_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.cavalry_range_moves, size_of_board, true));
        }

        return moves;
    }

    @Override
    protected List<Pair<Integer, Integer>> available_attacks(int size_of_board) {
        return List.of();
    }
}
