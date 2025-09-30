package com.example.project.Army;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class TheArmy {

    protected int max_health;
    protected int health;
    protected int strength_of_attack;
    protected Pair<Integer, Integer> field; // TODO: create class for the field

    protected abstract List<Pair<Integer, Integer>> available_moves(int size_of_board); // TODO: filter by state of fields after creating board class
    protected abstract List<Pair<Integer, Integer>> available_attacks(int  size_of_board); // TODO: filter by state of fields

    protected TheArmy(int max_health, int health, int strength_of_attack, Pair<Integer, Integer> field) {
        this.max_health = max_health;
        this.health = health;
        this.strength_of_attack = strength_of_attack;
        this.field = field;
    }

    public void set_field(Pair<Integer, Integer> field) {
        this.field = field;
    }


    /// x, y -> current field
    /// step_x, step_y -> direction
    /// range_moves -> range of steps in the direction
    /// size_of_board ->
    /// can_jump -> can army jump above friendly army
    protected List<Pair<Integer, Integer>> get_fields_in_direction(int x, int y, int step_x, int step_y, int range_moves, int size_of_board, boolean can_jump) {
        List<Pair<Integer, Integer>> moves = new ArrayList<>();

        for(int i=1; i<range_moves; i++){
            int new_x = x + step_x*i;
            int new_y = y + step_y*i;

            if(new_x < 0 || new_x >= size_of_board || new_y < 0 || new_y >= size_of_board)
                break;

            // TODO: if(zauzeto polje)
            //          if(!can_jump) break;
            // else
            moves.add(new Pair<>(new_x, new_y));
        }

        return moves;
    }
}
