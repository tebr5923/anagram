package com.tebr.anagrams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CachedReversibleStringTest {
    private static final String RESULT = "123";

    @Mock
    private LettersAnagram mockLettersAnagram;

    @Test
    void reverse_shouldCallReverseOneTime_whenCallReverseOneMoreTimes() {
        when(mockLettersAnagram.reverse()).thenReturn(RESULT);
        CachedReversibleString cachedReversibleString =
                new CachedReversibleString(mockLettersAnagram);

        cachedReversibleString.reverse();
        cachedReversibleString.reverse();
        cachedReversibleString.reverse();

        verify(mockLettersAnagram).reverse();
    }

    @Test
    void reverse_LettersAnagramReverseAndCachedReversibleStringReverseIsEquals_ReturnTrue() {
        when(mockLettersAnagram.reverse()).thenReturn(RESULT);
        String expectedResult = mockLettersAnagram.reverse();

        CachedReversibleString cachedReversibleString =
                new CachedReversibleString(mockLettersAnagram);
        String result = cachedReversibleString.reverse();

        assertEquals(expectedResult, result);
    }
}
