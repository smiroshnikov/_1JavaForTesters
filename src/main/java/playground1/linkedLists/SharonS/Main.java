package playground1.linkedLists.SharonS;

/**
 * Created by Iidwuurliik on 2/21/2017.
 * Created my simple object and added them to my custom linked list
 * implemented comparable in Person
 */
public class Main {
    public static void main(String[] args) {

        CustomLinkedList l1 = new CustomLinkedList();
        CustomLinkedList l2 = new CustomLinkedList();
        int result = -1;

        // debug
//        l1.addValue(new Person("aa","zz","12"));
//        l1.addValue(new Person("a","bxs","a"));
//        l1.addValue(new Person("aaqqwe","c","a"));
//        l1.addValue(new Person("a1","f","a"));
//        l1.addValue(new Person("azsdfg","e","a"));
//        l1.addValue(new Person("qa","f","a"));
//        l1.addValue(new Person("__a","h","a"));
//        l1.addValue(new Person("a","u","a"));
//        l1.addValue(new Person("a","i","a"));
//        l1.addValue(new Person("a","a","a"));
//        l2.addValue(new Person("1","a","a"));
//        l2.addValue(new Person("2","a","a"));
//        l2.addValue(new Person("3","a","a"));
//        l2.addValue(new Person("4","a","a"));
//        l2.addValue(new Person("5","a","a"));
//        l2.addValue(new Person("6","a","a"));
//        l2.addValue(new Person("7","a","a"));
//        l2.addValue(new Person("a","8","a"));
//        l2.addValue(new Person("a","a","98"));
//        l2.addValue(new Person("a","a","987"));
//        l2.addValue(new Person("a","a","a"));


        l1.addValue(new Person("Presidents", "Sergei", "Miroshnikov"));
        l1.addValue(new Person("QA", "Bob", "Shmulinson"));
        l1.addValue(new Person("A", "B", "C"));
        l1.addValue(new Person("Aa", "B", "C"));

        l2.addValue(new Person("President", "Sergei", "Miroshnikov"));
        l2.addValue(new Person("President", "Sergei", "Miroshnikov"));
        l2.addValue(new Person("A", "B", "C"));


        // this is find_where.... from interview
        while (l1.hasNext() && l2.hasNext()) { // in case lists are not the same length
            if (((Person) l1.nextNode()).compareTo(((Person) l2.nextNode())) == 0) {
                result = l1.getCurrentPosition();
                break;
            }
        }
        l1.printMyLinkedList();
        l2.printMyLinkedList();

        System.out.println("Lists have same value @ position " + result);

        System.out.println("comparing Tails ");
        if (((Person) l1.getTail().getData()).compareTo(((Person) l2.getTail().getData())) == 0) {
            System.out.println("Same tails - Linked Lists intersect!");
        } else {
            System.out.println("They don't intersect!");
        }
    }
}
