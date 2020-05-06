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
        String miss = " ";
        StringJoiner stringJoiner = new StringJoiner(miss);
        for (String shortAnagramm : anagramm.split(DELIMITER)) {
            stringJoiner.add(doReverse(shortAnagramm));
        }
        return stringJoiner.toString();
    }

    private String doReverse(String shortAnagramm) {
        StringBuilder letters = new StringBuilder();
        int length = shortAnagramm.length();
        char[] notLetters = new char[length];

        int count = 0;
        for (char ch : shortAnagramm.toCharArray()) {
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
