package hexlet.generics.module1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iidwuurliik on 3/10/2017.
 * Intended to show compatibility to legacy Java pre -6 and create runtime errors
 */
public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>(1);
        Integer i = box.getItem();
        System.out.println(i);
        // so far all good
        List<Integer> list = new ArrayList<>();
        list.add(1);
        show(list); // show reprecents an old legacy method (Java 5) before Generics
        List fuckedUpList = new ArrayList(); // allowed in order to support Java 5 and below legacy code
        fuckedUpList.add(1);
        fuckedUpList.add(2);
        fuckedUpList.add(3);
        fuckedUpList.add("heloo!!!"); // no problem detected so far by ide , lets compile and run
        // WORKS !
        show(fuckedUpList);// this might work but will lead to unpredictable errors

    }

    public static void show(final List list) {
        // look at the fucntion signature , type is not strictly defined
        // this will be a problem
        list.forEach(System.out::println);


    }
}
