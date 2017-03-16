package hexlet.threading;

/**
 * Created by Iidwuurliik on 3/16/2017.
 */
public class Point {
    // at this state Point is brocken to be used in multi-threading !
    // in order to fix that Point fields should be immutable

    final long x; //0
    final long y; //0

    public Point(final long x, final long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
