package com.tuf.recursion;

public class PalindromeString {

    public boolean checkPalindrome(String str, int i) {
        if (i >= str.length() / 2)
            return true;
        else if (str.charAt(i) != str.charAt(str.length() - i - 1))
            return false;
        else
            return checkPalindrome(str, i + 1);
    }

    public static void main(String[] args) {
        PalindromeString p = new PalindromeString();
        System.out.println(p.checkPalindrome("MADAM", 0));
    }
}
