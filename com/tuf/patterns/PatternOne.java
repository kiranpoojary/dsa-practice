package com.tuf.patterns;

public class PatternOne {
  public static void main(String args[]) {
    int n = 5;
    System.out.println();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(" *");
      }
      System.out.println();
    }
    System.out.println();
  }
}