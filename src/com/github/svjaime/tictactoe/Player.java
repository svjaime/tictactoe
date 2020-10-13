package com.github.svjaime.tictactoe;

public class Player {

    private final PlayerType type;

    public Player(PlayerType type) {
        this.type = type;
    }

    public PlayerType getType() {
        return type;
    }
}
