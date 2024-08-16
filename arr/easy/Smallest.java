package arr.easy;

import java.util.ArrayList;
import java.util.Iterator;

public class Smallest {

    public int sortAndFindSmallest(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int ele : arr) {
            arrayList.add(ele);
        }
        arrayList.sort(null);
        return arrayList.get(0);
    }

    public int findSmallest(int[] arr) {
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest)
                smallest = arr[i];
        }
        return smallest;
    }

    public int sortAndFindSecondSmallest(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int ele : arr) {
            arrayList.add(ele);
        }
        arrayList.sort(null);
        int secondSmallest = arrayList.getFirst();
        for (int i = 1; i < arrayList.size() - 1; i++) {
            int item = arrayList.get(i);
            if (item != secondSmallest) {
                secondSmallest = item;
                break;
            }
        }
        return secondSmallest;
    }

    public int findSecondSmallest(int[] arr) {
        int smallest = arr[0] < arr[1] ? arr[0] : arr[1];
        int secSmallest = arr[0] > arr[1] ? arr[1] : arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secSmallest = smallest;
                smallest = arr[i];
            }
        }
        return secSmallest;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 33, 12, 2, 9, 6, 8, 67, 0, 3 };
        Smallest sm = new Smallest();
        System.out.println("l.sortAndFindSmallest(arr)        : " + sm.sortAndFindSmallest(arr));
        System.out.println("sm.findSmallest(arr)               : " + sm.findSmallest(arr));
        System.out.println("sm.sortAndFindSecondSmallest(arr)  : " + sm.sortAndFindSecondSmallest(arr));
        System.out.println("sm.findSecondSmallest(arr)         : " + sm.findSecondSmallest(arr));

    }
}
