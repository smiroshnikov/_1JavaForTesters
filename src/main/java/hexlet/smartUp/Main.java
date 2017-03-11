package hexlet.smartUp;

/**
 * Created by Iidwuurliik on 3/11/2017.
 * looking at the size of primitives in memory
 */

public class Main {
    public static void main(String[] args) {
        Human human; // created a referance on "stack" that points nowere same as Human human = null ;
        human = new Human(); // now here we have ALLOCATED memory space (part of "heap") reserved for out human
        // fields age , name , surename and sex exist but contain initial values e.g "0,false,

        System.out.printf("%d%n", human.age);

        System.out.printf("%b%n", human.sex);

        System.out.printf("%s%n", human.name);



    }
}
