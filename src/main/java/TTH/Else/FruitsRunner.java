package TTH.Else;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FruitsRunner {
    public static void main(String[] args) {
        List<String> fruit = new ArrayList<>();
        System.out.println("Empty : " + fruit.isEmpty());
        fruit.add("cherry");
        fruit.add("orange");
        System.out.println(fruit.get(0));
        fruit.add(1, "watermelon"); // remember that :) ,
        Collections.sort(fruit);
        for (String f :
                fruit) {
            System.out.println(f);
        }




    }
}
