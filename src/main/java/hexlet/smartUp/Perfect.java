package hexlet.smartUp;

/**
 * Created by Iidwuurliik on 3/13/2017.
 */

public class Perfect {

    public static void main(String[] args) {
        //int x = Integer.parseInt(args[0]);
        int x = 234;

        for (long n = 1; true; n = n + x) {
            long sum = 0;
            for (long i = 1; i < n; i++)
                if (n % i == 0) sum = sum + i;
            System.out.println("The sum of the divisors of " + n + " is " + sum);
            if (sum == n) break;
        }
    }
}