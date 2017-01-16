package playground1;

import java.util.ArrayList;
import java.util.List;

public class StringUtilityHelpers {
    public static List<Integer> letterOccurrences(String full, String letter) {
        List<Integer> occurrences = new ArrayList<>();
        for (int i = 0; i < full.length(); i++) {
            if (full.indexOf(letter, i) != -1) {
                i = full.indexOf(letter, i);
                occurrences.add(i);
            }
        }
        return occurrences;
    }

    public static List<Integer> letterOccurrencesReverse(String full, String letter) {
        List<Integer> occurrences = new ArrayList<>();
        for (int i = full.length(); i >= 0; i--) {
            if (full.lastIndexOf(letter, i) != -1) {
                i = full.lastIndexOf(letter, i);
                occurrences.add(i);
            }
        }
        return occurrences;
    }

    public static void printList(List<Integer> whatever) {
        for (int e :
                whatever) {
            System.out.println(e);
        }
    }
}
