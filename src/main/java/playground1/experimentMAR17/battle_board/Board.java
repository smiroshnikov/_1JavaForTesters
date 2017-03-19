package playground1.experimentMAR17.battle_board;


/**
 * Created by Iidwuurliik on 3/19/2017.
 * Gaming board represented as  N * N matrix
 */

public class Board {

    private static final int BOARD_SIZE = 3;

    // FIXME: 3/19/2017  Replace String figure with Monsters !
    public String[][] figures = new String[BOARD_SIZE][BOARD_SIZE];


    public int getBoardSize() {
        return figures.length;
    }

    public String getFigureFromBoard(final MyPoint point) {
        return figures[point.x][point.y];
    }

    public void putFigureOnBoard(final MyPoint point, final String figure) {
        figures[point.x][point.y] = figure;
    }


}
