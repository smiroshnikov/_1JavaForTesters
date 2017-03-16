package hexlet.threading;

/**
 * Created by Iidwuurliik on 3/16/2017.
 * Tasting threading
 */
public class Main {

    public static void main(String[] args) throws Exception {
        final Point startP = new Point();
        final Thread t1 = new ThreadInc(startP);
        final Thread t2 = new ThreadInc(startP);
        final Thread t3 = new ThreadInc(startP);
        final Thread t4 = new ThreadInc(startP);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(startP.x + "/" + startP.y);


    }
}
