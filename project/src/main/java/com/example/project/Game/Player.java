package com.example.project.Game;

public class Player {
    private String username;

    public Player(String username) {
        this.username = username;
    }

    public int number_of_armies = 7;

    public String get_username() {
        return username;
    }

}
