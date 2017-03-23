package playground1.experimentMAR17.battle_board;

/**
 * Created by miross1 on 3/23/2017.
 */
public class Scuko {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("");

            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    System.out.print("*");
                } else if (i == 1) {
                    System.out.print("#");
                } else if (i == 2) {
                    System.out.print("@");
                }


//                if (i == j) {
//                    // normal diagonal
//                    System.out.print("\t*");
//                } else if ((2 - i) == j) {
//                    // reverted diagonal
//                    System.out.print("\t#");
//                } else {
                // everything else
//                System.out.print("\t" + i);
            }

        }
    }
}
