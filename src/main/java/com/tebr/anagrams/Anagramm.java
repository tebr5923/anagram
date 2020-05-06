package com.tebr.anagrams;

import java.util.*;

public class Anagramm {
    private String anagramm;

    public Anagramm() {
    }

    public Anagramm(String anagramm) {
        this.anagramm = anagramm;
    }

    public String reverse() {
        String[] anagrams = anagramm.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String splitAnagramm : anagrams) {
            stringJoiner.add(reversOne(splitAnagramm));
        }
        return stringJoiner.toString();
    }

    public String getAnagramm() {
        return anagramm;
    }

    public void setAnagramm(String anagramm) {
        this.anagramm = anagramm;
    }

    private String reversOne(String splitAnagramm) {
        StringBuilder sbLetters = new StringBuilder();
        int length = splitAnagramm.length();
        char[] charNotLetters = new char[length];
        int count = 0;

        for (char ch : splitAnagramm.toCharArray()) {
            if (Character.isLetter(ch)) {
                sbLetters.append(ch);
                charNotLetters[count] = ' ';
            } else {
                charNotLetters[count] = ch;
            }
            count++;
        }
        sbLetters.reverse();

        List<Character> listLetters = new ArrayList<>();
        for (char ch : sbLetters.toString().toCharArray()) {
            listLetters.add(ch);
        }

        Iterator<Character> iterator = listLetters.iterator();

        for (int i = 0; i < length; i++) {
            if (charNotLetters[i] == ' ') {
                charNotLetters[i] = iterator.next();
            }
        }
        return new String(charNotLetters);
    }
}