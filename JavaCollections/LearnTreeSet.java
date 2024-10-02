import java.util.Set;
import java.util.TreeSet;

public class LearnTreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(); // sort by keys
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
        set.clear();
        System.out.println(set);

    }

}
