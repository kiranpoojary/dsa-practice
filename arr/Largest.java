package arr;

import java.util.ArrayList;
import java.util.Iterator;

public class Largest {

    public int sortAndFindLargest(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int ele : arr) {
            arrayList.add(ele);
        }
        arrayList.sort(null);
        return arrayList.get(arrayList.size() - 1);
    }

    public int findLargest(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    public int sortAndFindSecondLargest(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int ele : arr) {
            arrayList.add(ele);
        }
        arrayList.sort(null);
        int secondLargest = arrayList.getLast();
        for (int i = arrayList.size() - 2; i >= 0; i--) {
            int item = arrayList.get(i);
            if (item != secondLargest) {
                secondLargest = item;
                break;
            }
        }
        return secondLargest;
    }

    public int findSecondLargest(int[] arr) {
        int largest = arr[0] > arr[1] ? arr[0] : arr[1];
        int secLargest = arr[0] > arr[1] ? arr[1] : arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            }
        }
        return secLargest;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 33, 12, 2, 9, 6, 8, 67, 0, 3 };
        Largest l = new Largest();
        System.out.println("l.sortAndFindLargest(arr)        : " + l.sortAndFindLargest(arr));
        System.out.println("l.findLargest(arr)               : " + l.findLargest(arr));
        System.out.println("l.sortAndFindSecondLargest(arr)  : " + l.sortAndFindSecondLargest(arr));
        System.out.println("l.findSecondLargest(arr)         : " + l.findSecondLargest(arr));

    }
}
