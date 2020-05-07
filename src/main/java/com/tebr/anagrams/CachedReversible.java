package com.tebr.anagrams;

public class CachedReversible implements Reversible{
    private final Reversible anagramm;
    private String result;

    public CachedReversible(Reversible anagramm) {
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
