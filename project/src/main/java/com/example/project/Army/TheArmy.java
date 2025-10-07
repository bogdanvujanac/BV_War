package com.example.project.Army;

import com.example.project.Game.Player;
import com.example.project.Map.Board;
import com.example.project.Map.Field;
import javafx.scene.image.Image;


import java.util.ArrayList;
import java.util.List;

public abstract class TheArmy {

    protected int max_health; // TODO: think about removing this
    protected int health;
    protected int strength_of_attack;

    protected Image image;

    public Player player;

    public abstract List<Field> available_moves(Board board, Field field);
    public abstract List<Field> available_attacks(Board board, Field field); // TODO: filter by owner

    protected TheArmy(int max_health, int health, int strength_of_attack, String image_path){//}, Image image) {
        this.max_health = max_health;
        this.health = health;
        this.strength_of_attack = strength_of_attack;

        this.image = new Image(getClass().getResourceAsStream(image_path));
    }

    public void set_player(Player player) {
        this.player = player;
    }

    /// x, y -> current field
    /// step_x, step_y -> direction
    /// range_moves -> range of steps in the direction
    /// size_of_board ->
    /// can_jump -> can army jump above friendly army
    protected List<Field> get_move_fields_in_direction(Field field, int step_x, int step_y, int range_moves, Board board, boolean can_jump) {
        List<Field> moves = new ArrayList<>();
        int size_of_board = board.get_size();

        int x = field.get_x();
        int y = field.get_y();

        for(int i=1; i<=range_moves; i++){
            int new_x = x + step_x*i;
            int new_y = y + step_y*i;

            if(new_x < 0 || new_x >= size_of_board || new_y < 0 || new_y >= size_of_board)
                break;

            Field field1 = board.get_field(new_x, new_y);
            if(field1.is_occupied()) {
                if (!can_jump)
                    break;
            }
            else
                moves.add(field1);
        }

        return moves;
    }

    protected List<Field> get_attack_fields_in_direction(Field field, int step_x, int step_y, int attack_range, Board board, boolean overjump) {
        List<Field> attacks = new ArrayList<>();
        int size_of_board = board.get_size();

        int x = field.get_x();
        int y = field.get_y();


        for(int i=1; i<=attack_range; i++){
            int new_x = x + step_x*i;
            int new_y = y + step_y*i;

            if(new_x < 0 || new_x >= size_of_board || new_y < 0 || new_y >= size_of_board)
                break;

            Field field1 = board.get_field(new_x, new_y);
            if(field1.is_occupied()) {
                //TODO: check who occupied the field
                //if(who)
                attacks.add(field1);

                if(!overjump)
                    break;
            }


        }

        return attacks;
    }

    public Image get_image(){
        return image;
    }
}
