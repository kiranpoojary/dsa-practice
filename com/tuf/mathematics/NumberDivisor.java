package com.tuf.mathematics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberDivisor {
    public static void main(String[] args) {
        int num = 36;
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            System.out.println(i % num);
            if (num % i == 0) {
                divisors.add(i);
                if (i != (num / i))
                    divisors.add(num / i);
            }

        }
        divisors.sort(null);
        System.out.println("Devisors :" + divisors);
    }
}
