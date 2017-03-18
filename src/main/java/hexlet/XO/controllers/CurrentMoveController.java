package hexlet.XO.controllers;

import hexlet.XO.model.Field;

/**
 * Created by Iidwuurliik on 3/13/2017.
 * CurrentMoveController - будет содержать логику, которая по состоянию поля будет определять
 * какой игрок сейчас ходит (например, если ход первый - ходит Х, если второй - О и т.д.)
 */
public class CurrentMoveController {

    public String currentMove(Field field) {

        return "X";

    }
}
