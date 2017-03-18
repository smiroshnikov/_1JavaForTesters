package hexlet.XO.controllers;

import hexlet.XO.model.Field;
import hexlet.XO.model.Point;

/**
 * Created by Iidwuurliik on 3/13/2017.
 * CurrentMoveController - будет содержать логику, которая по состоянию поля будет определять
 * какой игрок сейчас ходит (например, если ход первый - ходит Х, если второй - О и т.д.)
 */
public class CurrentMoveController {

    public String currentMove(Field field) {

        Point p = new Point();
        int xCounter = 0;
        int oCounter = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                p.x = i;
                p.y = j;

                if (field.getFigure(p) != null) {
                    if (field.getFigure(p).equals("X")) {
                        xCounter += 1;
                        //System.out.println("X = " + xCounter);
                    }

                    if (field.getFigure(p).equals("O")) {
                        oCounter += 1;
                        //System.out.println("O = " + oCounter);
                    }
                }
            }
        }

        if ((xCounter == 0 && oCounter == 0) || (xCounter == oCounter)) {
            return "X";
        }

        return "O";

    }
}
