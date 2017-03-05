package codingbat;

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
