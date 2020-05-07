package com.tebr.anagrams;

public class CachedReversibleString implements ReversibleString {
    private final ReversibleString anagramm;
    private String result;

    public CachedReversibleString(ReversibleString anagramm) {
        this.anagramm = anagramm;
    }

    @Override
    public String reverse() {
        if (result == null) {
            result = anagramm.reverse();
        }
        return result;
    }
}
