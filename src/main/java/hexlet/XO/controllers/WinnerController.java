package hexlet.XO.controllers;

import hexlet.XO.model.Field;
import hexlet.XO.model.Point;

/**
 * Created by Iidwuurliik on 3/13/2017.
 * WinnerController - отвечает за проверку того, кто победил на поле
 * (или же ничья).
 * Именно этот класс будет устанавливать победившего пользователя.
 */


public class WinnerController {

    public String getWinner(final Field field) {
        // BEGIN (write your solution here)
        final Point p1 = new Point();
        final Point p2 = new Point();
        final Point p3 = new Point();
        p1.x = 0;
        p2.x = 1;
        p3.x = 2;

        p1.y = 0;
        p2.y = 1;
        p3.y = 2;

        if (field.getFigure(p1) != null && field.getFigure(p2) != null &&
                field.getFigure(p3) != null &&
                field.getFigure(p1).equals(field.getFigure(p2)) &&
                field.getFigure(p1).equals(field.getFigure(p3))) {
            return field.getFigure(p1);
        }
        p1.x = 2;
        p2.x = 1;
        p3.x = 0;

        p1.y = 0;
        p2.y = 1;
        p3.y = 2;

        if (field.getFigure(p1) != null && field.getFigure(p2) != null
                && field.getFigure(p3) != null &&
                field.getFigure(p1).equals(field.getFigure(p2)) &&
                field.getFigure(p1).equals(field.getFigure(p3))) {
            return field.getFigure(p1);
        }
        for (int i = 0; i < field.getSize(); i++) {
            p1.x = 0;
            p2.x = 1;
            p3.x = 2;

            p1.y = i;
            p2.y = i;
            p3.y = i;

            if (field.getFigure(p1) != null && field.getFigure(p2) != null
                    && field.getFigure(p3) != null &&
                    field.getFigure(p1).equals(field.getFigure(p2)) &&
                    field.getFigure(p1).equals(field.getFigure(p3))) {
                return field.getFigure(p1);
            }
        }
        for (int i = 0; i < field.getSize(); i++) {
            p1.x = i;
            p2.x = i;
            p3.x = i;

            p1.y = 0;
            p2.y = 1;
            p3.y = 2;

            if (field.getFigure(p1) != null && field.getFigure(p2) != null
                    && field.getFigure(p3) != null &&
                    field.getFigure(p1).equals(field.getFigure(p2)) &&
                    field.getFigure(p1).equals(field.getFigure(p3))) {
                return field.getFigure(p1);
            }
        }
        return null;
        // END
    }
}
