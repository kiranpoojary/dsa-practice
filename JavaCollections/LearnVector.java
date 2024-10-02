import java.util.Iterator;
import java.util.Vector;

public class LearnVector {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.addElement(10);
        v.add(20);
        System.out.println(v);
        v.addAll(v);
        System.out.println(v);

        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("contains  " + v.contains(20));
        v.remove(0);
        System.out.println(v);
        v.clear();
        System.out.println(v);

    }
}
