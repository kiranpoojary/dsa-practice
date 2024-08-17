package com.tuf.arr.easy;

public class MaxConsecutiveNum {

    public int maxConsecutiveCount(int[] arr, int num) {
        int currCount = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                ++currCount;
                if (maxCount < currCount) {
                    maxCount = currCount;
                }
            } else {
                currCount = 0;
            }

        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 1, 4, 5, 6, 1, 1, 1, 1, 8, 9, 1 };

        MaxConsecutiveNum mx = new MaxConsecutiveNum();
        System.out.println(mx.maxConsecutiveCount(arr, 1));
    }
}
