package hexlet.XO;

import hexlet.XO.controllers.CurrentMoveController;
import hexlet.XO.model.Field;
import hexlet.XO.model.Point;

import java.util.Arrays;

/**
 * Tic tac toe main
 */
public class Main {

    public static void main(String... args) {
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
                System.out.printf(" putting figure: %s to the: X:%d Y:%d\n", figure, p.x, p.y);
                if (cmc.currentMove(field).equals(figure)) {
                   throw new RuntimeException(String.format("returns %s for the field: %s", figure, Arrays.deepToString(field.figures)));
                }

            }

    }


}
