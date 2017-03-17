package hexlet.XO.controllers;

import hexlet.XO.model.Player;

/**
 * Created by Iidwuurliik on 3/11/2017.
 * XO Game
 */
public class Game {

    private static final String GAME_NAME = "XO";
    Player[] players;


    public String getGameName() {
        return GAME_NAME;
    }

    public Player currentPlayer() {
        return players[0];
    }

    public boolean move(final int x, final int y) {
        return false;
    }
}
