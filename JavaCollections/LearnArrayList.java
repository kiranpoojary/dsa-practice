import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnArrayList {
    // Description: array has fixed length, but array list are dynamic in length
    public static void main(String args[]) {
        ArrayList<String> studentsName = new ArrayList<>();
        System.out.println(studentsName.size());
        studentsName.add("Kiran");
        studentsName.add("Archana");
        studentsName.add("Ekta");
        System.out.println(studentsName);
        System.out.println(studentsName.size());

        // **************
        List<Integer> numList = new ArrayList<>(); // u can declare array list like this also
        numList.add(10);
        numList.add(20);
        numList.add(30);
        System.out.println(numList);
        numList.add(1, 15);
        System.out.println(numList);

        // **************
        ArrayList<Integer> newNums = new ArrayList<>();
        newNums.add(60);
        newNums.add(70);
        numList.addAll(newNums);
        System.out.println(numList);

        // **************
        ArrayList<Integer> newNumsTwo = new ArrayList<>();
        newNumsTwo.add(40);
        newNumsTwo.add(50);
        numList.addAll(4, newNumsTwo);
        System.out.println(numList);

        // *******************
        System.out.println("\nnumList.get(index:0);");
        System.out.println(numList.get(0));

        System.out.println("\nnumList.get(index:1);");
        System.out.println(numList.get(1));

        // ****************
        System.out.println("\nnumList.remove(index:2);");
        numList.remove(1);
        System.out.println(numList);

        System.out.println("\nInteger.valueOf(value:70)");
        numList.remove(Integer.valueOf(70));
        System.out.println(numList);

        System.out.println("\nnumList.set(index:2, value:25);");
        numList.set(2, 25);
        System.out.println(numList);

        System.out.println("\nnumList.contains(value:40);");
        System.out.println(numList.contains(40));

        System.out.println("\nLOOP-1 : for");
        for (int i = 0; i < newNumsTwo.size(); i++) {
            System.out.println(newNumsTwo.get(i));
        }

        System.out.println("\nLOOP-2 : forEach");
        for (Integer ele : newNumsTwo) {
            System.out.println(ele);
        }

        System.out.println("\nLOO3-2 : Iterator");
        Iterator<Integer> it = newNumsTwo.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nnumList.clear();");
        numList.clear();
        System.out.println(numList);

    }
}
