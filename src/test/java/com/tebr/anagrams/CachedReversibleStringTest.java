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

    private CachedReversibleString cachedReversibleString;

    @Mock
    private ReversibleString mockReversibleString;

    @BeforeEach
    public void setUp() {
        final String result = "123";
        when(mockReversibleString.reverse()).thenReturn(result);
        cachedReversibleString = new CachedReversibleString(mockReversibleString);
    }

    @Test
    void reverse_shouldReturnCachedResult_whenCalledMultipleTimes() {
        cachedReversibleString.reverse();
        cachedReversibleString.reverse();
        cachedReversibleString.reverse();

        verify(mockReversibleString).reverse();
    }

    @Test
    void reverse_shouldNotAffectTheResultCachedReversibleString() {
        String expectedResult = mockReversibleString.reverse();

        String result = cachedReversibleString.reverse();

        assertEquals(expectedResult, result);
    }
}
