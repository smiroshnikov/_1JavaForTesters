package javaForTesters.chapter14;

import javafortesters.chapter13.practice.InvalidPassword;
import javafortesters.chapter6.practice.User;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class Chapter14Classwork {

    @BeforeClass
    public static void initialSetup() {
        System.out.println("Beginning test suite SR-SP14");
    }

    @Before
    public void nextTestPrompt() {
        System.out.println("Now proceeding to the next test ! ");
    }

    @Rule
    // expected exception declaration ?
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void invalidPasswordThrown() {
        expected.expect(InvalidPassword.class);
        expected.expectMessage("Password must be 7 chars at least !");
        // the line below is deprecated !
        //expected.expectMessage(containsString("7 chars"));
        User user = new User("Myao", "123");
    }

    @Ignore("Feature is not yet supported in 63.21_01b")
    @Test
    public void thisTestIsIgnored() {
    }

    @Test
    public void allAssertions() {
        User user = new User();
        assertEquals("username", user.getUsername());
        assertFalse(user.getPassword().length() == 0);
        assertTrue(Objects.equals(user.getPermission(), "Normal"));
        assertNotSame(new User[]{user}, User.createUsers(1));

    }

    @Test
    public void hamcrestTut() {
        assertThat("3 + 3 = 6 ", 3 + 3, is(6));
        assertThat(new User(), not(new User()));
        assertThat("wuieyrwkhfekwejhr", containsString("wej"));
        assertThat(null, is(nullValue()));
        assertThat("1000002", startsWith("1"));
        assertThat("1000002", endsWith("2"));
        fail();
    }

    @AfterClass
    public static void completionProcedure() {
        System.out.println("Test Suite completed ! ");

    }

}
