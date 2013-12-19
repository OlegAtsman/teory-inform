package com.univer.teory;

/**
 * ���������� ������������ ����� �� ������� ���������.
 */
public class Factorization {

  /**
   * @param args - �������� ����������� �����.
   */
  public static void main(String[] args) {
    // �������� ����������� �����
    int n = Integer.parseInt(args[0]);
    int factor = 2;
    System.out.format("������������ %d �� ������� ���������:", n);
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
