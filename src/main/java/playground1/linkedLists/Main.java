package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 * Created my simple object and added them to my custom linked list
 * implemented comparable in myCustomSimpleObject
 */
public class Main {
    public static void main(String[] args) {

        CustomLinkedList l1 = new CustomLinkedList();
        CustomLinkedList l2 = new CustomLinkedList();
        int result = -1;

        l1.addValue(new myCustomSimpleObject("President", "Sergei", "Miroshnikov"));
        l1.addValue(new myCustomSimpleObject("QA", "Bob", "Shmulinson"));
        l1.addValue(new myCustomSimpleObject("Prime Minister", "null", "Noname"));

        l2.addValue(new myCustomSimpleObject("President", "Sergei", "Miroshnikov"));
        l2.addValue(new myCustomSimpleObject("QA", "Bob", "Shmulinson"));


        while (l1.hasNext() && l2.hasNext()) {
            if (((myCustomSimpleObject) l1.nextNode()).compareTo(((myCustomSimpleObject) l2.nextNode())) == 0) {
                result = l1.getCurrentPosition();
                break;
            }
        }
        System.out.println("Lists have same value @ position " + result);
    }
}
