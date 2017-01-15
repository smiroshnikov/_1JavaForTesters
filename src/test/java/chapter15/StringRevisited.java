package chapter15;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
        //TODO this is a candidate for QA interview
        /* Write a method, which takes a String and a substring as parameters
        and returns a List<Integer> where each Integer is the location of the
        substring in the String.*/
        //assertThat(allOccurrencesInAString("Hello fella!", "l"),
        //      is(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
        List<Integer> pM = new ArrayList<>();
        pM = allOccurrencesInAString("Hello fella", "l");
        for (int element :
                pM) {
            System.out.println(element);

        }
    }

    public List<Integer> allOccurrencesInAString(String fullString, String requiredLetter) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        do {
            if (fullString.indexOf(requiredLetter) != -1) {
                i = fullString.indexOf(requiredLetter);
                result.add(i);
                i += 1;
            }
            System.out.println(i);
        } while (i < fullString.length());
        return result;

    }

}
