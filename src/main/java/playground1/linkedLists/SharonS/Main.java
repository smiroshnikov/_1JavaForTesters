package playground1.linkedLists.SharonS;

/**
 * Created by Iidwuurliik on 2/21/2017.
 * Solving interview that I had today
 */
public class Main {

    public static boolean areListsEmpty(CustomLinkedList l1, CustomLinkedList l2) {
        if (l1.getTail().getData() == null || l2.getTail().getData() == null) {
            return true;
        }
        return false;
    }

    public static boolean doListsMeet(CustomLinkedList l1, CustomLinkedList l2) {
        // comparing tails () in my case last element of every list
        return (l1.getTail().getData() == l2.getTail().getData());
    }

    public static int findPositionWhereListsMeet(CustomLinkedList l1, CustomLinkedList l2) {
        int firstCommonValuePosition = -1; // in case no such elements exist
        while (l1.hasNext() && l2.hasNext()) { // in case lists are not the same length

            if (((Integer) l1.nextNode()).compareTo(((Integer) l2.nextNode())) == 0) {
                firstCommonValuePosition = l1.getCurrentPosition();
                return firstCommonValuePosition;
            }
        }
        return firstCommonValuePosition;
    }

    public static void main(String[] args) {

        CustomLinkedList l1 = new CustomLinkedList();
        CustomLinkedList l2 = new CustomLinkedList();

        System.out.println("Checking of lists are empty .... " + areListsEmpty(l1, l2));
        if (areListsEmpty(l1, l2)) {
            System.out.println("Please stop providing empty lists ! ");
        }

        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(1);
        l1.addValue(999);
        l1.addValue(2);
        l1.addValue(4);

        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(2);
        l2.addValue(999);
        l2.addValue(2);
        l2.addValue(4);

        l1.printMyLinkedList();
        l2.printMyLinkedList();

        System.out.println("Checking of lists are empty .... " + areListsEmpty(l1, l2));


        System.out.println("Do lists intersect ? " + doListsMeet(l1, l2));

        System.out.println("Lists have same value @ position " + findPositionWhereListsMeet(l1, l2));

    }
}
