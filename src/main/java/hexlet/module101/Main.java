package hexlet.module101;

import hexlet.XO.controllers.Game;

/**
 * Created by miross1 on 3/16/2017.
 * Inheritance , HW
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        TwoPlayersGame twoP = new TwoPlayersGame("Bob", "Mike");
        ThreePlayersGHame threeP = new ThreePlayersGHame("Kate", "Stella", "Anna");
        Game g = new ThreePlayersGHame("b", "c", "l");


        printGameNameAndBoard(threeP);
        printGameNameAndBoard(twoP);
        printGameNameAndBoard(game);
        printGameNameAndBoard(null); // why can this accept null ?! Max

    }

    public static void printGameNameAndBoard(final Game game) {
        // this class can accept an instance of Game class as argument
        // or any other class that extends game
        // I was not aware of such usage when I created this class
        // that that is fucking cool!
        System.out.println(game.getGameName());
    }
}
