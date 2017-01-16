package playground1;


import java.util.List;

public class MainRunner {
    public static void main(String[] args) {
        String hello = "Hello fella!";
        List<Integer> result;
        result = StringUtilityHelpers.returnNumberOfOccurrences(hello, "l");
        System.out.printf("String was\" %s \" letter was \"l\"\n", hello);
        StringUtilityHelpers.printList(result);
        String huello = "Ahuello Zaeballo Razorvallo Evallo!";
        System.out.printf("String was \"%s \" letter was \"l\"\n", huello);
        result = StringUtilityHelpers.returnNumberOfOccurrences(huello, "l");
        StringUtilityHelpers.printList(result);
        String zaeballo = "zzzzaeballi zveri zaebovivuvat1";
        result = StringUtilityHelpers.returnNumberOfOccurrences(zaeballo, "z");
        StringUtilityHelpers.printList(result);
        System.out.printf("========================\n");
        result = StringUtilityHelpers.returnNumberOfOccInReverse(zaeballo, "z");
        StringUtilityHelpers.printList(result);


    }
}
