import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearnPriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>(); // default lowest is the priority(only one lowest ele is placed at
                                                   // the top, rest is insertion order)
        pq.offer(43); // returns true/false
        pq.offer(19);
        pq.offer(23);
        pq.add(84); // returns true/exception
        System.out.println(pq);
        System.out.println(pq.poll()); // return and remove head/null
        System.out.println(pq.remove()); // return and remove head/exception on empty
        System.out.println(pq);
        System.out.println(pq.peek()); // returns ele/null on empty
        System.out.println(pq.element()); // returns ele/exception on empty

        System.out.println("---------------------");
        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // highest is the priority(highest ele is
                                                                             // placed at the top, rest is
        // insertion order)
        pq2.offer(43); // returns true/false
        pq2.offer(19);
        pq2.offer(23);
        pq2.add(84); // returns true/exception
        System.out.println(pq2);
        System.out.println(pq2.poll()); // return and remove head/null
        System.out.println(pq2.remove()); // return and remove head/exception on empty
        System.out.println(pq2);
        System.out.println(pq2.peek()); // returns ele/null on empty
        System.out.println(pq2.element()); // returns ele/exception on empty
    }
}
