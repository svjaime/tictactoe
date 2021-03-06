package com.github.svjaime.tictactoe;

public class Cell {

    private CellState state;

    public Cell() {
        state = CellState.EMPTY;
    }

    public void draw() {
        System.out.print(state.getSymbol());
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
