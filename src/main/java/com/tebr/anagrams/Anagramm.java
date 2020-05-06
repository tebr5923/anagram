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
        StringBuilder letters = new StringBuilder();
        int length = word.length();
        char[] notLetters = new char[length];

        int count = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.append(ch);
                notLetters[count] = ' ';
            } else {
                notLetters[count] = ch;
            }
            count++;
        }
        letters.reverse();

        List<Character> listLetters = new ArrayList<>();
        for (char ch : letters.toString().toCharArray()) {
            listLetters.add(ch);
        }

        Iterator<Character> iterator = listLetters.iterator();
        for (int i = 0; i < length; i++) {
            if (notLetters[i] == ' ') {
                notLetters[i] = iterator.next();
            }
        }
        return new String(notLetters);
    }

}
