package hexlet.generics.module0;

/**
 * Created by Iidwuurliik on 3/10/2017.
 * multi typed tuple with proper understandable code
 */
public class ImprovedTuple<Input, Return> {
    private final Input index;
    private final Return content;

    public ImprovedTuple(Input index, Return content) {
        this.index = index;
        this.content = content;
    }

    public Input getIndex() {
        return index;
    }

    public Return getContent() {
        return content;
    }

    // here is the place where we want to manipulate / process with Type variables
    public Return process(Input item) {
        if (!item.equals(getIndex())) {
            return null;
        } else {
            System.out.print(("index is correct..."));
            return getContent();
        }
    }

}
