package com.tebr.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagrammTest {

    @org.junit.jupiter.api.Test
    void reversed_ReverseTheText_True() {
        Anagramm anagramm = new Anagramm("a123b c4d5t6f7");
        String expResult = "b123a f4t5d6c7";

        String result = anagramm.reversed();

        assertEquals(expResult, result);
    }
}
