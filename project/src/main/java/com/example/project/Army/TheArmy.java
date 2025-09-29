package com.example.project.Army;

import javafx.util.Pair;

import java.util.List;

public abstract class TheArmy {

    protected int max_health;
    protected int health;
    protected int strength_of_attack;

    protected abstract List<Pair<Integer, Integer>> available_moves();
    protected abstract List<Pair<Integer, Integer>> available_attacks();

    protected TheArmy(int max_health, int health, int strength_of_attack) {
        this.max_health = max_health;
        this.health = health;
        this.strength_of_attack = strength_of_attack;
    }
}
