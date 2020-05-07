package com.tebr.anagrams;

import java.util.*;

public class Anagramm implements Reversible{
    private final String anagramm;
    private static final String DELIMITER = " ";

    public Anagramm(String anagramm) {
        this.anagramm = anagramm;
    }

    @Override
    public String reversed() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String word : anagramm.split(DELIMITER)) {
            stringJoiner.add(reverseWord(word));
        }
        return stringJoiner.toString();
    }

    private String reverseWord(String word) {
        Stack<Character> letters = collectLetters(word);
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = letters.pop();
            }
        }
        return new String(chars);
    }

    private Stack<Character> collectLetters(String word) {
        Stack<Character> letters = new Stack<>();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            }
        }

        return letters;
    }
}
