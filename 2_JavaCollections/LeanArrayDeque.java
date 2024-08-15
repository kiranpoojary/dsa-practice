import java.util.ArrayDeque;

public class LeanArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.offer(33);
        adq.offer(53);
        System.out.println(adq);
        adq.offerFirst(21);
        System.out.println(adq);
        adq.offerLast(88);
        System.out.println(adq);
        System.out.println("-------------- PEEK -----------");
        System.out.println(adq);
        System.out.println("adq.peek  " + adq.peek());
        System.out.println("adq.peekFirst  " + adq.peekFirst());
        System.out.println("adq.peekLast  " + adq.peekLast());
        System.out.println("-------------- POLL -----------");
        System.out.println("adq  " + adq);
        System.out.println("adq.poll  " + adq.poll());
        System.out.println("adq.pollFirst  " + adq.pollFirst());
        System.out.println("adq.pollLast  " + adq.pollLast());
        System.out.println(adq);

    }
}
