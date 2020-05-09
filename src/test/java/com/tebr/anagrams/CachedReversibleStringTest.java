package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CachedReversibleStringTest {
    @Mock
    private LettersAnagram lettersAnagram;

    @Test
    void reverse_shouldCallReverseOneTime_whenCallReverseTwoTimes() {
        CachedReversibleString cachedReversibleString =
                new CachedReversibleString(lettersAnagram);

        cachedReversibleString.reverse();
        cachedReversibleString.reverse();

        verify(lettersAnagram).reverse();
    }

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
