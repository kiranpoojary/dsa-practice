package arr.easy;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

    public int getArrayUniqueCount(int[] arr) {
        Set<Integer> st = new LinkedHashSet<>();
        for (Integer ele : arr) {
            st.add(ele);
        }
        Iterator<Integer> it = st.iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i] = it.next();
            ++i;
        }
        for (Integer ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        return st.size();
    }

    public int getArrayUniqueCountOptimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                ++i;
            }
        }

        for (Integer ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();

        return i + 1;
    }

    public static void main(String[] args) {
        // from sorted array
        int[] arr = { 1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9 };
        int[] arr2 = { 1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9 };
        RemoveDuplicate rd = new RemoveDuplicate();
        System.out.println("getArrayUniqueCount          : " + rd.getArrayUniqueCount(arr));
        System.out.println("getArrayUniqueCountOptimal   : " + rd.getArrayUniqueCountOptimal(arr2));
    }
}
