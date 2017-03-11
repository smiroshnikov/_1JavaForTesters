package hexlet.smartUp;

/**
 * Created by Iidwuurliik on 3/11/2017.
 * Stack and Heap
 */

public class Main {
    public static void main(String[] args) {
        Human human = null; // created a reference on "stack" that points nowhere , same as "Human human;"
        // to prove this lets create a NullPointerException
        // human.age = 12; // This line will be compiled and result in nullPointer

        human = new Human(); // now here we have ALLOCATED memory space (part of "heap") reserved for out human
        // fields age , name , surename and sex exist but contain initial values e.g "0,false,

        System.out.printf("%d%n", human.age);

        System.out.printf("%b%n", human.sex);

        System.out.printf("%s%n", human.name);


    }
}
