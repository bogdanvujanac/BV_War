package com.example.project.Army;

import javafx.util.Pair;

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
}
