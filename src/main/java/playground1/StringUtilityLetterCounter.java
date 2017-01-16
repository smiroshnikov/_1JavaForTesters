package playground1;

import java.util.ArrayList;
import java.util.List;

public class StringUtilityLetterCounter {
    public static List<Integer> returnNumberOfOccurrences(String full, String letter) {
        List<Integer> occurrences = new ArrayList<>();
        for (int i = 0; i < full.length(); i++) {
            if (full.indexOf(letter, i) != -1) {
                i = full.indexOf(letter, i);
                occurrences.add(i);
            }
        }
        return occurrences;
    }
}
