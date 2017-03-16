package hexlet.threading;

/**
 * Created by Iidwuurliik on 3/16/2017.
 */
public class ThreadInc extends Thread {
    private final Point p;

    public ThreadInc(Point p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (long i = 0; i < 100_000; i++) {
            p.x++;
            p.y++;
        }

    }
}
