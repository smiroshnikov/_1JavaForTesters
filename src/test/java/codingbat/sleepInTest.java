package codingbat;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class sleepInTest {

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        /*
        The parameter weekday is true if it is a weekday, and the parameter vacation
        is true if we are on vacation. We sleep in if it is not a weekday or we're on
        vacation. Return true if we sleep in.
         */
        return !weekday || vacation;
    }

    @Test
    public void checkSleepIn() {
        assertThat(sleepIn(false, false), is(true));
        assertThat(sleepIn(true, false), is(false));
        assertThat(sleepIn(false, true), is(true));
        assertThat(sleepIn(true, true), is(true));
    }

    public int diff21(int n) {
        /*
        Given an int n, return the absolute difference between n and 21,
        except return double the absolute difference if n is over 21.
         */
        return (n <= 21) ? (21 - n) : (n - 21) * 2;
    }

    @Test
    public void diff22Test() {
        assertThat(diff21(19), is(2));
        assertThat(diff21(10), is(11));
        assertThat(diff21(21), is(0));
        assertThat(diff21(22), is(2));
        assertThat(diff21(25), is(8));
        assertThat(diff21(30), is(18));
        assertThat(diff21(0), is(21));
        assertThat(diff21(1), is(20));
        assertThat(diff21(2), is(19));
        assertThat(diff21(-1), is(22));
        assertThat(diff21(-2), is(23));
        assertThat(diff21(50), is(58));
    }

}
