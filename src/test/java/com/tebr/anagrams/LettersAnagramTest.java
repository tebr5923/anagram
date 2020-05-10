package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LettersAnagramTest {
    @Test
    void reverse_shouldReturnEmptyString_whenTextIsEmpty() {
        LettersAnagram anagram = new LettersAnagram("");
        String expectedResult = "";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reverse_shouldThrowIllegalArgumentException_whenArgumentIsNull() {
        assertThrows(IllegalArgumentException.class,  () -> new LettersAnagram(null));
    }

    @ParameterizedTest
    @CsvSource({
            "a123b c4d5t6f7, b123a f4t5d6c7",
            "qwerty, ytrewq",
            "123 321, 123 321"
    })
    void reverse_shouldReturnReversedString_whenTextIsRandom(
            String inputText,
            String expectedResult
    ) {
        LettersAnagram anagram = new LettersAnagram(inputText);

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reverse_shouldPreserveSpace_whenLeadingSpaceGiven() {
        LettersAnagram anagram = new LettersAnagram(" asd");
        String expectedResult = " dsa";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reverse_shouldPreserveSpaces_whenOnlySpacesGiven() {
        LettersAnagram anagram = new LettersAnagram("   ");
        String expectedResult = "   ";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reverse_shouldPreserveSpaces_whenTrailingSpacesGiven() {
        LettersAnagram anagram = new LettersAnagram("asd  ");
        String expectedResult = "dsa  ";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reverse_shouldPreserveSpaces_whenConsequentSpacesBetweenWordsGiven() {
        LettersAnagram anagram = new LettersAnagram("asd   123q");
        String expectedResult = "dsa   123q";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }
}
