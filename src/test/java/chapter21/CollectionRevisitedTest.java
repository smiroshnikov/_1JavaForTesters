package chapter21;

import javafortesters.chapter15.practice.User;
import javafortesters.chapter21.practice.*;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CollectionRevisitedTest {
    @Test
    public void backToCollections() {
        // Warning , what does it mean ?
        SortedSet<String> alphaset = new <String>TreeSet();
        alphaset.add("z");
        alphaset.add("A");
        alphaset.add("b");
        alphaset.add("f");
        alphaset.add("Z");
        alphaset.add("e");
        assertThat(alphaset.first(), is("A"));
        alphaset.add("a");
        alphaset.add("1");
        alphaset.add("3");
        assertThat(alphaset.last(), is("z"));
        String[] alphas = new String[alphaset.size()];
        // TODO useful conversion !
        alphaset.toArray(alphas);
        for (String e :
                alphas) {
            System.out.println(e);
        }
        System.out.println("==================================Headset GOES HERE=======================================\n");
        SortedSet<String> subset = alphaset.headSet("b"); // returns strictly less than "b"
        for (String e :
            //subset) {
                alphaset.headSet("b")) { // I like it more like this
            System.out.println(e);
        }
        // tailset
        System.out.println("==================================Tailset GOES HERE=======================================\n");
        for (String e :
                alphaset.tailSet("b")) { // includes b
            System.out.println(e);
        }
        System.out.println("==================================Subset GOES HERE=======================================\n");
        for (String e :
                alphaset.subSet("3", "f")) { //"f" not included
            System.out.println(e);
        }
    }

    @Test(expected = ClassCastException.class)
    // У нас есть SimpleUser , давайте впизьдячим его в SoretedSet вроде идея классная,
    // но Java не знает как сравнивать юзеров. Не знает бедная как решить кто больше а кто меньше... надо помочь
    // Должен быть определен Comparator for SimpleUser class
    public void blowWithException() {
        User bob = new User("Gandon", "Telefon123");
        SortedSet<User> userSortedSet = new TreeSet<>();
        userSortedSet.add(bob);
    }

    @Test
    public void addUsersToSortedSet() {
        User bob = new User("Bob", "pA55Word"); // 11
        User bob2 = new User("Bobb", "pA55Word"); // 11
        User tiny = new User("TinyTim", "Hhe1lo000"); //12
        User rich = new User("Richie", "RichieRichieRich1"); // 22
        User sun = new User("sun", "11111Ztzu"); // 6
        User mrBeer = new User("Stafford", "syyyyyySS1s"); // 11
        SortedSet<User> userSortedSet = new TreeSet<>(new UserComparator());
        userSortedSet.add(bob);
        userSortedSet.add(tiny);
        userSortedSet.add(rich);
        userSortedSet.add(sun);
        userSortedSet.add(mrBeer);
        userSortedSet.add(bob2);
        User[] users = new User[userSortedSet.size()];
        // TODO useful conversion !
        userSortedSet.toArray(users);
        for (User u :
                users) {
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void addUsersTOSortedSetRevisited() {
        AdminSimpleUser bob = new AdminSimpleUser("Bob", "sdfsdf");
        AdminSimpleUser dod = new AdminSimpleUser("Dod", "sdfsdf");
        AdminSimpleUser gog = new AdminSimpleUser("Dod", "sdfsdf");

        // TODO Warning is regarding TreeSet implementation - review this later - defensive programming
        SortedSet<SimpleUser> simpleUserSet = new TreeSet<>(new SimpleUserComparator());
        simpleUserSet.add(bob);
        simpleUserSet.add(dod);

        SimpleUser[] userList = new SimpleUser[simpleUserSet.size()];
        simpleUserSet.toArray(userList);
        for (SimpleUser e :
                userList) {
            System.out.println(e.getUsername());
        }


    }

    @Test
    public void duplicateUserComparator() {
        SortedSet<SimpleUser> userSet = new TreeSet<>(new DupeSimpleUserComparator());
        SimpleUser mojo = new SimpleUser("abc", "123456");
        SimpleUser jojo = new SimpleUser("cd", "123456");
        SimpleUser dojo = new SimpleUser("bbc", "123456");

        userSet.add(mojo);
        userSet.add(jojo);
        userSet.add(dojo);
        System.out.println(userSet.size());
        SimpleUser[] users = new SimpleUser[userSet.size()];
        userSet.toArray(users);
        for (SimpleUser u :
                users) {
            System.out.println(u.getUsername());

        }
        assertEquals("user set size mismatch ", userSet.size(), 3);
    }


}
