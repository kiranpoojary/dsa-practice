package com.tuf.arr.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeOverlaps {

    public List<List<Integer>> getOverlapBrute(int[][] arr) { // O(2n)+O(nlogn) SC: O(n)
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (!ans.isEmpty() && end <= ans.getLast().get(1)) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                int currStart = arr[j][0];
                int currEnd = arr[j][1];
                if (currStart <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }

    public List<List<Integer>> getOverlapBetter(int[][] arr) { // TC: O(nLogn)+O(n) ; SC: O(n)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.getLast().get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                int oldStart = ans.getLast().get(0);
                int oldEnd = ans.getLast().get(1);
                int newEnd = oldEnd > arr[i][1] ? oldEnd : arr[i][1];
                ans.set(ans.size() - 1, Arrays.asList(oldStart, newEnd));

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
        MergeOverlaps m = new MergeOverlaps();
        System.out.println("Brute    :" + m.getOverlapBrute(arr));
        System.out.println("Better   :" + m.getOverlapBetter(arr));
    }
}
