package playground1.akamai;

/**
 * Reverse a string
 */
public class ReverseAString {
    public static void main(String[] args) {
        String name = "iidwuurliik";
        StringBuilder sb = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; --i) {
            sb.append(name.charAt(i));
        }
        System.out.println(sb);


    }
}
