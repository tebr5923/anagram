package com.tebr.anagrams;

public class CachedAnagramm {
    private final String text;
    private String anagramm;

    public CachedAnagramm(String text) {
        this.text = text;
    }

    public String getAnagramm() {
        if (anagramm == null) {
            anagramm = new Anagramm(text).reversed();
        }
        return anagramm;
    }
}
