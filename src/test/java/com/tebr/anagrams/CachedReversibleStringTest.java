package com.tebr.anagrams;

import org.junit.jupiter.api.BeforeEach;
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

    private CachedReversibleString cachedReversibleString;

    @Mock
    private LettersAnagram mockLettersAnagram;

    @BeforeEach
    public void setUp() {
        when(mockLettersAnagram.reverse()).thenReturn(RESULT);
        cachedReversibleString = new CachedReversibleString(mockLettersAnagram);
    }

    @Test
    void reverse_shouldCallReverseOneTime_whenCallReverseOneMoreTimes() {
        cachedReversibleString.reverse();
        cachedReversibleString.reverse();
        cachedReversibleString.reverse();

        verify(mockLettersAnagram).reverse();
    }

    @Test
    void reverse_shouldNotAffectTheResultCachedReversibleString() {
        String expectedResult = mockLettersAnagram.reverse();

        String result = cachedReversibleString.reverse();

        assertEquals(expectedResult, result);
    }
}
