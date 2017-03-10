package hexlet.generics.module0;

/**
 * Created by Iidwuurliik on 3/10/2017.
 * Following hexlet tutorial , on Generics
 */


public class Tuple<T> {
    // <T> means that the Type is defined during creation of the class instance
    private final T left;
    private final T right;

    public Tuple(final T left, final T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
}
