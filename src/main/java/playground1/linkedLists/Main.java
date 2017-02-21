package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class Main {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();


        list.add(new Node(12));
        list.add(new Node(98));
        list.add(new Node(52));
        list.add(new Node(-12));
        list.add(new Node(23412));

        System.out.println(list.getHead().getData());
        System.out.println(list.getHead().getNextNode().getData());


    }
}
