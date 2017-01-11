package chapter10;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.*;

public class CollectionsExamples {
    @Test
    public void simpleCollectionShow() {
        String[] numbers = {"one", "two", "three", "four"};
        // converting array to collection
        List<String> numbersList = Arrays.asList(numbers);


        List<String> t = new ArrayList<>();
        t.add("zero");
        assertEquals("zero", t.get(0));
        //ArrayList<String> workdayz;
        Collection workdayz; // only Collection interface is allowed - this is interface declaration !
        // I will nor receive "get()" because it is allowed to ArrayList entity
        workdayz = new ArrayList();
        workdayz.add("Monday");
        workdayz.add("Tuesday");
        workdayz.add("Wednesday");
        workdayz.add("Thursday");
        workdayz.add("Friday");
        assertEquals(5, workdayz.size());
        // uncomment workaysz as ArrayList to work
        //assertEquals("Mojo",workdayz.get(0));
        Collection<String> daysOfWeek = new ArrayList<String>();
        daysOfWeek.addAll(workdayz);
        assertEquals(workdayz.size(), daysOfWeek.size());
        // this is an interesting concept
        assertTrue(daysOfWeek.containsAll(workdayz));
        Collection<String> weekendDays = new ArrayList<>();
        weekendDays.add("Saturday");
        weekendDays.add("Funday");
        weekendDays.remove("Funday");
        assertFalse(weekendDays.contains("Funday"));
        weekendDays.add("Sunday");
        assertEquals(2, weekendDays.size());
        assertTrue("Bug not fixed , Sunday is NOT inside the collection", weekendDays.contains("Sunday"));
        for (String day :
                daysOfWeek) {
            System.out.println(day);
        }


    }
}
