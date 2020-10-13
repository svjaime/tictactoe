package com.github.svjaime.tictactoe;

public enum PlayerType {
    PLAYER_X('X'),
    PLAYER_O('O');

    private final char symbol;

    PlayerType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
