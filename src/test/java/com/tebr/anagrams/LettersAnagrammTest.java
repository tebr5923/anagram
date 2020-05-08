package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LettersAnagrammTest {

    @Test
    void reversed_ReverseTheText_ReturnReversedText() {
        LettersAnagram anagramm = new LettersAnagram("a123b c4d5t6f7");
        String expResult = "b123a f4t5d6c7";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @Test
    void reversed_ReverseEmptyText_ReturnEmptyText() {
        LettersAnagram anagramm = new LettersAnagram("");
        String expResult = "";

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

    @Test
    void reversed_ReverseNull_ReturnNullPointerException() {
        LettersAnagram anagramm = new LettersAnagram(null);

        assertThrows(NullPointerException.class, anagramm::reverse);
    }

    @ParameterizedTest
    @CsvSource({
            "a123b c4d5t6f7, b123a f4t5d6c7",
            "'', ''",
            "qwerty, ytrewq",
            "123 321, 123 321",
            "'    ', '    '",
            "'asd ', 'dsa '",
    })
    void reversed_ReverseParamText_ReturnReversedText(
            String inputText,
            String expResult
    ) {
        LettersAnagram anagramm = new LettersAnagram(inputText);

        String result = anagramm.reverse();

        assertEquals(expResult, result);
    }

}
