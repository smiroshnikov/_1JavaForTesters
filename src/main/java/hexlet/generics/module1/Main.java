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
//        fuckedUpList.add(1);
//        fuckedUpList.add(2);
//        fuckedUpList.add(3);
//        fuckedUpList.add("heloo!!!"); // no problem detected so far by ide , lets compile and run
        // WORKS !
        show(fuckedUpList);// this might work but will lead to unpredictable errors

        // lets break stuff
        Box<Integer> b1 = new Box<>(1);
        Box b2 = b1; // b2 has no idea what b1 is , just reference
        b2.setItem("Hello"); // will compile !

        //box.setItem("What?!?1"); - will not compile
        System.out.println(b2.getItem()); // how about that - look at the byte code and see that its all about Object !
        // lets get more crazy than that and try to see what getItem of b1 wuill return
        System.out.println(b1.getItem()); // OMG ! works because println accepts object as an input
        Integer j = b1.getItem(); // runtime exception , when forced to cast to Integer and has a String "hello" so ClassCastException occurs
        // brain is not melting but the idea in this tut is how NOT to write BAD code





    }

    public static void show(final List list) {
        // look at the fucntion signature , type is not strictly defined
        // this will be a problem
        list.forEach(System.out::println);


    }
}
