package com.github.svjaime.tictactoe;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player(PlayerType.PLAYER_X);
        Player p2 = new Player(PlayerType.PLAYER_O);

        Game game = new Game(p1, p2);

        while (game.getState() == GameState.PLAYING) {
            game.setPlayer();
            game.acceptMove();
        }
    }
}
