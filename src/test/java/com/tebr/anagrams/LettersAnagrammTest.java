package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LettersAnagrammTest {

    @Test
    void reversed_ReverseEmptyText_ReturnEmptyText() {
        LettersAnagram anagramm = new LettersAnagram("");
        String expResult = "";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @Test
    void reversed_ReverseNull_ThrowsNullPointerException() {
        LettersAnagram anagramm = new LettersAnagram(null);

        assertThrows(NullPointerException.class, anagramm::reverse);
    }

    @ParameterizedTest
    @CsvSource({
            "a123b c4d5t6f7, b123a f4t5d6c7",
            "qwerty, ytrewq",
            "123 321, 123 321"
    })
    void reversed_ReverseParamText_ReturnReversedText(
            String inputText,
            String expResult
    ) {
        LettersAnagram anagramm = new LettersAnagram(inputText);

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @Test
    void reversed_ReverseBeginFromSpaceText_ReturnReverseBeginFromSpaceText() {
        LettersAnagram anagramm = new LettersAnagram(" asd");
        String expResult = " dsa";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @Test
    void reversed_ReverseOnlySpacesText_ReturnOnlySpacesText() {
        LettersAnagram anagramm = new LettersAnagram("   ");
        String expResult = "   ";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @Test
    void reversed_ReverseSpaceInTheEndText_ReturnReverseTextWithSpaceInTheEnd() {
        LettersAnagram anagramm = new LettersAnagram("asd ");
        String expResult = "dsa ";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }


}
