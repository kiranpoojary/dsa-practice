package com.tuf.hashing;

public class HashingOne {
    public static void main(String[] args) {
        // find the count of each number with O(n)
        int[] nums = { 1, 4, 7, 3, 6, 9, 5, 0, 8, 3, 1, 3 };
        int[] numCounts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numCounts[nums[i]] = ++numCounts[nums[i]];
        }
        for (int i = 0; i < numCounts.length; i++) {
            System.out.println(i + ":-" + numCounts[i]);
        }

    }
}
