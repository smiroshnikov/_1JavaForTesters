package hexlet.XO.controllers;

import hexlet.XO.model.Field;
import hexlet.XO.model.Point;

/**
 * Created by Iidwuurliik on 3/13/2017.
 * MoveController - будет описывать логику хода, выполнять все проверки для хода
 * (например проверять, что пользователь не поставит фигурку на место, где уже есть
 * фигурка; или не попробует поставить фигурку на несуществующие координаты и т.д.);
 */

public class MoveController {

    public boolean applyFigure(final Field field,
                               final Point point,
                               final String figure) {

        if ((point.x == -1) || point.y == -1) {
            return false;
        }
        if (field.getFigure(point) != null) {
            return false;
        }
        field.setFigure(point, figure);
        return true;
    }
}
