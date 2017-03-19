package playground1.experimentMAR17.warmup;

/**
 * Created by Iidwuurliik on 3/19/2017.
 */
public class SolverXO {
    private static String[][] field = new String[][]{{"A", "B", "C"}, {"A", "B", "C"}, {"A", "B", "C"}};


    public static void main(String[] args) {
        String desiredFigure = "A";
        for (String[] line : field) {
            //System.out.println(line[0]);
            for (String value : line) {
                //  System.out.println(value);
                if (value.equals(desiredFigure)) {
                    System.out.println("Match!");
                }

            }

        }

    }
}
