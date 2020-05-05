package com.tebr.anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagramm {
    private String anagramm;

    public Anagramm() {
    }

    public Anagramm(String anagramm) {
        this.anagramm = anagramm;
    }

    public String reverse() {
        List<String> anagrams = splitAnagramm();
        StringBuilder result = new StringBuilder();

        int count = 0;
        for (String splitAnagramm : anagrams) {
            if (count != 0) {
                result.append(' ');
            }
            result.append(reversOne(splitAnagramm));
            count++;
        }

        return result.toString();
    }

    public String getAnagramm() {
        return anagramm;
    }

    public void setAnagramm(String anagramm) {
        this.anagramm = anagramm;
    }

    private List<String> splitAnagramm() {
        List<String> anagrams = new ArrayList<String>();

        Collections.addAll(anagrams, anagramm.split(" "));

        return anagrams;
    }

    private String reversOne(String splitAnagramm) {
        StringBuilder result = new StringBuilder(splitAnagramm);
        StringBuilder sb=new StringBuilder();

        result.reverse();

        return result.toString();
    }
}
