package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class Node {
    int data;
    Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
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