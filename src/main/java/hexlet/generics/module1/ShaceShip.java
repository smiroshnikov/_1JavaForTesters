package hexlet.generics.module1;

/**
 * Created by Iidwuurliik on 3/10/2017.
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
