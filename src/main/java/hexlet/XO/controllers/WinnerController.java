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

        Point p01 = new Point();
        p01.x = 0;
        p01.y = 1;
        Point p02 = new Point();
        p02.x = 0;
        p01.y = 2;
        Point p03 = new Point();
        p02.x = 0;
        p01.y = 3;

        if (field.getFigure(p01).equals(field.getFigure(p02))) {
            System.out.println("OMG!");

        }


        return null;
    }

}
