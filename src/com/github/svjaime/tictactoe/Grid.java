package com.github.svjaime.tictactoe;

public class Grid {

    public static final int SIZE = 3;
    private Cell[][] cells;

    public Grid() {
        init();
    }

    private void init() {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
        System.out.println(Messages.GAME_STARTED);
        draw();
    }

    public void setCellState(int row, int col, CellState state) {
        cells[row][col].setState(state);
    }

    public CellState getCellState(int row, int col) {
        return cells[row][col].getState();
    }

    public void draw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].draw();
            }
            System.out.println();
        }
    }

}
