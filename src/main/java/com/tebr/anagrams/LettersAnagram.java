package com.tebr.anagrams;

import java.util.*;

public class LettersAnagram implements ReversibleString {
    private static final String DELIMITER = " ";
    private final String inputText;

    public LettersAnagram(String text) {
        this.inputText = text;
    }

    @Override
    public String reverse() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String word : inputText.split(DELIMITER)) {
            stringJoiner.add(reverseWord(word));
        }
        return stringJoiner.toString()+searchEndSpaces();
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

    private String searchEndSpaces() {
        StringBuilder spaces = new StringBuilder();

        int count = inputText.length() - 1;
        while ((count != -1) && (inputText.charAt(count) == ' ')) {
            spaces.append(' ');
            count--;
        }
        return spaces.toString();
    }
}
