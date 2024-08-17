package com.tuf.arr.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NotAppearedTwice {

    public int notTwice(int[] arr) {// tc:O(n^2); sc: O(1)
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    ++count;

                if (count == 2)
                    break;
            }
            if (count == 1)
                return arr[i];

        }

        return -1;
    }

    public int NotAppearedTwiceBetter(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(arr[i]))
                m.put(arr[i], m.get(3) + 1);
            else
                m.put(arr[i], 1);
        }
        for (int key : m.keySet()) {
            if (m.get(key) == 1)
                return key;
        }
        return -1;
    }

    public int NotAppearedTwiceOptimal(int[] arr) {
        int XOR = 0;
        for (int i = 0; i < arr.length; i++) {
            XOR = XOR ^ arr[i];
        }
        return XOR;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2, 4, 5, 4, 5 };
        NotAppearedTwice n = new NotAppearedTwice();
        System.out.println(n.notTwice(arr));
        System.out.println(n.NotAppearedTwiceBetter(arr));
        System.out.println(n.NotAppearedTwiceOptimal(arr));

    }
}
