package hexlet.module101;

import java.util.Arrays;

public class Board {

    private static final int SIZE_FIELD = 3;

    private Figure[][] figures = new Figure[SIZE_FIELD][SIZE_FIELD];

    public void showBoard() {
        //System.out.println(Arrays.toString(this.figures)); // Arrays , handy
        System.out.println(Arrays.deepToString(this.figures)); // handy works with [][][][].....

    }

    public void initArray() {

        figures[0][0] = new Figure("O");
        figures[0][2] = new Figure("X");
    }

}
