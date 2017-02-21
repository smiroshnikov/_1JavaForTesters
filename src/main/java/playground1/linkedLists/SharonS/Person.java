package playground1.linkedLists.SharonS;

/**
 * Created by Iidwuurliik on 2/21/2017.
 * comparing Person based on total length of characters
 */

public class Person implements Comparable<Person> {
    // just wanted to have custom objects to be a target for comparison instead of integers
    // that have they own compareTo method

    String title;
    String firstName;
    String lastName;

    public Person(String Title, String firstName, String lastName) {
        this.title = Title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        return title.length() + firstName.length() + lastName.length() - (o.title.length()
                + o.firstName.length() + o.lastName.length());

    }

    @Override
    public String toString() {
        return "{" +
                "" + title + '\'' +
                "," + firstName + '\'' +
                "," + lastName + '\'' +
                '}';
    }
}
