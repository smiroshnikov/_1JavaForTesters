package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class Main {
    public static void main(String[] args) {

        CustomLinkedList l1 = new CustomLinkedList();
        CustomLinkedList l2 = new CustomLinkedList();
        int result = -1;

        l1.addValue(new Suko("#$%^asd", "23423asd", "aasd1324sdasd"));
        l1.addValue(new Suko("asd", "asd", "asdasd"));
        l1.addValue(new Suko("#d", "23___asd", "aa dasd"));
        l2.addValue(new Suko("#$%^asd", "23423asd", "aasd1324sdasd"));

        while (l1.hasNext() && l2.hasNext()) {
            if (((Suko) l1.nextNode()).compareTo(((Suko) l2.nextNode())) == 0) {
                result = l1.getCurrentPosition();
                break;
            }
        }
        System.out.println("Lists have same value @ position " + result);
    }
}
