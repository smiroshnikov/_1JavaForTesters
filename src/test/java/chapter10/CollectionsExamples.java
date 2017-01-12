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

    @Test
    public void objectsInCollectionsExample() {
        Collection workdayz;
        workdayz = new ArrayList();
        workdayz.add("Monday");
        workdayz.add("Tuesday");
        workdayz.add("Wednesday");
        workdayz.add("Thursday");
        workdayz.add("Friday");
        // for each with objects 
        for (Object workday :
                workdayz) {
            String output = (String) workday; // this is casting
            System.out.println(output);
        }
        Collection<String> weekDays = new <String>ArrayList();
        weekDays.addAll(workdayz);
        assertEquals(5, workdayz.size());
        workdayz.clear();
        assertTrue(workdayz.isEmpty());
        assertEquals(0, workdayz.size());
        Collection<Integer> numberz = new <Integer>ArrayList();
        numberz.add(1);
        numberz.add(2);
        numberz.add(3);
        numberz.add(4);
        numberz.add(5);
        Collection<Integer> numberzToRemove = new <Integer>ArrayList();
        numberzToRemove.add(2);
        numberzToRemove.add(3);
        numberzToRemove.add(4);
        numberz.removeAll(numberzToRemove);
        assertEquals(2, numberz.size());
        Integer[] integers = new Integer[numberz.size()];
        numberz.toArray(integers); // filled with Integers
        // or
        Object[] numbers = numberz.toArray();
        assertEquals(2, numbers.length);
        assertEquals(1, numbers.length);


    }

    @Test
    public void retainExample() {
        String[] workingDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Collection<String> weekdays = Arrays.asList(workingDays);
        List<String> weekends = Arrays.asList("Friday", "Saturday");
        List fullWeek = new ArrayList();

        fullWeek.addAll(weekdays);
        fullWeek.addAll(weekends);
        assertEquals(7, fullWeek.size());
        fullWeek.retainAll(weekends);

        for (Object day :
                fullWeek) {
            String output = (String) day;
            System.out.println(output);


        }


    }
}
