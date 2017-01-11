package chapter10;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CollectionsExamples {
    @Test
    public void simpleCollectionShow() {
        String[] numbers = {"one", "two", "three", "four"};
        // converting array to collection
        List<String> numbersList = Arrays.asList(numbers);


        List<String> t = new ArrayList<>();
        System.out.println(numbersList.get(2));
        t.add("zero");
        assertEquals("zero", t.get(0));
        //ArrayList<String> workdayz;
        Collection workdayz; // only Collection interface is allowed
        // I will nor receive "get()" because it is allowed to ArrayList entity
        workdayz = new ArrayList();
        workdayz.add("Mojo");
        workdayz.add("Kozo");
        workdayz.add("Kojo");
        assertEquals(true, workdayz.contains("Mojo"));
        // uncomment workaysz as ArrayList to work
        //assertEquals("Mojo",workdayz.get(0));



    }
}
