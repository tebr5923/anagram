package com.tebr.anagrams;

import java.util.*;

public class Anagramm {
    private final String anagramm;
    private static final String DELIMITER = " ";

    public Anagramm(String anagramm) {
        this.anagramm = anagramm;
    }

    public String reversed() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String word : anagramm.split(DELIMITER)) {
            stringJoiner.add(reverseWord(word));
        }
        return stringJoiner.toString();
    }

    private String reverseWord(String word) {
        int length = word.length();
        Stack<Character> letters = reverseLetters(word);

        char[] chars = word.toCharArray();
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = letters.pop();
            }
        }
        return new String(chars);
    }

    private Stack<Character> reverseLetters(String word) {
        Stack<Character> letters = new Stack<>();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            }
        }
        return letters;
    }
}
