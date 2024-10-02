package com.tuf.graph.otherapplied;

import java.util.*;

public class WordLadderTwo {
    public static ArrayList<ArrayList<String>> getWordLadderLenght(String[] wordList, String startWord,
            String targetWord) {
        Queue<ArrayList<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(startWord)));
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            set.add(wordList[i]);
        }

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int level = 0;
        while (!q.isEmpty()) {
            ArrayList<String> vec = q.poll();
            if (vec.size() > level) {
                ++level;
                for (String str : usedOnLevel) {
                    set.remove(str);
                }
            }

            String word = vec.getLast();
            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size())
                    ans.add(vec);
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordCharArray = word.toCharArray();
                    wordCharArray[i] = ch;
                    String transformedString = new String(wordCharArray);
                    if (set.contains(transformedString)) {
                        vec.add(transformedString);
                        ArrayList<String> tmp = new ArrayList<>(vec);
                        q.add(new ArrayList<>(tmp));
                        usedOnLevel.add(transformedString);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
        String startWord = "hit";
        String targetWord = "cog";
        System.out
                .println("Word ladders are   :" +
                        WordLadderTwo.getWordLadderLenght(wordList, startWord, targetWord));
    }
}
