package com.tuf.patterns;

public class PatternFour {
  public static void main(String args[]) {
    int n = 5;
    System.out.println();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(i + 1 + " ");
      }
      System.out.println();
    }
    System.out.println();

  }
}