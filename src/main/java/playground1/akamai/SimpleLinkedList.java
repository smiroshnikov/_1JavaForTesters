package playground1.akamai;

/**
 * Created by miross1 on 2/22/2017.
 */

public class SimpleLinkedList {
    final Node HEAD = new Node(null);
    Node tail = HEAD;
    Node current = HEAD;
    int currentPosition = 0;

    public void addValue(Object value) {
        Node nextNode = new Node(value);
        tail.setNextNode(nextNode);
        tail = nextNode;
    }

    public Object nextNode() {
        Object result = current.getNextNode().getData();
        current = current.nextNode;
        currentPosition++;
        return result;
    }

    public void displayLinkedList() {
        Node current = HEAD;
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNextNode();
        }
        System.out.println("END");
    }

    public void reverse() {
        Node previousNode = null;
        Node current = HEAD;

        while (current != null) {
            previousNode = current;
            current = current.nextNode;
            current.nextNode = previousNode;

        }

    }

}
