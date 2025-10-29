package com.example.project.Game;

import com.example.project.Map.Board;
import com.example.project.Map.Field;

import java.util.HashSet;

public class GameState {
    public static boolean first_click = true;
    public static Field selected_field;

    public static Player current_player = null;

    public static Board board = null;

    public static HashSet<Field> possible_move_fields = new HashSet<>();
    public static HashSet<Field> possible_attack_fields = new HashSet<>();
}
