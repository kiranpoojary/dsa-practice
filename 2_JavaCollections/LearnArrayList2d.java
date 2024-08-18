import java.util.ArrayList;
import java.util.List;

public class LearnArrayList2d {
    public static void main(String[] args) {
        // Create the 2D ArrayList
        List<List<Integer>> arrayList2D = new ArrayList<>();

        // Populate the 2D ArrayList
        arrayList2D.add(new ArrayList<>(List.of(1, 2, 3, 4)));
        arrayList2D.add(new ArrayList<>(List.of(5, 6, 7, 8)));
        arrayList2D.add(new ArrayList<>(List.of(9, 10, 11, 12)));
        arrayList2D.add(new ArrayList<>(List.of(13, 14, 15, 16)));

        // Print the 2D ArrayList
        for (List<Integer> row : arrayList2D) {
            System.out.println(row);
            if (row.get(3) > 10)
                System.out.println(row.get(3));

        }
    }
}
