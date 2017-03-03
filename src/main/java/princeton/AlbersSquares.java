package princeton;


import java.awt.Color;

public class AlbersSquares {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(800, 800);

        // first color
        int r1 = Integer.parseInt("9");
        int g1 = Integer.parseInt("90");
        int b1 = Integer.parseInt("166");
        Color c1 = new Color(r1, g1, b1);

        // second color
        int r2 = Integer.parseInt("100");
        int g2 = Integer.parseInt("100");
        int b2 = Integer.parseInt("100");
        Color c2 = new Color(r2, g2, b2);

        // first Albers square
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(0.25, 0.5, 0.2);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(0.25, 0.5, 0.1);

        // second Albers square
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(0.75, 0.5, 0.2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(0.75, 0.5, 0.1);
    }
}
