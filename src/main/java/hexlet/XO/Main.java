package hexlet.XO;

import hexlet.XO.controllers.CurrentMoveController;
import hexlet.XO.controllers.WinnerController;
import hexlet.XO.model.Field;
import hexlet.XO.model.Point;

import java.util.Arrays;

/**
 * Tic tac toe main
 */
public class Main {

    public static void main(String... args) {
        //region old main
//        final Field field = new Field();
//        final CurrentMoveController cmc = new CurrentMoveController();
//
//        final Point p = new Point();
//        p.x = 1;
//        p.y = 1;
//
//        if (!cmc.currentMove(field).equals("X")) {
//            throw new RuntimeException("does not return X when the field is empty");
//        }
//
//        for (int i = 0; i < field.getSize(); i++)
//            for (int i2 = 0; i2 < field.getSize(); i2++) {
//                p.x = i;
//                p.y = i2;
//                final String figure = (i * 3 + i2) % 2 == 0 ? "X" : "O";
//                field.setFigure(p, figure);
//                System.out.printf(" putting figure: %s to the: X:%d Y:%d\n", figure, p.x, p.y);
//                if (cmc.currentMove(field).equals(figure)) {
//                   throw new RuntimeException(String.format("returns %s for the field: %s", figure, Arrays.deepToString(field.figures)));
//                }
//
//            }
        //endregion
        final Field field = new Field();
        final CurrentMoveController cmc = new CurrentMoveController();

        final Point p = new Point();
        p.x = 1;
        p.y = 1;

        if (!cmc.currentMove(field).equals("X")) {
            throw new RuntimeException("does not return X when the field is empty");
        }

        for (int i = 0; i < field.getSize(); i++)
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                p.x = i;
                p.y = i2;
                final String figure = (i * 3 + i2) % 2 == 0 ? "X" : "O";
                field.setFigure(p, figure);
                System.out.printf("putting figure: %s to the: X:%d Y:%d\n", figure, p.x, p.y);
                if (cmc.currentMove(field).equals(figure)) {
                    throw new RuntimeException(String.format("returns %s for the field: %s", figure,
                            Arrays.deepToString(field.figures)));
                }

            }

        checkField(null, null, null, null, null, null, null, null, null, null);

        checkField("X",
                "X", "X", "X",
                null, null, null,
                null, null, null);

        checkField("O",
                null, null, "O",
                "O", "O", "O",
                "X", null, null);
        checkField("X",
                null, null, null,
                null, null, null,
                "X", "X", "X");

        checkField("O",
                "O", "X", null,
                null, "O", null,
                null, null, "O");
    }

    private static void checkField(String winner, String... field) {
        final Field f = new Field();
        for (int i = 0; i < field.length; i++) {
            final Point p = new Point();
            p.x = i % 3;

            p.y = (i - i % 3) / 3;
            f.setFigure(p, field[i]);

        }
        final WinnerController wc = new WinnerController();
        if (winner == null && wc.getWinner(f) != null)
            throw new RuntimeException(String.format("Incorrectly shows winner for the field: %s, it shows: %s",
                    Arrays.deepToString(f.figures), wc.getWinner(f)));
        if (winner != null && !winner.equals(wc.getWinner(f)))
            throw new RuntimeException(String.format("Incorrectly shows winner for the field: %s, it shows: %s",
                    Arrays.deepToString(f.figures), wc.getWinner(f)));

    }
}

