package playground1;


import java.util.List;

public class MainRunner {
    public static void main(String[] args) {
        String hello = "Hello fella!";
        List<Integer> result;
        result = StringUtilityLetterCounter.returnNumberOfOccurrences(hello, "l");
        System.out.printf("String was\" %s \" letter was \"l\"\n", hello);
        for (int e :
                result) {
            System.out.println(e);
        }
        String huello = "Ahuello Zaeballo Razorvallo Evallo!";
        System.out.printf("String was \"%s \" letter was \"l\"\n", huello);
        result = StringUtilityLetterCounter.returnNumberOfOccurrences(huello, "l");
        for (int e :
                result) {
            System.out.println(e);
        }

    }
}
