package sorting;

public class QuickSort {

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[low];
        arr[low] = arr[j];
        arr[j] = t;
        return j;
    }

    public void quickSorter(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSorter(arr, low, pIndex - 1);
            quickSorter(arr, pIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 3, 6, 24, 8, 19, 5, 1 };
        QuickSort qs = new QuickSort();
        qs.quickSorter(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
