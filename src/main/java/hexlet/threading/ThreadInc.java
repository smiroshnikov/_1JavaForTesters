package hexlet.threading;

/**
 * Created by Iidwuurliik on 3/16/2017.
 */
public class ThreadInc extends Thread {
    private Point p;

    public ThreadInc(Point p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (long i = 0; i < 100_000; i++) {
            p = new Point(p.getX() + 1, p.getY() + 1);
        }
    }

    public Point getResult() {
        return p;
    }

}
