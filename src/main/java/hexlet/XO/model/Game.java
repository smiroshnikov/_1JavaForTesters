package hexlet.XO.model;

/**
 * Created by Iidwuurliik on 3/11/2017.
 * XO Game
 */
public class Game {

    private static final String GAME_NAME = "XO";
    Player[] players;

    public static void showGameName() {
        System.out.println(GAME_NAME);
    }

    public Player currentPlayer() {
        return players[0];
    }

    public boolean move(int x, int y) {
        return false;
    }


}
