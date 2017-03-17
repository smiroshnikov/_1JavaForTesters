package hexlet.XO.model;

import hexlet.module101.Figure;

/**
 * Player representation for XO
 */
public class Player {
    private final String name;
    private final Figure figure;


    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }
}
