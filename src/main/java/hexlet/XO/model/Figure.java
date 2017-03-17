package hexlet.XO.model;

/**
 * Created by Iidwuurliik on 3/17/2017.
 * Determined player figure "X" or "O"
 */
public class Figure {
    private final String figure;

    public Figure(String figure) {
        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }
}
