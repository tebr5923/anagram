package com.tebr.anagrams;

public class CachedReversibleString implements ReversibleString {
    private final ReversibleString textForReverse;
    private String result;

    public CachedReversibleString(ReversibleString textForReverse) {
        this.textForReverse = textForReverse;
    }

    @Override
    public String reverse() {
        if (result == null) {
            result = textForReverse.reverse();
        }
        return result;
    }
}
