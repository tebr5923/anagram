package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CachedReversibleStringTest {

    @Spy
    private final LettersAnagram mockLettersAnagram=new LettersAnagram("test");

    @Test
    void reverse_shouldCallReverseOneTime_whenCallReverseOneMoreTimes() {
        CachedReversibleString cachedReversibleString =
                new CachedReversibleString(mockLettersAnagram);

        cachedReversibleString.reverse();
        cachedReversibleString.reverse();
        cachedReversibleString.reverse();

        verify(mockLettersAnagram).reverse();
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
