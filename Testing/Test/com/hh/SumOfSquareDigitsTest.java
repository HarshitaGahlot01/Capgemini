package com.hh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.Test;

class SumOfSquareDigitsTest {

	@ParameterizedTest
    @CsvSource({
        "19, -1",
        "7, -1",
        "4, 8",
        "10, -1",
        "16, 8",
        "1,  1"
    })
    void testFindCount(int input, int expected) {

        int result = Sumofsquaredigits.findCount(input);

        assertEquals(expected, result);
    }
}