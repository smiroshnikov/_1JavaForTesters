package hexlet.XO.controllers;

import hexlet.XO.model.Field;

/**
 * Created by Iidwuurliik on 3/13/2017.
 * WinnerController - отвечает за проверку того, кто победил на поле (или же ничья).
 * Именно этот класс будет устанавливать победившего пользователя.
 */


public class WinnerController {

    public String getWinner(Field field) {
        return "X";
    }

}
