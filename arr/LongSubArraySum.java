package arr;

import java.util.HashMap;
import java.util.Map;

public class LongSubArraySum {

    public int subArraySum(int[] arr, int sum) {
        int sumLen = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += arr[j];
                if (currSum == sum) {
                    sumLen = Math.max(sumLen, j - i + 1);
                    break;
                } else if (currSum > sum)
                    break;
            }
        }
        return sumLen;
    }

    public int subArraySumBetter(int[] arr, int sum) { // optimal solution for positive negatives and zeros, but better
                                                       // for zero and negatives
        Map<Integer, Integer> bucket = new HashMap<>();
        int maxLength = 0;
        int currPrefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currPrefixSum += arr[i];
            if (currPrefixSum == sum) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int rem = currPrefixSum - sum;
            if (bucket.containsKey(rem)) {
                int newLength = i - bucket.get(rem);
                maxLength = Math.max(maxLength, newLength);
            }

            if (!bucket.containsKey(currPrefixSum))
                bucket.put(currPrefixSum, i);

        }
        return maxLength;
    }

    public int subArraySumOptimal(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int sum = arr[0];
        while (right < n) {
            while (left <= right && sum > k) {
                sum = sum - arr[left];
                ++left;
            }
            if (sum == k)
                maxLength = Math.max(maxLength, right - left + 1);

            ++right;
            if (right < n) {
                sum += arr[right];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        LongSubArraySum s = new LongSubArraySum();
        System.out.println("subArraySum(arr, 4)        : " + s.subArraySum(arr, 3));
        System.out.println("subArraySumBetter(arr, 4)  : " + s.subArraySumBetter(arr, 3));
        System.out.println("subArraySumOptimal(arr, 4) : " + s.subArraySumOptimal(arr, 3));
    }
}
