package com.tuf.arr.medium;

public class LongestSubArraySumKadens {
    // find a sub array with max sum(includes negatives😢)

    public int maxSumSubArrayBrute(int[] arr) { // O(n^3)
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSumSubArrayBetter(int[] arr) { // O(n^2)
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;

    }

    public int maxSumSubArrayKadensOptimal(int[] arr) { // TC: O(n); SC: O(1)
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        int startTrack = 0;
        int arrStartIndex = -1;
        int arrEndIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (currSum == 0)
                startTrack = i; // for start and end index

            currSum = currSum + arr[i];
            if (currSum > max) {
                arrStartIndex = startTrack; // for start and end index
                arrEndIndex = i; // for start and end index
                max = currSum;
            }
            if (currSum < 0)
                currSum = 0;
        }
        System.out.println("start:" + arrStartIndex + "; end :" + arrEndIndex); // for start and end index
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -3, 5, -2, 0, 4, -1 };
        LongestSubArraySumKadens s = new LongestSubArraySumKadens();
        System.out.println(s.maxSumSubArrayBrute(arr));
        System.out.println(s.maxSumSubArrayBetter(arr));
        System.out.println("-----------maxSumSubArrayKadensOptimal--------");
        System.out.println(s.maxSumSubArrayKadensOptimal(arr));
    }
}
