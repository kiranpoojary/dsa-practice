package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 3, 6, 24, 8, 19, 5, 1 };
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;

            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
