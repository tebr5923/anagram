package com.tebr.anagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CachedReversibleStringTest {

    @Test
    void reverse_LettersAnagramReverseAndCachedReversibleStringReverseIsEquals_ReturnTrue() {
        LettersAnagram lettersAnagram = new LettersAnagram("abc458 h");
        String expectedResult = lettersAnagram.reverse();

        CachedReversibleString cachedReversibleString =
                new CachedReversibleString(lettersAnagram);
        String result = cachedReversibleString.reverse();

        assertEquals(expectedResult, result);
    }
}
