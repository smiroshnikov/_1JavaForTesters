package Selenium_WebDriver_ARichardson.exploration.minus2;

/**
 * Should be used when I want to represent a fixed set of constants
 * Days of the week , Directions , Rank and Suit of a card ....
 * predefinedlimited amount of possible values
 */

public class EnumTest {
    public enum Direction {NORTH, SOUTH, EAST, WEST}

    public enum Season {WINTER, SPRING, SUMMER, FALL}

    public enum PlayerKeys {UP, DOWN, LEFT, RIGHT}

    public enum Color {
        RED(100, 222, 131), BLUE(12, 221, 2), YELLOW(12, 223, 189), WHITE(255, 255, 255); // adding ";" after constants allows us to add additional fields
        // e.g lets add RGB components  for each color

        private int red;
        private int green;
        private int blue;

        // enum constructors can be private or pakage private only
        private Color(int r, int g, int b) {
            red = r;
            green = g;
            blue = b;
        }

        // a method within enum , so fucking cool !
        @Override
        public String toString() {
            String constName = super.toString();
            return constName.substring(0, 1) + constName.substring(1, super.toString().length()).toLowerCase();

        }

        // I need to create a public method to access from the outside that will represent my color RGB value
        public String gimmeRGB() {
            return String.format(" (%d, %d, %d)", red, green, blue);
        }

    }

    /*
    public can access from a different class
    staticQuestions means to be called on a type e.g System.getProperty() is called on a type without instantiating a class
    final means constant
     */


    public static void main(String[] args) {
        Direction currentDirection = Direction.NORTH;
        Season currentSeason = Season.SUMMER;
        for (PlayerKeys key :
                PlayerKeys.values()) {
            //System.out.println(key.toString());
            System.out.printf("%s %n", key);
        }
        Color myColor = Color.BLUE;
        System.out.printf("%s %s%n", myColor, myColor.gimmeRGB());
    }
}
