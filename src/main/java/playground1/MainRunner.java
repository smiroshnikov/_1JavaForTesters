package playground1;


import java.util.ArrayList;
import java.util.List;

public class MainRunner {
    public static void main(String[] args) {
        String hello = "Hello fella!";
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < hello.length(); i++) {
            if (hello.indexOf("l", i) != -1) {
                i = hello.indexOf("l", i);
                result.add(i);
            }
        }
        for (int e :
                result) {
            System.out.println(e);
        }

    }
}
