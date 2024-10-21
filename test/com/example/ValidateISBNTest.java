package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

  @Test
  public void checkAValid10DigitISBN() {
//    fail();
    ValidateISBN validateISBN = new ValidateISBN();
    boolean result = validateISBN.checkISBN("0061964360"); // ISBN 1
    assertTrue(result, "first valid ISBN");

    result = validateISBN.checkISBN("0198534531"); // ISBN 2
    assertTrue(result, "2nd valid ISBN");
  }

  @Test
  public void checkA10DigitInValidISBN() {

    ValidateISBN validateISBN = new ValidateISBN();
    boolean  result = validateISBN.checkISBN("1234567890"); // random, assume to be false
    assertFalse(result, "first invalid ISBN");
  }

  @Test
  public void checkAValid13DigitISBN() {

    ValidateISBN validateISBN = new ValidateISBN();

    boolean result = validateISBN.checkISBN13("978-3-16-148410-0"); // ISBN 1
    assertTrue(result, "first valid ISBN");

    result = validateISBN.checkISBN13("978-3-911408-00-4"); // ISBN 2
    assertTrue(result, "2nd valid ISBN");

    result = validateISBN.checkISBN13("978-1786892737"); // ISBN 3
    assertTrue(result, "3rd valid ISBN");
  }

  public void checkA13DigitInValidISBN() {

    ValidateISBN validateISBN = new ValidateISBN();

    boolean result = validateISBN.checkISBN13("0123456789123"); // random, assume to be false
    assertFalse(result, "first invalid ISBN");
  }

  @Test
  public void nonNumericISBNIsNotAllowed() {

    ValidateISBN validateISBN = new ValidateISBN();

    Exception exception = assertThrows(NumberFormatException.class, () -> {
      validateISBN.checkISBN13("hello world");
    });

    String expectedMessage = "Not a valid ISBN13 format.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
