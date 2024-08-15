package arr;

public class IsSortedArray {

    public boolean isSortedAcending(int[] arr) {
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public boolean isSortedDecending(int[] arr) {
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 7, 8, 60, 79 };
        IsSortedArray checkSorted = new IsSortedArray();
        System.out.println("checkSorted.isSortedAcending(arr)  : " + checkSorted.isSortedAcending(arr));
        System.out.println("checkSorted.isSortedDecending      : " + checkSorted.isSortedDecending(arr));

    }
}
