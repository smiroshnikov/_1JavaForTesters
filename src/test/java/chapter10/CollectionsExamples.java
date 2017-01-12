package chapter10;


import org.junit.Test;

import java.util.*;

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
        assertEquals(2, numbers.length);


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

    @Test
    public void collectionRememberMe() {
        // This code exists as a reminder to understand the
        // Collections and interfaces
        Collection<String> users;
        users = new ArrayList<>();
        users.add("Can use only Collection methods");
        // I can use only methods allowed to Collection

        List<String> extendedUserCollection;
        extendedUserCollection = new ArrayList<>();
        // Here I can use methods that are allowed to List e.g "get"
        extendedUserCollection.addAll(users);
        System.out.println(extendedUserCollection.get(0));
    }

    @Test
    public void createAndManipulateCollectionOfUsersClasswork() {
        Collection<Object> users;
        users = new ArrayList<>();
        assertTrue(users.size() == 0);
        assertTrue(users.isEmpty());
        Object user1 = null;
        Object user2 = null;
        users.add(user1);
        users.add(user2);
        assertTrue(users.size() == 2);
        assertFalse(users.isEmpty());
        Collection<Object> differentUsers;
        differentUsers = new ArrayList<>();
        Object user3 = null, user4 = null;
        differentUsers.add(user3);
        differentUsers.add(user4);
        users.addAll(differentUsers);
        assertTrue(users.contains(user3));
        assertTrue(users.contains(user4));
        differentUsers.removeAll(differentUsers); // this is weird and may cause an exception !
        assertTrue("Collection not empty ", differentUsers.isEmpty());
        users.clear();
        assertTrue("Collection not empty", users.isEmpty());


    }

    @Test
    public void listClasswork() {
        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Friday");
        days.add("Wednesday");
        days.remove(2);

        List<String> missingDays = new ArrayList<>();
        missingDays.add("Tuesday");
        missingDays.add("Wednesday");
        missingDays.add("Thursday");
        days.addAll(1, missingDays); // very convenient
        assertEquals("Invalid amount of days", 5, days.size());
        days.add("Tuesday");
        days.add("Tuesday");
        System.out.printf("last Tuesday is located at %d", days.lastIndexOf("Tuesday")); // cool ! they have a method
        // for that
        days.set(6, "Remove me! I am not a day!");
        assertEquals("Remove me! I am not a day!", days.get(6));
        List<String> workDays = days.subList(0, 3);
        assertEquals("Monday", workDays.get(0));


    }

    @Test
    public void userListAssignment() {
        List<Object> users = new ArrayList<>();
        String user1 = "a", user2 = "b";

        users.add(user1);
        assertTrue(users.contains(user1));
        users.add(0, user2);
        assertTrue(users.contains(user2));
        assertEquals(1, users.indexOf(user1));
        assertEquals(0, users.indexOf(user2));
        users.remove(user1);
        assertFalse(users.contains(user1));


    }

    @Test
    public void setClasswork() {
        Set users = new HashSet();
        users.add("Bob");
        users.add("Bob");
        users.add("Bob");

        // duplicates are ignored !
        assertEquals(1, users.size());


    }

    @Test
    public void mapExample() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "Mojo");
        map.put(2000, "Jojo");
        map.put(3000, "Aojo");
        assertEquals(3, map.size());
        assertEquals("Aojo", map.get(3000));
        assertEquals(null, map.get(12));
        map.remove(3000);
        assertFalse(map.containsValue("Aojo"));
        assertEquals(2, map.size());
        map.clear();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertFalse(map.containsValue("not present!"));
        Collection<String> values = map.values();
        Set<Integer> keys = map.keySet();
    }

    @Test
    public void userMap() {
        Map<Integer, Object> userMap = new HashMap<>();
        Object u1 = 12, u2 = 15;
        userMap.put(1, u1);
        userMap.put(1, u2);
        assertTrue("u1 is not here ! ", userMap.containsValue(u2));


    }
}
