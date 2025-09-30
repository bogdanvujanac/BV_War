package com.example.project.Army;

import com.example.project.Constants;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Infantry extends TheArmy{

    public Infantry(Pair<Integer, Integer> field) {
        super(Constants.infantry_max_health, Constants.infantry_max_health, Constants.infantry_strength_of_attack, field);
    }

    @Override
    protected List<Pair<Integer, Integer>> available_moves(int size_of_board) {
        // infantry can move two fields in 8 directions
        int x = this.field.getKey();
        int y = this.field.getValue();

        ArrayList<Pair<Integer, Integer>> moves =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            moves.addAll(get_move_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.infantry_range_moves, size_of_board, Constants.infantry_can_jump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            moves.addAll(get_move_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.infantry_range_moves, size_of_board, Constants.infantry_can_jump));
        }


        //TODO: refactor
        //TODO: add second round because infantry can move two fields
        /*if(x-1 >= 0 && y-1 >= 0)
            moves.add(new Pair<>(x-1, y-1));
        if(x-1 >= 0)
            moves.add(new Pair<>(x-1, y));
        if(x-1 >=0 && y+1 < size_of_board)
            moves.add(new Pair<>(x-1, y+1));
        if(x+1 < size_of_board && y-1 >= 0)
            moves.add(new Pair<>(x+1, y-1));
        if(x+1 < size_of_board)
            moves.add(new Pair<>(x+1, y));
        if(x+1 < size_of_board && y+1 < size_of_board)
            moves.add(new Pair<>(x+1, y+1));
        if(y-1 >= 0)
            moves.add(new Pair<>(x, y-1));
        if(y+1 < size_of_board)
            moves.add(new Pair<>(x, y+1));*/

        return moves;
    }

    @Override
    protected List<Pair<Integer, Integer>> available_attacks(int size_of_board) {
        // infantry can attack in range of only one field in  8 directions
        int x = this.field.getValue();
        int y = this.field.getKey();

        ArrayList<Pair<Integer, Integer>> attack_fields =  new ArrayList<>();

        for(Pair<Integer, Integer> dir : Constants.four_directions){
            attack_fields.addAll(get_attack_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.infantry_attack_range, size_of_board, Constants.infantry_can_overjump));
        }
        for(Pair<Integer, Integer> dir : Constants.diagonal_directions){
            attack_fields.addAll(get_attack_fields_in_direction(x, y, dir.getKey(), dir.getValue(), Constants.infantry_attack_range, size_of_board, Constants.infantry_can_overjump));
        }

        return attack_fields;
    }
}
