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

}
