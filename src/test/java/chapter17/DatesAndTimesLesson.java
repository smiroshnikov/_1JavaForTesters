package chapter17;

import org.junit.Test;

import java.util.Random;

// Interview Alert
// In addition to working with dates, I also use the Date/Time functionality to:
//• seed random numbers
//• generate unique data e.g. filenames, and user

public class DatesAndTimesLesson {
    @Test
    public void checkNano() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int r = new Random().nextInt();
            System.out.println(r);
        }
//        System.out.println(System.nanoTime());
//        System.out.println(System.currentTimeMillis());

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("took " + estimatedTime / 1000000000.0 + " nanoseconds");

    }


}
