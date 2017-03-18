package hexlet.XO.model;

/**
 * Created by Iidwuurliik on 3/17/2017.
 * Determined player figure "X" or "O"
 */
public class Field {

    private static final int FIELD_SIZE = 3;
    public String[][] figures = new String[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return figures.length;
    }

    public String getFigure(final Point point) {

        return figures[point.x][point.y];
    }

    public void setFigure(final Point point, final String figure) {

        figures[point.x][point.y] = figure;
    }

}
