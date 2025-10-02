package com.example.project.Map;

import com.example.project.Army.TheArmy;

public class Field {

    private int x;
    private int y;

    private TheArmy army;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.army = null;
    }

    public boolean is_occupied(){
        return army != null;
    }

    public void set_army(TheArmy army){
        this.army = army;
    }

    public TheArmy get_army(){
        return army;
    }

    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
}
