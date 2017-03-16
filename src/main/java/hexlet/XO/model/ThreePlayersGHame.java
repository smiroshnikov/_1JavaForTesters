package hexlet.XO.model;

/**
 * Created by miross1 on 3/16/2017.
 */
public class ThreePlayersGHame extends TwoPlayersGame {

    private final String player3Name;


    public ThreePlayersGHame(String player1Name, String player2Name, String player3Name) {
        super(player1Name, player2Name);
        this.player3Name = player3Name;
    }

    public void printPlayer3Name() {
        System.out.println(player3Name);
    }

}
