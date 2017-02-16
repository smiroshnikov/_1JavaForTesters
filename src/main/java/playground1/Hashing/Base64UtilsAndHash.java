package playground1.Hashing;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Formatter;

public class Base64UtilsAndHash {

    private Base64UtilsAndHash() {
    }

    public static String encode(String value) throws Exception {
        //TODO Redo exceptions tutorial
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String value) throws Exception {
        byte[] decodedValue = Base64.getDecoder().decode(value);
        return new String(decodedValue, StandardCharsets.UTF_8);
    }

    public static String byteArrayToHexString(byte[] byteHash) {
        Formatter formatter = new Formatter();
        for (byte b :
                byteHash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static void main(String[] args) throws Exception {
        String plainText = "Iidwuurliik";
        String encodedWithBase64Text = Base64UtilsAndHash.encode(plainText);
        System.out.println(plainText + "--->[base 64 ENCODED]---> " + encodedWithBase64Text);
        String decodedFromBase64Text = Base64UtilsAndHash.decode("SWlkd3V1cmxpaWs=");
        System.out.println(encodedWithBase64Text + " --->[back to human]---> " + decodedFromBase64Text);
        // instantiating a my hashing magic
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] byteHash = (md.digest(plainText.getBytes()));
        System.out.println(plainText + " -> hashed by SHA-1 algoritm ->" + byteArrayToHexString(byteHash));

    }


}
