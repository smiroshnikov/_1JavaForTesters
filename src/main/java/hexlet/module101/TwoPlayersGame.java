package hexlet.module101;

import hexlet.XO.controllers.Game;

/**
 * Inheritance tutorial
 */
public class TwoPlayersGame extends Game {
    private final String player1Name;
    private final String player2Name;

    public TwoPlayersGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void printPlayer1Name() {
        System.out.println(player1Name);
    }


    public void printPlayer2Name() {
        System.out.println(player2Name);
    }


}
