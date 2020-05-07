package com.tebr.anagrams;

public class CachedReversibleString implements ReversibleString {
    private final ReversibleString textForReverse;
    private String anagram;

    public CachedReversibleString(ReversibleString textForReverse) {
        this.textForReverse = textForReverse;
    }

    @Override
    public String reverse() {
        if (anagram == null) {
            anagram = textForReverse.reverse();
        }
        return anagram;
    }
}
