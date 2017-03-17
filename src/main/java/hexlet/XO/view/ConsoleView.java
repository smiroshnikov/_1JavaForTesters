package hexlet.XO.view;

import hexlet.XO.controllers.Game;

/**
 * Created by Iidwuurliik on 3/13/2017.
 * UI class
 */

public class ConsoleView {

    private final Game game;

    public ConsoleView(Game game) {
        this.game = game;
    }

    public void showGameName() {
        System.out.println(game.getGameName());

    }

    public boolean move(Game game) {
        return false;
    }

}
