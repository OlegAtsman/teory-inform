package com.univer.teory;

/**
 * –азложение натурального числа на простые множители.
 */
public class Factorization {

  /**
   * @param args - исходное натуральное число.
   */
  public static void main(String[] args) {
    // »сходное натуральное число
    int n = Integer.parseInt(args[0]);
    int factor = 2;
    System.out.format("–аскладываем %d на простые множители:", n);
    while (n > 1 && factor * factor <= n) {
      while (n % factor == 0) {
        System.out.format(" %d,", factor);
        n /= factor;
      }
      ++factor;
    }
    if (n > 1) {
      System.out.format(" %d", n);
    }
    System.out.println();
  }

}
