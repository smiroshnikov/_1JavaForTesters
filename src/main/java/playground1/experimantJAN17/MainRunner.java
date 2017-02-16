package playground1.experimantJAN17;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainRunner {

    //TODO this is a candidate for QA interview
    /* Write a method, which takes a String and a substring as parameters
    and returns a List<Integer> where each Integer is the location of the
    substring in the String.*/


    public static void main(String[] args) {
        String hello = "Hello fella!";
        List<Integer> result;
        result = StringUtilityHelpers.letterOccurrences(hello, "l");
        System.out.printf("String was\" %s \" letter was \"l\"\n", hello);
        StringUtilityHelpers.printList(result);
        String huello = "Ahuello Zaeballo Razorvallo Evallo!";
        System.out.printf("String was \"%s \" letter was \"l\"\n", huello);
        result = StringUtilityHelpers.letterOccurrences(huello, "l");
        StringUtilityHelpers.printList(result);
        String zaeballo = "zzzzaeballi zveri zaebovivuvat1";
        result = StringUtilityHelpers.letterOccurrences(zaeballo, "z");
        StringUtilityHelpers.printList(result);
        System.out.printf("========================\n");
        result = StringUtilityHelpers.letterOccurrencesReverse(zaeballo, "z");
        StringUtilityHelpers.printList(result);
        System.out.printf("========================\n");
        result = StringUtilityHelpers.letterOccurrencesReverse(huello, "k");
        StringUtilityHelpers.printList(result);
        assertThat(result.isEmpty(), is(true));


    }
}
