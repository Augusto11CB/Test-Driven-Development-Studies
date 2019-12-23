package com.isbn.calculator;

public class ValidateISBN {

    public static final int SHORT_LENGTH_ISBN = 10;
    public static final int LONG_LENGTH_ISBN = 13;

    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;


    public boolean checkISBN(String isbn) {

        if (isbn.length() == LONG_LENGTH_ISBN) {
            return is13DigitsAValidISBN(isbn);

        } else if (isbn.length() == SHORT_LENGTH_ISBN) {
            return is10DigitsAValidISBN(isbn);

        } else {
            throw new NumberFormatException("The informed ISBN is not valid - Its length is less than 10 Digits");
        }
    }

    public boolean is10DigitsAValidISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < isbn.length(); i++) {

            if (!Character.isDigit(isbn.charAt(i))) {

                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("The informed ISBN is not valid - Non-numeric values are not allowed");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_LENGTH_ISBN - i);
            }
        }
        return (total % SHORT_ISBN_MULTIPLIER) == 0;
    }

    public boolean is13DigitsAValidISBN(String isbn) {
        int total = 0;

        for (int i = 0; i < isbn.length(); i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return (total % LONG_ISBN_MULTIPLIER) == 0;
    }

}
