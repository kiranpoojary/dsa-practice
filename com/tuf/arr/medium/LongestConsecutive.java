package com.tuf.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LongestConsecutive {

    public int getConsecutiveBrute(List<Integer> arr) { // TC: O(n)+O(n^2), SC: O(1)
        int allTimeHighConsecutive = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) { // O(n)
            int currentHigh = 1;
            int nextNumber = arr.get(i) + 1;
            while (arr.contains(nextNumber)) { // O(n^2)
                ++nextNumber;
                ++currentHigh;
            }

            allTimeHighConsecutive = Math.max(allTimeHighConsecutive, currentHigh);

        }
        return allTimeHighConsecutive;
    }

    public int getConsecutiveBetter(List<Integer> arr) {
        int highestConsecutiveCount = 0;
        int currentConsecutiveCount = 0;
        int prevSmall = Integer.MIN_VALUE;
        arr.sort(null);
        for (int i = 0; i < arr.size(); i++) {
            if (prevSmall == arr.get(i) - 1) {
                ++currentConsecutiveCount;
                prevSmall = arr.get(i);
            } else if (prevSmall != arr.get(i)) {
                currentConsecutiveCount = 1;
                prevSmall = arr.get(i);
            }

            highestConsecutiveCount = Math.max(highestConsecutiveCount, currentConsecutiveCount);

        }
        return highestConsecutiveCount;
    }

    public int getConsecutiveOptimal(List<Integer> arr) { // TC: O(n) + O(2n)
        Set<Integer> st = new HashSet<>();
        for (Integer ele : arr) { // TC: O(n)
            st.add(ele);
        }
        System.out.println(st);
        int maxCount = 0;
        int currCount = 0;
        Iterator<Integer> it = st.iterator();
        while (it.hasNext()) { // TC: O(n)
            Integer ele = it.next();
            if (!st.contains(ele - 1)) {
                for (int i = 0; i < arr.size(); i++) { // TC: O(n)
                    if (st.contains((ele))) {
                        ++ele;
                        ++currCount;
                    } else {
                        break;
                    }
                }
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }

        }
        return maxCount;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(102, 4, 100, 1, 101, 3, 2, 1, 1));
        LongestConsecutive l = new LongestConsecutive();
        System.out.println("getConsecutiveBrute  : " + l.getConsecutiveBrute(arr));
        System.out.println("getConsecutiveBetter : " + l.getConsecutiveBetter(arr));
        System.out.println("getConsecutiveOptimal: " + l.getConsecutiveOptimal(arr));

    }
}
