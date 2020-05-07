package com.tebr.anagrams;

public class CachedReversibleString implements ReversibleString {
    private final ReversibleString reversibleString;
    private String result;

    public CachedReversibleString(ReversibleString reversibleString) {
        this.reversibleString = reversibleString;
    }

    @Override
    public String reverse() {
        if (result == null) {
            result = reversibleString.reverse();
        }
        return result;
    }
}
