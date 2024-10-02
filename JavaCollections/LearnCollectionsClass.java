import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnCollectionsClass {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(33);
        arr.add(39);
        arr.add(2);
        arr.add(65);
        arr.add(75);
        arr.add(33);
        arr.add(86);
        System.out.println("Min " + Collections.min(arr));
        System.out.println("Max " + Collections.max(arr));
        System.out.println("Frequency of 33 is" + Collections.frequency(arr, 33));
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.sort(arr, Comparator.reverseOrder());
        System.out.println(arr);
    }
}
