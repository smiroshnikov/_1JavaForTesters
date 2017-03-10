package hexlet.generics.module1;

/**
 * Mutated class
 */
public class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        // aadskiy mutator
        this.item = item;
    }
}
