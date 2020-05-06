package com.tebr.anagrams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

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
        char[] letters = reverseLetters(word);
        List<Character> listLetters = new ArrayList<>();

        for (char ch : letters) {
            listLetters.add(ch);
        }

        char[] notLetters = word.toCharArray();
        Iterator<Character> iterator = listLetters.iterator();
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(notLetters[i])) {
                notLetters[i] = iterator.next();
            }
        }
        return new String(notLetters);
    }

    private char[] reverseLetters(String word) {
        StringBuilder letters = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.append(ch);
            }
        }
        letters.reverse();
        return letters.toString().toCharArray();
    }
}
