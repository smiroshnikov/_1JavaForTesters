package playground1.linkedLists.SharonS;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class CustomLinkedList {

    final Node HEAD = new Node(null); // Useful
    Node tail = HEAD;
    Node current = HEAD;
    int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Node getTail() {
        return tail;
    }


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
        // if I desire to go over list again , might be useful
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

// Banging my head on the wall ! remove before commit
// step 1 h->node(null)<-t
// step 2
// h->node(null)->value-<tail
// h->node(null)->node(value)->(node)title<-tail
}

