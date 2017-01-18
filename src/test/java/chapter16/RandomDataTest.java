package chapter16;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RandomDataTest {
    @Test
    public void randomData() {
        double rnd = Math.random();
        System.out.println(String.format("generated %f", rnd));
        assertThat(rnd < 1.0d, is(true));
        assertThat(rnd >= 0, is(true));
    }

    @Test
    public void randomLong() {
        Random r = new Random();
        System.out.println(r.nextLong());
        Boolean randomBoolean = r.nextBoolean();
        System.out.println(randomBoolean);
        byte[] randomBytes = new byte[r.nextInt(100)];
        r.nextBytes(randomBytes);
        for (byte b :
                randomBytes) {
            System.out.println(b);
        }
    }

    @Test
    public void randomBoundaries() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int x = r.nextInt(Integer.MAX_VALUE) + Integer.MIN_VALUE;
            long l = r.nextLong();
            System.out.println(x);
            System.out.println(l);
            assertThat(l < Long.MAX_VALUE, is(true));
            assertThat(l > Long.MIN_VALUE, is(true));
            assertThat(x < Integer.MAX_VALUE, is(true));
            assertThat(x > Integer.MIN_VALUE, is(true));
        }
    }


}
