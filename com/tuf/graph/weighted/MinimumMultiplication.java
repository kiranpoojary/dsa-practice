package com.tuf.graph.weighted;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PairMinMul {
    int first, second;

    public PairMinMul(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class MinimumMultiplication {

    public static int getMinStepToEnd(int[] nums, int start, int end) {
        Queue<PairMinMul> q = new LinkedList<>();
        int n = nums.length;
        int[] distance = new int[100000];
        Arrays.fill(distance, (int) 1e9);
        q.add(new PairMinMul(start, 0));
        distance[start] = 0;
        int mod = 100000;
        while (!q.isEmpty()) {
            PairMinMul p = q.poll();
            int node = p.first;
            int step = p.second;
            for (int i = 0; i < n; i++) {
                int mul = (node * nums[i]) % mod;
                ;
                if (step + 1 < distance[mul]) {
                    distance[mul] = (step + 1);
                    if (mul == end)
                        return step + 1;
                    q.add(new PairMinMul(mul, step + 1));
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 65 };
        int start = 7;
        int end = 66175;
        System.out.println(
                "Min step to reach from " + start + " to " + end + " is  :" + getMinStepToEnd(nums, start, end));
    }
}
