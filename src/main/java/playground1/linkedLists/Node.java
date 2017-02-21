package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class Node {
    Object data;
    Node nextNode;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}