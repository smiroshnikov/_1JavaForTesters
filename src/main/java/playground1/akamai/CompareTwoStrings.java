package playground1.akamai;

import java.util.HashSet;

/**
 * From Interview
 * Provided 2 strings of unknoiwn length please find common characters
 */

public class CompareTwoStrings {
    public static void main(String[] args) {
        String s1 = "abcdefghijk";
        String s2 = "azxtyukj";
        HashSet<Character> h1 = new HashSet<Character>();
        HashSet<Character> h2 = new HashSet<Character>();
        for (char c :
                s1.toCharArray()) {
            h1.add(c);
        }
        for (char c :
                s2.toCharArray()) {
            h2.add(c);
        }
        h1.retainAll(h2);
        for (char c :
                h1) {
            System.out.print(c);
        }
    }


}
