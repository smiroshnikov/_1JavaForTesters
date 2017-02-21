package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class myCustomSimpleObject implements Comparable<myCustomSimpleObject> {
    String title;
    String firstName;
    String lastName;

    public myCustomSimpleObject(String Title, String firstName, String lastName) {
        this.title = Title;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public int compareTo(myCustomSimpleObject o) {
        return title.length() + firstName.length() + lastName.length() - (o.title.length()
                + o.firstName.length() + o.lastName.length());

    }
}
