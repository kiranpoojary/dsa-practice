package arr.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedTwoArrayUnion {

    public ArrayList<Integer> arrayUnion(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrOP = new ArrayList<>();
        SortedSet<Integer> st = new TreeSet<>();
        for (Integer ele : arr1) {
            st.add(ele);
        }
        for (Integer ele : arr2) {
            st.add(ele);
        }
        Iterator<Integer> it = st.iterator();
        while (it.hasNext()) {
            arrOP.add(it.next());
        }
        return arrOP;
    }

    public ArrayList<Integer> arrayUnionOptimal(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrOP = new ArrayList<>();

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (arrOP.size() == 0 || arrOP.get(arrOP.size() - 1) != arr1[i]) {
                    arrOP.add(arr1[i]);
                }
                ++i;
            } else {
                if (arrOP.size() == 0 || arrOP.get(arrOP.size() - 1) != arr2[j]) {
                    arrOP.add(arr2[j]);
                }
                ++j;
            }

        }

        while (i < n1) {
            if (arrOP.size() == 0 || arrOP.get(arrOP.size() - 1) != arr1[i]) {
                arrOP.add(arr1[i]);
                ++i;
            }
        }

        while (j < n2) {
            if (arrOP.size() == 0 || arrOP.get(arrOP.size() - 1) != arr2[j]) {
                arrOP.add(arr2[j]);
                ++j;
            }
        }
        return arrOP;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 7, 8, 9 };
        int[] arr2 = { 0, 2, 5, 6, 7, 8 };
        SortedTwoArrayUnion u = new SortedTwoArrayUnion();
        // System.out.println(u.arrayUnion(arr1, arr2));
        System.out.println(u.arrayUnionOptimal(arr1, arr2));

    }
}
