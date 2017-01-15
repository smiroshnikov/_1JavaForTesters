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
}
