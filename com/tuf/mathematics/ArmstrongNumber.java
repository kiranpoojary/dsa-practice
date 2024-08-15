package com.tuf.mathematics;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int tempNum = num;
        int cubeSum = 0;
        while (tempNum > 0) {
            int digi = tempNum % 10;
            cubeSum += digi * digi * digi;
            tempNum /= 10;
        }

        if (cubeSum == num)
            System.out.println("Armstong Number");
        else
            System.out.println("NOT Armstong Number");

    }
}
