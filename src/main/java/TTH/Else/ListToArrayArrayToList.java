package TTH.Else;

import java.util.Arrays;
import java.util.List;

public class ListToArrayArrayToList {
    public static void main(String[] args) {
        List<String> vegetables = Arrays.asList("broccoli", "corn", "kale");
        String[] veggieArray = vegetables.toArray(new String[0]);
        for (String ss :
                veggieArray) {
            System.out.println(ss);
        }
        List<String> veggieListFromArrayToList = Arrays.asList(veggieArray);
        for (String element :
                veggieListFromArrayToList) {
            System.out.println(element);
        }

    }
}