package com.isbn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidateISBNTest {

    private ValidateISBN validator;

    @BeforeEach
    public void init() {
        validator = new ValidateISBN();
    }

    @Test
    void checkInvalid10DigitsISBN() {

        boolean result = validator.checkISBN("0134494161");
        assertFalse(result);
    }

    @Test
    public void checkAValid10DigitsISBN() {

        boolean result = validator.checkISBN("0135781868");
        assertTrue(result, "First   Value");

        result = validator.checkISBN("0134494164");
        assertTrue(result, "Second Value");
    }

    @Test
    void checkAValid13DigitsISBN() {

        boolean result = validator.checkISBN("9780134494166");
        assertTrue(result);
    }


    @Test
    void checkInvalid13DigitsISBN() {

        boolean result = validator.checkISBN("1111111111111");
        assertFalse(result);
    }

    @Test
    void lessThan10Digits() {
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("134494164"));
    }

    @Test
    void nonNumericISBNIsNotAllowed() {
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("helloworld"));
    }

    @Test
    void ISBNNumberEndingInAnXisValid() {
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }
}
