package com.github.svjaime.tictactoe;

public enum CellState {
    EMPTY('-'),
    X_CELL('X'),
    O_CELL('O');

    private final char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
