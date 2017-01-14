package chapter14;

import javafortesters.chapter13.practice.InvalidPassword;
import javafortesters.chapter6.practice.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Chapter14Classwork {
    @Rule
    // expected exception declaration ?
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void invalidPasswordThrown() {
        expected.expect(InvalidPassword.class);
        User user = new User("Myao", "123");

    }

}
