package com.github.svjaime.tictactoe;

import java.util.Scanner;

public class Game {

    private final Grid grid;
    private final Player p1;
    private final Player p2;
    private final Scanner scanner;
    private Player currentPlayer;
    private GameState state;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        grid = new Grid();
        state = GameState.PLAYING;
        scanner = new Scanner(System.in);
    }

    public void setPlayer() {
        currentPlayer = currentPlayer == p1 ? p2 : p1;
        switch (currentPlayer.getType()) {
            case PLAYER_X -> System.out.println(Messages.X_ENTER_PLAY);
            case PLAYER_O -> System.out.println(Messages.O_ENTER_PLAY);
        }
    }

    public void acceptMove() {
        int[] pos = getPlayerInput();

        if (isValidMove(pos)) {
            int row = pos[0];
            int col = pos[1];
            drawMove(row, col);
            updateState(row, col);
        } else {
            acceptMove();
        }
    }

    private int[] getPlayerInput() {

        String[] input = scanner.nextLine().split(" ");
        int[] pos = {-1, -1};

        if (input.length != pos.length) {
            return pos;
        }

        try {
            pos[0] = Integer.parseInt(input[0]);
            pos[1] = Integer.parseInt(input[1]);
        } catch (Exception e) {
            //System.out.println(Messages.INVALID_PLAY);
        }
        return pos;
    }

    public GameState getState() {
        return state;
    }

    private void updateState(int row, int col) {

        if (isDraw()) {
            state = GameState.DRAW;
            System.out.println(Messages.DRAW);
        }

        if (hasWon(row, col, currentPlayer)) {
            switch (currentPlayer.getType()) {
                case PLAYER_O -> {
                    state = GameState.O_WON;
                    System.out.println(Messages.O_WON);
                }
                case PLAYER_X -> {
                    state = GameState.X_WON;
                    System.out.println(Messages.X_WON);
                }
            }
        }
    }

    private boolean isValidMove(int[] pos) {
        int row = pos[0];
        int col = pos[1];

        if (row < 0 || row >= Grid.SIZE || col < 0 || col >= Grid.SIZE || CellState.EMPTY != grid.getCellState(row, col)) {
            System.out.println(Messages.INVALID_PLAY);
            return false;
        }
        return true;
    }

    private void drawMove(int row, int col) {
        switch (currentPlayer.getType()) {
            case PLAYER_X -> grid.setCellState(row, col, CellState.X_CELL);
            case PLAYER_O -> grid.setCellState(row, col, CellState.O_CELL);
        }
        grid.draw();
    }

    private boolean isDraw() {
        for (int i = 0; i < Grid.SIZE; i++) {
            for (int j = 0; j < Grid.SIZE; j++) {
                if (grid.getCellState(i, j) == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWon(int row, int col, Player player) {
        char symbol = player.getType().getSymbol();
        return (rowCheck(row, symbol) || colCheck(col, symbol) || diag1Check(row, col, symbol) || diag2Check(row, col, symbol));
    }

    private boolean diag2Check(int row, int col, char symbol) {
        if (row + col == Grid.SIZE - 1) {
            for (int i = 0; i < Grid.SIZE; i++) {
                if (grid.getCellState(i, (Grid.SIZE - 1) - i).getSymbol() != symbol) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean diag1Check(int row, int col, int symbol) {
        if (row == col) {
            for (int i = 0; i < Grid.SIZE; i++) {
                if (grid.getCellState(i, i).getSymbol() != symbol) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean colCheck(int col, char symbol) {
        for (int i = 0; i < Grid.SIZE; i++) {
            if (grid.getCellState(i, col).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean rowCheck(int row, char symbol) {
        for (int i = 0; i < Grid.SIZE; i++) {
            if (grid.getCellState(row, i).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
