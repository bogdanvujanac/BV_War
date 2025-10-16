package com.example.project;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Constants {
    private Constants() {}

    public static final int infantry_max_health = 100;
    public static final int infantry_strength_of_attack = 30;
    public static final int infantry_range_moves = 2;
    public static final int infantry_attack_range = 1;
    public static final int infantry_rank = 1;
    public static final boolean infantry_can_jump = false;
    public static final boolean infantry_can_overjump = false;

    public static final int cavalry_max_health = 150;
    public static final int cavalry_strength_of_attack = 40;
    public static final int cavalry_range_moves = 3;
    public static final int cavalry_attack_range = 1;
    public static final int cavalry_rank = 2;
    public static final boolean cavalry_can_jump = true;
    public static final boolean cavalry_can_overjump = false;

    public static final int tank_max_health = 300;
    public static final int tank_strength_of_attack = 60;
    public static final int tank_range_moves = 2;
    public static final int tank_attack_range = 2;
    public static final int tank_rank = 3;
    public static final boolean tank_can_jump = false;
    public static final boolean tank_can_overjump = false;

    public static final int cannon_max_health = 80;
    public static final int cannon_strength_of_attack = 80;
    public static final int cannon_range_moves = 1;
    public static final int cannon_attack_range = 3;
    public static final int cannon_rank = 3;
    public static final boolean cannon_can_jump = false;
    public static final boolean cannon_can_overjump = true;

    public static final List<Pair<Integer, Integer>> four_directions = new ArrayList<>(
            Arrays.asList(
                    new Pair<>(0, 1),
                    new Pair<>(1, 0),
                    new Pair<>(-1, 0),
                    new Pair<>(0, -1)
            )
    );

    public static final List<Pair<Integer, Integer>> diagonal_directions = new ArrayList<>(
            Arrays.asList(
                    new Pair<>(1, 1),
                    new Pair<>(1, -1),
                    new Pair<>(-1, 1),
                    new Pair<>(-1, -1)
            )
    );
}
