package com.tuf.graph.otherapplied;

import java.util.*;

class Pair {
    String first;
    int second;

    public Pair(String str, int step) {
        this.first = str;
        this.second = step;
    }
}

public class WordLadderOne {
    public static int getWordLadderLenght(String[] wordList, String startWord,
            String targetWord) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Pair(startWord, 1));
        for (int i = 0; i < wordList.length; i++) {
            set.add(wordList[i]);
        }
        set.remove(startWord);
        while (!q.isEmpty()) {
            Pair top = q.poll();
            String word = top.first;
            int step = top.second;
            if (word.equals(targetWord)) {
                return step;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordCharArray = word.toCharArray();
                    wordCharArray[i] = ch;
                    String transformedString = new String(wordCharArray);
                    if (set.contains(transformedString)) {
                        set.remove(transformedString);
                        q.add(new Pair(transformedString, step + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
        String startWord = "hit";
        String targetWord = "cog";
        System.out
                .println("Word ladder length is :" +
                        WordLadderOne.getWordLadderLenght(wordList, startWord, targetWord));
    }
}
