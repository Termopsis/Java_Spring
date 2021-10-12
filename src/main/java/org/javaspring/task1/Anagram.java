package org.javaspring.task1;

import java.util.*;
import java.util.function.*;

public class Anagram implements Function<String, String> {

    public static final String DELIMITER = " ";

    @Override
    public String apply(String s) {
        String[] words = s.split(DELIMITER);

        StringJoiner result = new StringJoiner(" ");
        for (String word : words) {
            result.add(someLogic(word));
        }
        return result.toString();
    }

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    private String filterLetters(String word) {
        StringBuilder sb = new StringBuilder();
        char[] reversWordCharArr = word.toCharArray();

        for (int x = 0; x < reversWordCharArr.length; x++) {
            if (Character.isLetter(reversWordCharArr[x])) {
                sb.append(reversWordCharArr[x]);
            }
        }
        return sb.toString();
    }

    //reverse all the words of input word
    //All non-letter symbols stay on the same places
    private String someLogic(String word) {
        StringBuilder sb = new StringBuilder();
        char[] originalChars = word.toCharArray();
        char[] reverslettersOnly = filterLetters(reverse(word)).toCharArray();
        int indexOfReversLetter = 0;

        for (int x = 0; x < originalChars.length; x++) {
            if (!Character.isLetter(originalChars[x])) {
                // add only NOT letters
                sb.append(originalChars[x]);
            } else {
                // add only letters
                sb.append(reverslettersOnly[indexOfReversLetter]);
                indexOfReversLetter++;
            }
        }
        return sb.toString();
    }
}
