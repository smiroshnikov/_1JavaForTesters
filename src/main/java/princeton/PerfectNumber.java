package princeton;

/**
 * Created by miross1 on 3/13/2017.
 * Perfect number calcul,ation from Princeton Java course
 */
public class PerfectNumber {
    public static void main(String[] args) {

        long divisor = 6;

        int divisor2 = (int) Math.sqrt((double) divisor);
        for (long n = 1; true; n += divisor2) {
            long sum = 0;
            for (long i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    System.out.printf("the sum of divisors %d is %d %n", divisor, sum);

                    if (sum == 0) {
                        break;
                    }
                }
            }
        }

    }
}
