package com.example.project.Map;

import javafx.scene.control.Button;

import java.util.List;

public class Board {

    private final int size;
    private final Field[][] fields;
    //Button[][] buttons;

    public Board(int size, Button[][] buttons) {
        this.size = size;
        fields = new Field[size][size];

        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                fields[i][j] = new Field(i, j, buttons[i][j]);

        //this.buttons = buttons;
    }

    public int  get_size()
    {
        return size;
    }

    public  Field get_field(int x, int y)
    {
        return fields[x][y];
    }

    public List<Field> available_moves(Field field)
    {
        return field.get_army().available_moves(this, field);
    }

    public List<Field> available_attacks(Field field)
    {
        return field.get_army().available_attacks(this, field);
    }

}
