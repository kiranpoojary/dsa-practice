package com.tuf.recursion;

public class PrintNTimes {

    public int printNameNTimes(String name, int n) {
        if (n == 0)
            return 0;
        else {
            System.out.println(name);
            return printNameNTimes(name, n - 1);
        }
    }

    public static void main(String[] args) {
        PrintNTimes r = new PrintNTimes();
        r.printNameNTimes("Kiran", 5);
    }
}
