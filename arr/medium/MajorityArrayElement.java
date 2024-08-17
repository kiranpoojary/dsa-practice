package arr.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MajorityArrayElement {

    public int majorityEleBrute(int[] arr) { // majority means appeared > n/2 time : ts: O(n^2)
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    ++count;
            }
            if (count > arr.length / 2)
                return arr[i];
        }
        return -1;
    }

    public int majorityEleBetter(int[] arr) {
        Map<Integer, Integer> mp = new TreeMap(); // O(nlogn)
        for (int i : arr) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
            }
        }

        for (Integer key : mp.keySet()) { // O(n)
            if (mp.get(key) > (arr.length / 2))
                return key;

        }
        return -1; // TC:- O(nlogn)+O(n)
    }

    public int majorityEleOptimal(int[] arr) { // O(n)
        int count = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                num = arr[i];
            } else if (arr[i] == num)
                ++count;
            else
                --count;
        }
        int finalMaxCount = 0;
        for (int i : arr) {
            if (i == num)
                ++finalMaxCount;
        }
        if (finalMaxCount > (arr.length / 2))
            return num;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 2, 2, 3, 2, 3, 2 };
        MajorityArrayElement m = new MajorityArrayElement();
        System.out.println("m.majorityEleBrute(arr)    :" + m.majorityEleBrute(arr));
        System.out.println("m.majorityEleBetter(arr)   :" + m.majorityEleBetter(arr));
        System.out.println("m.majorityEleOptimal(arr)  :" + m.majorityEleOptimal(arr));
    }
}
