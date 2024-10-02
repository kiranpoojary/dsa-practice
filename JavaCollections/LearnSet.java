import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LearnSet {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>(); // no sort/ordering
        System.out.println("set.isEmpty()  " + set.isEmpty());

        set.add(22);
        set.add(35);
        set.add(72);
        set.add(7272);
        set.add(46);
        System.out.println(set);
        System.out.println("set.size()  " + set.size());
        System.out.println("set.isEmpty()  " + set.isEmpty());
        System.out.println("set.contains(7272)  " + set.contains(7272));
        set.remove(7272);
        System.out.println(set);
        System.out.println("set.contains(7272)  " + set.contains(7272));
        Set<Integer> set2 = new HashSet<>();
        set2.add(35);
        set2.add(72);
        System.out.println("set.containsAll(set2) " + set.containsAll(set2));
        set.clear();
        System.out.println(set);

    }
}
