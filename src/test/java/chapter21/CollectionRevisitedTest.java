package chapter21;


import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

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


}
