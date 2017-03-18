package hexlet.module101;

import java.util.Scanner;

/**
 * Created by Janna on 18.03.2017.
 * Working from my mom's comp
 */

public class MenuView {


    private static final int START_CODE = 1;

    public static void main(String[] args) {
        System.out.println("1-Start");
        System.out.println("2-Load");
        System.out.println("3-Settings");
        System.out.println("4-Exit");
        System.out.print("> ");

        final Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            // break is omited on purpose so get conclusions ....
            case 1: {
                System.out.println("Unable to start FATAL_ERROR");
            }
            case 2: {
                System.out.println("Loading///");
            }
            case 3: {
                System.out.println("Settings are diasbled ");
                break;
            }
            case 4: {
                System.out.println("Exiting....");
                break;

            }
            default: {
                System.out.println("Invalid choice");
                break;
            }


        }


    }

}
