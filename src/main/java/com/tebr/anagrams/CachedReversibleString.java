package com.tebr.anagrams;

public class CachedReversibleString implements ReversibleString {
    private final ReversibleString anagram;
    private String result;

    public CachedReversibleString(ReversibleString anagram) {
        this.anagram = anagram;
    }

    @Override
    public String reverse() {
        if (result == null) {
            result = anagram.reverse();
        }
        return result;
    }
}
