package playground1;

public class OnlineJudge1 {
    public static void main(String[] args) {
        int number = 22;
        while (number != 1) {
            System.out.println(number);
            if (number % 2 != 0) {
                number = 3 * number + 1;
            } else
                number /= 2;
        }
    }
}

