package com.example.project.Game;

import com.example.project.Map.Board;
import com.example.project.Map.Field;

import java.util.List;

public class GameState {
    public static boolean first_click = true;
    public static Field selected_field;

    public static Player current_player = null;

    public static Board board = null;

    public static List<Field> possible_move_fields = null;
}
