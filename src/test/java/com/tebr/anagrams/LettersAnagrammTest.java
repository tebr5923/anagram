package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LettersAnagrammTest {

    @Test
    void reversed_ReverseEmptyText_ReturnEmptyText() {
        LettersAnagram anagram = new LettersAnagram("");
        String expectedResult = "";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_ReverseNull_ThrowsNullPointerException() {
        LettersAnagram anagram = new LettersAnagram(null);

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
        LettersAnagram anagram = new LettersAnagram(inputText);

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_IfInputTextWithLeading_ReturnTextWithLeading() {
        LettersAnagram anagram = new LettersAnagram(" asd");
        String expectedResult = " dsa";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_ReverseOnlySpaces_ReturnOnlySpaces() {
        LettersAnagram anagram = new LettersAnagram("   ");
        String expectedResult = "   ";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_IfInputTextWithTrailing_ReturnTextWithTrailing() {
        LettersAnagram anagram = new LettersAnagram("asd  ");
        String expectedResult = "dsa  ";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }

    @Test
    void reversed_InputTextWithSeveralSpacesInRow_ReturnTextWithSeveralSpacesInRow() {
        LettersAnagram anagram = new LettersAnagram("asd   123q");
        String expectedResult = "dsa   123q";

        String result = anagram.reverse();

        assertEquals(expectedResult, result);
    }
}
