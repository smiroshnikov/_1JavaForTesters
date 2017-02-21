package playground1.linkedLists;

import java.util.LinkedList;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class JavaLinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("current size " + list.size());
        list.add(123);
        list.add(413);
        list.add(103);
        list.add(-12);
        list.add(9812387);
        System.out.println("current size " + list.size());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());


    }
}


