package com.tebr.anagrams;

import static org.junit.jupiter.api.Assertions.*;

class AnagrammTest {
    private final Anagramm anagramm = new Anagramm("a123b c4d5t6f7");

    @org.junit.jupiter.api.Test
    void reversed() {
        assertEquals(anagramm.reversed(), "b123a f4t5d6c7");
    }
}