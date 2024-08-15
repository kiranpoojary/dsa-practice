package com.tuf.recursion;

public class SumOfN {

    public int sum(int n, int sum) {
        if (n == 0) {
            return sum;
        } else {
            return sum(n - 1, sum + n);
        }
    }

    public int sum2(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sum2(n - 1);
        }
    }

    public static void main(String[] args) {
        SumOfN s = new SumOfN();
        System.out.println("way-1 :" + s.sum(3, 0));
        System.out.println("way-2 :" + s.sum2(3));
    }
}
