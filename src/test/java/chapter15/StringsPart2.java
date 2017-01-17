package chapter15;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringsPart2 {

    @Test
    public void penisReplacementTest() {
        String fella = "Hello fella fella fella fella";
        assertThat(fella.replace("fella", "penis"), is("Hello penis penis penis penis"));

    }

}
