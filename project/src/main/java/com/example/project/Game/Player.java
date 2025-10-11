package com.example.project.Game;

public class Player {
    private String username;

    public Player(String username, String color) {
        this.username = username;
        this.color = color;
    }

    public int number_of_armies = 7;

    public String get_username() {
        return username;
    }

    public String color;

}
