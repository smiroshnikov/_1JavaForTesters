package hexlet.module101;

public class Figure {
    private String figure;

    public Figure(String figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return this.figure;
    }
}
