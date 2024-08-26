package com.tuf.searching.bs;

public class MissingKthPositiveNum {
    // given a n natural +ve numbers with missings
    // find kth missing num

    public static int getKthMissingBrute(int[] nums, int k) { // O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k) {
                ++k;
            } else
                break;
        }
        return k;
    }

    public static int getKthMissingBS(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalMissing = arr[mid] - (mid + 1);

            if (totalMissing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // When high is -1, it means k is before the first element of the array
        if (high == -1) {
            return k;
        }

        int totalMissingBehind = arr[high] - (high + 1);
        int RequiredMissingAhead = k - totalMissingBehind;
        int kthMissing = arr[high] + RequiredMissingAhead;

        return kthMissing;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 11 };
        System.out.println("Missing Kth Ele Brute    : " + getKthMissingBrute(nums, 3));
        System.out.println("Missing Kth Ele BS       : " + getKthMissingBS(nums, 3));
    }
}
