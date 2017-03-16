package hexlet.threading;

/**
 * Created by Iidwuurliik on 3/16/2017.
 * Tasting threading
 */
public class Main {

    public static void main(String[] args) throws Exception {
        final Point startP = new Point(0, 0);
        final ThreadInc t1 = new ThreadInc(startP);
        final ThreadInc t2 = new ThreadInc(startP);
        final ThreadInc t3 = new ThreadInc(startP);
        final ThreadInc t4 = new ThreadInc(startP);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(t1.getResult().getX() + "/" + t1.getResult().y);
        System.out.println(t2.getResult().getX() + "/" + t2.getResult().y);
        System.out.println(t3.getResult().getX() + "/" + t3.getResult().y);
        System.out.println(t4.getResult().getX() + "/" + t4.getResult().y);


    }
}
