package com.isbn.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidateISBNTest {

    @Test
    void checkInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0134494161");

        assertFalse(result);
    }

    @Test
    public void checkValidISBN() {

        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0135781868");
        assertTrue(result, "First   Value");

        result = validator.checkISBN("0134494164");
        assertTrue(result, "Second Value");
    }
}
