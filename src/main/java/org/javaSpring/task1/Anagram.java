package org.javaSpring.task1;

import java.util.*;
import java.util.function.*;

public class Anagram implements Function<String, String> {

    public static final String DELIMITER = " ";

    @Override
    public String apply(String s) {
        String[] stringSeparatedByDelimiter = s.split(DELIMITER);

        StringJoiner reverseSL = new StringJoiner(" ");
        for (String word: stringSeparatedByDelimiter) {
            reverseSL.add(someLogic(word));
        }
        return reverseSL.toString();
    }

    private String reverseWord(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    private String getOnlyLetters(String word){
        StringBuilder sb = new StringBuilder();
        char[] reversWordCharArr = word.toCharArray();

        for (int x = 0; x < reversWordCharArr.length; x++) {
            if (Character.isLetter(reversWordCharArr[x])){
                sb.append(reversWordCharArr[x]);
            }
        }
        return sb.toString();
    }

    private String someLogic(String word) {
        StringBuilder sb = new StringBuilder();
        char[] wordCharsArr = word.toCharArray();
        char[] reversCharsArr = getOnlyLetters(reverseWord(word)).toCharArray();
        int indexOfReversLetter = 0;

        for(int x = 0; x < wordCharsArr.length; x++){
            if (!Character.isLetter(wordCharsArr[x])){
                //add only NOT letters
                sb.append(wordCharsArr[x]);
            } else {
                //add only letters
                sb.append(reversCharsArr[indexOfReversLetter]);
                indexOfReversLetter++;
            }
        }
        return sb.toString();
    }
}
