package chapter15;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringsPart2 {

    @Test
    public void penisReplacementTest() {
        String fella = "Hello fella fella fella fella";
        assertThat(fella.replace("fella", "penis"), is("Hello penis penis penis penis"));
        String numbers = "1,2,3,4,5";
        System.out.println(numbers.replaceAll("[0-9]", "penis"));
        // removing whitespaces
        String trim = "    hey trim me ";
        System.out.println(trim.trim());
        // This is a very handy method to use when tidying up input data, or data read from files
        assertThat(trim.trim().length(), is(11));
        String digits = "012345679";
        System.out.println(digits.substring(5, 8));
        String template = "The value %d was used !";
        int value = 4;
        System.out.println(String.format(template, value));
        String weirdText = "%2$s %4$s very %3$d large %1$s";
        System.out.println(String.format(weirdText, "Bob", "ran", 6, "game"));
        String normalText = "%s %s towards %d large %s";
        System.out.println(String.format(normalText, "Bob", "ran", 6, "onions"));
    }


}
