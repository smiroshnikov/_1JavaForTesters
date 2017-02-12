package cool.stuff;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Playing with Base64
 */
public class EncodeDecodeTest {

    @Test
    public void encodeDecodeString() throws UnsupportedEncodingException {
        byte[] stringInBytes = "Sergei Miroshnikov is great!".getBytes("UTF-8");

        String encodedName = Base64.getEncoder().encodeToString(stringInBytes);
        System.out.println(encodedName);
        stringInBytes = encodedName.getBytes("UTF-8");

        byte[] decoded = Base64.getDecoder().decode(stringInBytes);
        System.out.println(new String(decoded, "UTF-8"));

    }
}
