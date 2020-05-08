package com.tebr.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagrammTest {

    @org.junit.jupiter.api.Test
    void reversed_ReverseTheText_ReturnReversedText() {
        Anagram anagramm = new Anagram("a123b c4d5t6f7");
        String expResult = "b123a f4t5d6c7";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void reversed_ReverseEmptyText_ReturnEmptyText() {
        Anagram anagramm = new Anagram("");
        String expResult = "";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void reversed_ReverseNull_ReturnNullPointerException() {
        Anagram anagramm = new Anagram(null);

        assertThrows(NullPointerException.class, anagramm::reverse);
    }


}
