package arr.easy;

import java.util.ArrayList;

public class SortedTwoArrayIntersection {

    public ArrayList<Integer> intersectArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (!ans.isEmpty()) {
                        if (ans.getLast() != arr1[i]) {
                            ans.add((arr1[i]));
                        }
                    } else {
                        ans.add((arr1[i]));
                    }

                }
                if (arr2[j] > arr1[i])
                    break;
            }
        }
        return ans;
    }

    public ArrayList<Integer> intersectArrayOptimal(int arr1[], int arr2[]) {
        ArrayList<Integer> op = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                ++i;
            } else if (arr2[j] < arr1[i]) {
                ++j;
            } else {
                op.add(arr1[i]);
                ++i;
                ++j;
            }
        }
        return op;

    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 8 };
        int[] arr2 = { 2, 4, 5, 6, 7, 8, 9 };
        SortedTwoArrayIntersection i = new SortedTwoArrayIntersection();
        System.out.println(i.intersectArray(arr1, arr2));
        System.out.println(i.intersectArrayOptimal(arr1, arr2));
    }
}
