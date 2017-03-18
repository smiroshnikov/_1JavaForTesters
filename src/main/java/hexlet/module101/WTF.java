package hexlet.module101;

/**
 * Created by Iidwuurliik on 3/18/2017.
 * specially created class for the WTF moments
 * when i disagree with HW answers
 */
public class WTF {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i = i + 1) {
            switch (i) {
                case 0:
                case 1:
                    continue;
                default:
                    break;
            }
            System.out.print(i);
        }
    }

}
