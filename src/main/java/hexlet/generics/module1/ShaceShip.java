package hexlet.generics.module1;

/**
 * Extending Generic as a Type
 */
public class ShaceShip<T extends LifeForm> {
    private T lf;

    public ShaceShip(T lf) {
        this.lf = lf;
    }

    public T getLf() {
        return lf;
    }

    public void showLFName() {
        System.out.println(lf.getName());
    }
}
