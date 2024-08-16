package arr.easy;

public class LinearSearch {

    public int searchLinear(int[] arr, int num) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 9, 0, 3, 6, 2, 4 };
        LinearSearch l = new LinearSearch();
        System.out.println(l.searchLinear(arr, 3));

    }
}
