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
        String result;
        result=reversOne(anagramm);
        return result;
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
        StringBuilder result= new StringBuilder(splitAnagramm);
        result.reverse();
        return result.toString();
    }
}
