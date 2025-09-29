package com.example.project.Army;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Infantry extends TheArmy{

    public Infantry(int max_health, int health, int strength_of_attack, Pair<Integer, Integer> field) {
        super(max_health, health, strength_of_attack, field);
    }

    @Override
    protected List<Pair<Integer, Integer>> available_moves(int size_of_board) {
        // infantry can move only one field
        int x = this.field.getValue();
        int y = this.field.getKey();

        ArrayList<Pair<Integer, Integer>> moves =  new ArrayList<>();

        //TODO: refactor
        if(x-1 >= 0 && y-1 >= 0)
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
            moves.add(new Pair<>(x, y+1));

        return moves;
    }

    @Override
    protected List<Pair<Integer, Integer>> available_attacks(int size_of_board) {
        // infantry can attack in range of only one field
        int x = this.field.getValue();
        int y = this.field.getKey();

        ArrayList<Pair<Integer, Integer>> attack_fields =  new ArrayList<>();

        //TODO: refactor
        if(x-1 >= 0 && y-1 >= 0)
            attack_fields.add(new Pair<>(x-1, y-1));
        if(x-1 >= 0)
            attack_fields.add(new Pair<>(x-1, y));
        if(x-1 >=0 && y+1 < size_of_board)
            attack_fields.add(new Pair<>(x-1, y+1));
        if(x+1 < size_of_board && y-1 >= 0)
            attack_fields.add(new Pair<>(x+1, y-1));
        if(x+1 < size_of_board)
            attack_fields.add(new Pair<>(x+1, y));
        if(x+1 < size_of_board && y+1 < size_of_board)
            attack_fields.add(new Pair<>(x+1, y+1));
        if(y-1 >= 0)
            attack_fields.add(new Pair<>(x, y-1));
        if(y+1 < size_of_board)
            attack_fields.add(new Pair<>(x, y+1));

        return attack_fields;
    }
}
