package codingbat;

/*
The parameter weekday is true if it is a weekday, and the parameter vacation
is true if we are on vacation. We sleep in if it is not a weekday or we're on
vacation. Return true if we sleep in.
 */


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class sleepInTest {

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    @Test
    public void checkSleepIn() {
        assertThat(sleepIn(false, false), is(true));
        assertThat(sleepIn(true, false), is(false));
        assertThat(sleepIn(false, true), is(true));
        assertThat(sleepIn(true, true), is(true));
    }


}
