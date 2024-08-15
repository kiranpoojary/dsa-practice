package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 3, 6, 24, 8, 19, 5, 1 };
        for (int i = 0; i <= arr.length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int currentNum = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = currentNum;

        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
