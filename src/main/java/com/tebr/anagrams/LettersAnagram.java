package com.tebr.anagrams;

import java.util.LinkedList;
import java.util.StringJoiner;

public class LettersAnagram implements ReversibleString {
    private static final String DELIMITER = " ";
    private final String inputText;

    public LettersAnagram(String text) {
        this.inputText = text;
    }

    @Override
    public String reverse() {
        if (inputText == null) {
            throw new IllegalStateException("null can't be reversed");
        }
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String word : inputText.split(DELIMITER, -1)) {
            stringJoiner.add(reverseWord(word));
        }
        return stringJoiner.toString();
    }

    private String reverseWord(String word) {
        LinkedList<Character>  letters = collectLetters(word);
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = letters.pop();
            }
        }
        return new String(chars);
    }

    private LinkedList<Character> collectLetters(String word) {
        LinkedList<Character>  letters = new LinkedList<>();
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            }
        }
        return letters;
    }
}
