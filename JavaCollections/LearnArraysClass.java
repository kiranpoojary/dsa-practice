import java.lang.reflect.Array;
import java.util.Arrays;

public class LearnArraysClass {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("binary search index  " + index);
        Arrays.sort(numbers);
        System.out.println(numbers);
        Arrays.fill(numbers, 11);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
