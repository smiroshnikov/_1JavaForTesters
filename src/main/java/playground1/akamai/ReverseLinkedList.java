package playground1.akamai;

/**
 * Reverse a Linked list , will use my own LL for tyhe sake opf simplicity .
 */

public class ReverseLinkedList {


    public static void main(String[] args) {

        SimpleLinkedList l1 = new SimpleLinkedList();
        l1.addValue(1);
        l1.addValue(2);
        l1.addValue(3);
        l1.displayLinkedList();
        l1.reverse();
        l1.displayLinkedList();
    }


}
