package hexlet.generics.module1;

/**
 * Created by Iidwuurliik on 3/10/2017.
 * It is required to create a flexible class that will accept ANY lifefoms , and in that case will use a biuld in lifeform's methods
 */

public class SpaceProgram {
    public static void main(String[] args) {
        Human h = new Human();
        Dog d = new Dog();
        ShaceShip<Human> humanShip = new ShaceShip<>(h); // Genecric class that accepts different lifeforms Only
        ShaceShip<Dog> dogShip = new ShaceShip<>(d); // Genecric class that accepts different lifeforms Only
        dogShip.showLFName();
        humanShip.showLFName();
        Human humanInsanceToBeUsedInMain = humanShip.getLf(); // using getLF and that is a lifeform method
        System.out.println(humanInsanceToBeUsedInMain.getName());

    }
}
