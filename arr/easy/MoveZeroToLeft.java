package arr.easy;

import java.util.ArrayList;

public class MoveZeroToLeft {

    public void moveToLeft(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }
        for (int i = temp.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public void moveToLeftOptimal(int[] arr) {
        int nextPtr = -1;
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                nextPtr = i;
                break;
            }
        }
        if (nextPtr > -1) {
            for (int i = nextPtr + 1; i < arr.length; i++) {
                if (arr[i] != 0) {
                    // swap
                    arr[nextPtr] = arr[i];
                    arr[i] = 0;
                    ++nextPtr;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 0, 9, 0, 3, 6, 0, 4 };
        int[] arr2 = { 0, 5, 9, 0, 3, 6, 0, 4 };
        MoveZeroToLeft mv = new MoveZeroToLeft();
        mv.moveToLeft(arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        mv.moveToLeftOptimal(arr2);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

}
