package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class CustomLinkedList {

    final Node HEAD = new Node(null);
    Node tail = HEAD; // 1 node list
    Node current = HEAD;
    int currentPosition = 0;

    public int getCurrentPosition() {

        return currentPosition;
    }
    // step 1 h->node(null)<-t

// step 2
// h->node(null)->value-<tail
// h->node(null)->node(value)->(node)title<-tail


    public void addValue(Object value) {
        Node nextNode = new Node(value);
        tail.setNextNode(nextNode); // tail points to new element
        tail = nextNode; // new element becomes tail

    }

    public boolean hasNext() {
        return (current.nextNode != null);
    }

    public Object nextNode() {
        Object result = current.getNextNode().getData();
        current = current.nextNode;
        currentPosition++;
        return result;
    }

    public void resetCurrent() {
        current = HEAD;
        currentPosition = 0;
    }

    public void printMyLinkedList() {
        Node current = HEAD;
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNextNode();
        }
        System.out.println("END");
    }
}

