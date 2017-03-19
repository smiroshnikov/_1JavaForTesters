package playground1.experimentMAR17;


import hexlet.module101.Figure;

/**
 * Created by Iidwuurliik on 3/19/2017.
 * N X N matrix used a board
 */

/**
 * Gaming board represented as  N * N matrix
 */

public class Board {
    private static final int BOARD_SIZE = 10;

    public String[][] figures = new String[BOARD_SIZE][BOARD_SIZE];

    public int getBoardSize() {
        return figures.length;
    }

    public String getFigureFromBoard(final MyPoint point) {
        return figures[point.x][point.y];
    }

    public void putFigureOnBoard(final MyPoint point, final Figure figure) {

    }


}
