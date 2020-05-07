package com.tebr.anagrams;

public class CashedAnagramm {
    private String text;
    private String anagramm;

    public CashedAnagramm(String text) {
        this.text = text;
    }

    public String getAnagramm() {
        if (anagramm == null) {
            anagramm = new Anagramm(text).reversed();
        }
        return anagramm;
    }
}
