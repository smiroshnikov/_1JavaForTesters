package hexlet.generics.module0;

/**
 * Created by Iidwuurliik on 3/10/2017.
 * This class will provide me with generic Triple
 * based on my Improved Tuple
 */
public class Triple<Input, Middle, Return> extends ImprovedTuple<Input, Return> {
    private final Middle body;

    public Triple(Input index, Middle body, Return content) {
        super(index, content);
        this.body = body;
    }

    public Middle getBody() {
        return body;
    }
}
