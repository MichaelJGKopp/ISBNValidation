package com.example;

public class ValidateISBN {

  public boolean checkISBN(String isbn) {

    int result = 0;
    isbn = isbn.trim().replace("-", "");
    for (int i = isbn.length() - 1; i > -1; i--) {
      result += isbn.charAt(i) * (isbn.length() - i);
    }
    return result % 11 == 0;
  }

  public boolean checkISBN13(String isbn) {

    isbn = isbn.trim().replace("-", "");

    if (!isbn.matches("\\d{13}")) {
      throw new NumberFormatException("Not a valid ISBN13 format.");
    }

    int result = 0;
    for (int i = isbn.length() - 1; i > -1; i--) {
      result += isbn.charAt(i) * ((i - isbn.length()) % 2 == 0 ? 3 : 1);
    }
    return result % 10 == 0;
  }

}
