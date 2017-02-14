package playground1;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    private Base64Utils() {
    }

    public static String encode(String value) throws Exception {
        //TODO Redo exceptions tutorial
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String value) throws Exception {
        byte[] decodedValue = Base64.getDecoder().decode(value);
        return new String(decodedValue, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        String test = "Iidwuurliik";
        String encodedTest = Base64Utils.encode(test);
        System.out.println(test + "base 64 = " + encodedTest);

    }
}
