package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class CustomLinkedList {
    // Node  (data) -> Node (data) ->Node(data) -> null
    // Add Node
    // Delete Node
    // Find Node

    Node head;
    Node tail = null;

    public Node getHead() {
        return head;
    }

    public void add(Node node) {
        // scenario 1 : Empty Linked List
        // scenario 2 : Non Empty linked List
        if (tail == null) {
            head = node;
            tail = node;

        } else {
            tail.nextNode = node;
            tail = node;
        }

    }


    public void printMyLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNextNode();
        }
        System.out.println("NULL");

    }
}

