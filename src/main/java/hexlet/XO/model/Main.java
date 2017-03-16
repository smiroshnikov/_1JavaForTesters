package hexlet.XO.model;

/**
 * Created by miross1 on 3/16/2017.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        TwoPlayersGame twoP = new TwoPlayersGame("Bob", "Mike");
        ThreePlayersGHame threeP = new ThreePlayersGHame("Kate", "Stella", "Anna");

        printGameNameAndBoard(threeP);
        printGameNameAndBoard(twoP);
        printGameNameAndBoard(game);
    }

    public static void printGameNameAndBoard(final Game game) {
        // this class can accept instance of Game class as argument
        // or any other class that extends game
        // I was not aware of such usage when I created this class
        // tand that is fucking cool
        game.printGameName();
    }
}
