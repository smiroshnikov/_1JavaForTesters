package playground1.linkedLists.SharonS;

/**
 * Created by Iidwuurliik on 2/21/2017.
 * The main idea i wanted to implement here is not to expose user to Node , just to myCustomlist
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

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}