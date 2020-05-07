package com.tebr.anagrams;

public class CachedReversibleString implements ReversibleString {
    private final ReversibleString reversibleString;
    private String anagram;

    public CachedReversibleString(ReversibleString reversibleString) {
        this.reversibleString = reversibleString;
    }

    @Override
    public String reverse() {
        if (anagram == null) {
            anagram = reversibleString.reverse();
        }
        return anagram;
    }
}
