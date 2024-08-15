package com.tuf.recursion;

public class Counter {
    int count = 0;

    public int printCount() {
        if (count == 5) {
            return count;
        } else {
            System.out.println(count);
            ++count;
            return printCount();
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.printCount();

    }
}
