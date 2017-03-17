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

        if (point.x == 0 && point.y == 0) {
            return figures[0][0];
        }
        if (point.x == 0 && point.y == 1) {
            return figures[0][1];
        }
        if (point.x == 0 && point.y == 2) {
            return figures[0][2];
        }
        if (point.x == 1 && point.y == 0) {
            return figures[1][0];
        }
        if (point.x == 1 && point.y == 1) {
            return figures[1][1];
        }
        if (point.x == 1 && point.y == 2) {
            return figures[1][2];
        }
        if (point.x == 2 && point.y == 0) {
            return figures[2][0];
        }
        if (point.x == 2 && point.y == 1) {
            return figures[2][1];
        }
        if (point.x == 2 && point.y == 2) {
            return figures[2][2];
        }
        return null;
    }

    public void setFigure(final Point point, final String figure) {

        if (point.x == 0 && point.y == 0) {
            figures[0][0] = figure;
        }
        if (point.x == 0 && point.y == 1) {
            figures[0][1] = figure;
        }
        if (point.x == 0 && point.y == 2) {
            figures[0][2] = figure;
        }
        if (point.x == 1 && point.y == 0) {
            figures[1][0] = figure;
        }
        if (point.x == 1 && point.y == 1) {
            figures[1][1] = figure;
        }
        if (point.x == 1 && point.y == 2) {
            figures[1][2] = figure;
        }
        if (point.x == 2 && point.y == 0) {
            figures[2][0] = figure;
        }
        if (point.x == 2 && point.y == 1) {
            figures[2][1] = figure;
        }
        if (point.x == 2 && point.y == 2) {
            figures[2][2] = figure;
        }
    }

}
