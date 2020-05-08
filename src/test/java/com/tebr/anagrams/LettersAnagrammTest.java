package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LettersAnagrammTest {
    private LettersAnagram anagram;

    @Test
    void reversed_ReverseEmptyText_ReturnEmptyText() {
        anagram = new LettersAnagram("");
        String expectedResult = "";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_ReverseNull_ThrowsNullPointerException() {
        anagram = new LettersAnagram(null);

        assertThrows(NullPointerException.class, anagram::reverse);
    }

    @ParameterizedTest
    @CsvSource({
            "a123b c4d5t6f7, b123a f4t5d6c7",
            "qwerty, ytrewq",
            "123 321, 123 321"
    })
    void reversed_ReverseParamText_ReturnReversedText(
            String inputText,
            String expectedResult
    ) {
        anagram = new LettersAnagram(inputText);

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_ReverseBeginFromSpaceText_ReturnReverseBeginFromSpaceText() {
        anagram = new LettersAnagram(" asd");
        String expectedResult = " dsa";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_ReverseOnlySpacesText_ReturnOnlySpacesText() {
        anagram = new LettersAnagram("   ");
        String expectedResult = "   ";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_ReverseSpaceInTheEndText_ReturnReverseTextWithSpaceInTheEnd() {
        anagram = new LettersAnagram("asd ");
        String expectedResult = "dsa ";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }


}
