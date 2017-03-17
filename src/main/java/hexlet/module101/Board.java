package hexlet.module101;

import java.util.Arrays;

public class Board {

    private static final int SIZE_FIELD = 9;

    private Figure[] figures = new Figure[SIZE_FIELD];

    public void showBoard() {
        System.out.println(Arrays.toString(this.figures)); // Arrays , handy

    }

    public void initArray() {
        figures[0] = new Figure("X");
        figures[3] = new Figure("O");
    }

}
