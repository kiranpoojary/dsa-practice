package com.tuf.mathematics;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        int num = 11;
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                ++count;
                if (i != (num / i))
                    ++count;
            }
        }
        System.out.println(count);
        if (count > 2)
            System.out.println("Not A Prime Number");
        else
            System.out.println("Prime Number");
    }
}
