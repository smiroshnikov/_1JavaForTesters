package playground1.experimentMAR17.battle_board;

/**
 * Created by miross1 on 3/23/2017.
 * HATE Tic tac toe !
 */
public class Scuko {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("");

            for (int j = 0; j < 3; j++) {

                //region Horizontal check
//                switch (i) {
//                    case 0: {
//                        System.out.print("*");
//                        break;
//                    }
//                    case 1: {
//                        System.out.print("#");
//                        break;
//                    }
//                    case 2: {
//                        System.out.print("@");
//                        break;
//                    }
//                }
                //endregion

                //region Vertical check
//                switch (j) {
//                    case 0: {
//                        System.out.print("\t%\t");
//                        break;
//                    }
//                    case 1: {
//                        System.out.print("\t^\t");
//                        break;
//                    }
//                    case 2: {
//                        System.out.print("\t&\t");
//                        break;
//                    }
//                }
                //endregion

                if (i == j) {
                    // normal diagonal
                    System.out.print("\t*");
                } else if ((2 - i) == j) {
                    // reverted diagonal
                    System.out.print("\t#");
                } else {
                    //NON DIAGONAL CHARACTERS!
                    System.out.print("\t" + i);
                }
            }
        }
    }
}