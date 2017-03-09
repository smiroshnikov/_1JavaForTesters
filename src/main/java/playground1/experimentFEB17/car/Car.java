package playground1.experimentFEB17.car;

/**
 * Just following simple tutorial on Udemy , got me interested on what actually happens when we use .this
 */
public class Car {
    String color = "blue";
    String type = "Corvette";

    { // this overrides values declared above
        color = "red";
        type = "Celica";
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public Car() {
        // emp[ty constructor on purpose to see if I will get the *default* values
    }

    @Override
    public String toString() {
        return String.format("This cas painted %s and is \"%s\" type", color, type);
    }
}
