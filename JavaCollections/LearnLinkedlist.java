import java.util.LinkedList;
import java.util.Queue;

public class LearnLinkedlist {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10); // returns true/false
        queue.offer(12);
        queue.offer(13);
        queue.add(14); // returns true/exception
        System.out.println(queue);
        System.out.println(queue.poll()); // return and remove head/null
        System.out.println(queue.remove()); // return and remove head/exception on empty
        System.out.println(queue);
        System.out.println(queue.peek()); // returns ele/null on empty
        System.out.println(queue.element()); // returns ele/exception on empty

    }
}
