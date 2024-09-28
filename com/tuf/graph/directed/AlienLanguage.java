package com.tuf.graph.directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlienLanguage {

    public static String arrageAlienLetters(String[] word, int noOfAlphabets) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(noOfAlphabets);
        for (int i = 0; i < noOfAlphabets; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < word.length - 1; i++) {
            String str1 = word[i];
            String str2 = word[i + 1];
            int len = Math.min(str1.length(), str2.length());
            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    adjList.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topoCharCodes = TopologicalSort.getTopologicalOrder(adjList);
        String str = "";
        for (int charCode : topoCharCodes) {
            char character = (char) (charCode + 97);
            str += character + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println("Alien Letter Orders   :" + AlienLanguage.arrageAlienLetters(words, 4));
    }
}
