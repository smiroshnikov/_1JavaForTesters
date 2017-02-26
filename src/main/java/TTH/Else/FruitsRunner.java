package TTH.Else;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by miross1 on 2/26/2017.
 */
public class FruitsRunner {
    public static void main(String[] args) {
        List<String> fruit = new ArrayList<>();
        System.out.println("Empty : " + fruit.isEmpty());
        fruit.add("cherry");
        fruit.add("orange");
        System.out.println(fruit.get(0));


    }
}
