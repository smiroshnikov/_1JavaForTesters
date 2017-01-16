package chapter15;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class StringRevisited {
    @Test
    public void stringRecall() {
        String aString = "abcdef";
        assertThat("hello".length(), is(5));
        assertEquals("123456", "123" + "456");
        System.out.println("Bob \tsaid\b \"hello\r\" to his cat");
        String s1 = "golden ";
        String s2 = s1.concat("penis");
        System.out.println(s2);
        String intToStrConvert = Integer.toString(2);
        System.out.println(intToStrConvert);
        char[] cArray = {'a', 'b'};
        assertThat("ab".toCharArray(), is(cArray));
        byte[] bArray = "hello there!".getBytes();
        for (byte b :
                bArray) {
            System.out.println(b);
        }
    }

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF-8");
        for (byte b :
                b8Array) {
            System.out.println(b);
        }
    }

    @Test
    public void classwork2() {
        String empty = "";
        assertThat(empty.length(), is(0));
        char[] cArray = {'2', '3'};
        assertThat(new String(cArray), is("23"));
        byte[] b8Array = {111, 101};
        System.out.println(new String(b8Array));
    }

    @Test
    public void classwork3() {
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"), is(0));
        assertThat(hello.compareTo("hello") < 0, is(true));
        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.contentEquals("Hello"), is(true));
        assertThat(hello.toLowerCase().contentEquals("hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.startsWith("He"), is(true));
        hello = "Hello fella!";
        assertThat(hello.regionMatches(true, 6, "fez", 0, 2),
                is(true));
        assertThat(hello.toLowerCase().regionMatches(true, 9, "young lady".toLowerCase(),
                6, 2), is(true));
    }

    @Test
    public void classwork4() {
        String h = "Hellllloooo";
        assertThat(h.indexOf('l'), is(2));
        assertThat(h.lastIndexOf('l'), is(6));
        String hello = "Hello fella!";
        assertThat(hello.lastIndexOf('l', 10), is(9));
        assertThat(hello.indexOf('z'), is(-1));
    }

    @Test
    public void classwork5() {
        // TODO REMEMBER THIS!
        /*
            An example scenario for the use of Regular Expressions might be that we want to expand
            the password validation on our User class:
            • password must contain a digit
            • password must contain an uppercase letter
         */
        //String mustIncludeADigit = ".*[0123456789]+.*";
        // a better definition
        String mustIncludeADigit = ".*[0-9]+.*";
        assertThat("12345678".matches(mustIncludeADigit), is(true));
        assertThat("1nvalid".matches(mustIncludeADigit), is(true));
        assertThat("invalid0".matches(mustIncludeADigit), is(true));
        assertThat("invalid".matches(mustIncludeADigit), is(false));
        String mustIncludeUpperCase = ".*[A-Z]+.*";
        assertThat("valiD".matches(mustIncludeUpperCase), is(true));



    }

}
