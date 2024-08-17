package com.tuf.arr.medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeadersOfArray {

    public List<Integer> getLeadersBrute(List<Integer> arr) { // TC: O(n2) ; SC: O(n)
        List<Integer> leaders = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                leaders.add(arr.get(i));
        }
        return leaders;
    }

    public List<Integer> getLeadersOptimal(List<Integer> arr) { // O(n)
        int rightMax = Integer.MIN_VALUE;
        List<Integer> leaders = new ArrayList<>();
        for (int i = arr.size() - 1; i >= 0; i--) { // O(n)
            if (arr.get(i) > rightMax) {
                leaders.add(arr.get(i));
                rightMax = arr.get(i);
            }
        }
        leaders.sort(Comparator.reverseOrder());
        return leaders;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 22, 12, 3, 0, 6));
        LeadersOfArray l = new LeadersOfArray();
        System.out.println("getLeadersBrute   : " + l.getLeadersBrute(arr));
        System.out.println("getLeadersOptimal : " + l.getLeadersOptimal(arr));

    }
}
