package arr.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TwoSum {
    public boolean hasTwoSumBrute(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i == j)
                    continue;
                else if ((arr[i] + arr[j]) == sum)
                    return true;
            }
        }
        return false;
    }

    public boolean hasTwoSumBetter(int[] arr, int sum) {
        Map<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < arr.length; i++) {
            int requiredNum = sum - arr[i];
            if (map.containsKey(requiredNum)) {
                return true;// return [map.get(requiredNum), i]
            } else
                map.put(arr[i], i);
        }
        return false;
    }

    public boolean hasTwoSumBetterTwo(int[] arr, int sum) {
        // sort nLogn
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }

            }
        }
        // then two pointer approach
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if ((arr[left] + arr[right]) == sum) {
                return true; // return [left, right]
            } else if ((arr[left] + arr[right]) > sum)
                --right;
            else
                ++left;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 4, 1, 2, 6 };
        TwoSum t = new TwoSum();
        // System.out.println(t.hasTwoSumBrute(arr, 14));
        // System.out.println(t.hasTwoSumBetter(arr, 14));
        System.out.println(t.hasTwoSumBetterTwo(arr, 14));
    }
}
