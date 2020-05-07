package com.tebr.anagrams;

public class CachedAnagramm implements Reversible{
    private final Anagramm anagramm;
    private String result;

    public CachedAnagramm(Anagramm anagramm) {
        this.anagramm = anagramm;
    }

    @Override
    public String reversed() {
        if (result == null) {
            result = anagramm.reversed();
        }
        return result;
    }
}
